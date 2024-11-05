/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package org.apache.skywalking.apm.agent.core.context;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.locks.ReentrantLock;

import lombok.AccessLevel;
import lombok.Getter;
import org.apache.skywalking.apm.agent.core.boot.ServiceManager;
import org.apache.skywalking.apm.agent.core.conf.Config;
import org.apache.skywalking.apm.agent.core.conf.dynamic.watcher.SpanLimitWatcher;
import org.apache.skywalking.apm.agent.core.context.ids.DistributedTraceId;
import org.apache.skywalking.apm.agent.core.context.ids.PropagatedTraceId;
import org.apache.skywalking.apm.agent.core.context.trace.AbstractSpan;
import org.apache.skywalking.apm.agent.core.context.trace.AbstractTracingSpan;
import org.apache.skywalking.apm.agent.core.context.trace.EntrySpan;
import org.apache.skywalking.apm.agent.core.context.trace.ExitSpan;
import org.apache.skywalking.apm.agent.core.context.trace.ExitTypeSpan;
import org.apache.skywalking.apm.agent.core.context.trace.LocalSpan;
import org.apache.skywalking.apm.agent.core.context.trace.NoopExitSpan;
import org.apache.skywalking.apm.agent.core.context.trace.NoopSpan;
import org.apache.skywalking.apm.agent.core.context.trace.TraceSegment;
import org.apache.skywalking.apm.agent.core.context.trace.TraceSegmentRef;
import org.apache.skywalking.apm.agent.core.logging.api.ILog;
import org.apache.skywalking.apm.agent.core.logging.api.LogManager;
import org.apache.skywalking.apm.agent.core.profile.ProfileStatusReference;
import org.apache.skywalking.apm.agent.core.profile.ProfileTaskExecutionService;
import org.apache.skywalking.apm.util.StringUtil;

/**
 * {@link ContextManager} 管理 {@link AbstractTracerContext}的子类
 * <p>
 * The <code>TracingContext</code> represents a core tracing logic controller. It build the final {@link
 * TracingContext}, by the stack mechanism, which is similar with the codes work.
 * <p>
 * 核心跟踪逻辑控制器。它通过栈机制构建最终的{@link TracingContext}
 *
 * <p>
 * In opentracing concept, it means, all spans in a segment tracing context(thread) are CHILD_OF relationship, but no
 * FOLLOW_OF.
 * <p>
 * 开放式追踪概念中 所有的Thread 是父子关系 不是兄弟关系
 * <p>
 * In skywalking core concept, FOLLOW_OF is an abstract concept when cross-process MQ or cross-thread async/batch tasks
 * happen, we used {@link TraceSegmentRef} for these scenarios. Check {@link TraceSegmentRef} which is from {@link
 * ContextCarrier} or {@link ContextSnapshot}.
 * TraceSegmentRef 用于连接跨线程、跨进程的 TraceSegment
 * TraceSegmentRef 初始化需要的数据 来源于 ContextCarrier、ContextSnapshot
 * <p>
 * TracingContext 管理当前Segment的所有Span、上下文Segment的引用
 */
public class TracingContext implements AbstractTracerContext {
    private static final ILog LOGGER = LogManager.getLogger(TracingContext.class);
    private long lastWarningTimestamp = 0;

    /**
     * @see ProfileTaskExecutionService
     */
    private static ProfileTaskExecutionService PROFILE_TASK_EXECUTION_SERVICE;

    /**
     * The final {@link TraceSegment}, which includes all finished spans.
     * 一个 TracingContext 对应一个 TraceSegment
     */
    private TraceSegment segment;

    /**
     * Active spans stored in a Stack, usually called 'ActiveSpanStack'. This {@link LinkedList} is the in-memory
     * storage-structure. <p> I use {@link LinkedList#removeLast()}, {@link LinkedList#addLast(Object)} and {@link
     * LinkedList#getLast()} instead of {@link #pop()}, {@link #push(AbstractSpan)}, {@link #peek()}
     * <p>
     * 存储在栈结构中的活动Span，
     */
    private LinkedList<AbstractSpan> activeSpanStack = new LinkedList<>();
    /**
     * @since 7.0.0 SkyWalking support lazy injection through {@link ExitTypeSpan#inject(ContextCarrier)}. Due to that,
     * the {@link #activeSpanStack} could be blank by then, this is a pointer forever to the first span, even the main
     * thread tracing has been finished.
     * <p>
     * SkyWalking 通过 {@link ExitTypeSpan#inject(ContextCarrier)} 支持延迟注入。这个firstSpan表示链表{@link #activeSpanStack}头
     */
    private AbstractSpan firstSpan = null;

    /**
     * A counter for the next span.
     * SpanId 生成器
     */
    private int spanIdGenerator;

    /**
     * The counter indicates
     * 计数器指示
     */
    @SuppressWarnings("unused") // updated by ASYNC_SPAN_COUNTER_UPDATER
    private volatile int asyncSpanCounter;
    /**
     * AtomicIntegerFieldUpdater.newUpdater(TracingContext.class, "asyncSpanCounter");
     * 专门用来更新 {@link TracingContext#asyncSpanCounter}字段 基于CAS实现 :
     * do{
     * xxx
     * } while(xxx)
     */
    private static final AtomicIntegerFieldUpdater<TracingContext> ASYNC_SPAN_COUNTER_UPDATER =
            AtomicIntegerFieldUpdater.newUpdater(TracingContext.class, "asyncSpanCounter");
    /**
     * 是否在异步模式运行
     */
    private volatile boolean isRunningInAsyncMode;
    /**
     * 可重入锁
     */
    private volatile ReentrantLock asyncFinishLock;

    /**
     * 表示当前的 {@link TracingContext} 是否在运行
     */
    private volatile boolean running;
    /**
     * 当前 {@link TracingContext} 的创建时间
     */
    private final long createTime;

    /**
     * profile status
     */
    private final ProfileStatusReference profileStatus;
    @Getter(AccessLevel.PACKAGE)
    private final CorrelationContext correlationContext;
    @Getter(AccessLevel.PACKAGE)
    private final ExtensionContext extensionContext;

    //CDS watcher 监听运行过程可以更改的配置项
    private final SpanLimitWatcher spanLimitWatcher;

    /**
     * Initialize all fields with default value.
     */
    TracingContext(String firstOPName, SpanLimitWatcher spanLimitWatcher) {
        this.segment = new TraceSegment();
        this.spanIdGenerator = 0;
        isRunningInAsyncMode = false;
        createTime = System.currentTimeMillis();
        running = true;

        // profiling status
        if (PROFILE_TASK_EXECUTION_SERVICE == null) {
            PROFILE_TASK_EXECUTION_SERVICE = ServiceManager.INSTANCE.findService(ProfileTaskExecutionService.class);
        }
        this.profileStatus = PROFILE_TASK_EXECUTION_SERVICE.addProfiling(
                this, segment.getTraceSegmentId(), firstOPName);

        this.correlationContext = new CorrelationContext();
        this.extensionContext = new ExtensionContext();
        this.spanLimitWatcher = spanLimitWatcher;
    }

    /**
     * Inject the context into the given carrier, only when the active span is an exit one.
     *
     * @param carrier to carry the context for crossing process.
     * @throws IllegalStateException if (1) the active span isn't an exit one. (2) doesn't include peer. Ref to {@link
     *                               AbstractTracerContext#inject(ContextCarrier)}
     */
    @Override
    public void inject(ContextCarrier carrier) {
        this.inject(this.activeSpan(), carrier);
    }

    /**
     * Inject the context into the given carrier and given span, only when the active span is an exit one. This method
     * wouldn't be opened in {@link ContextManager} like {@link #inject(ContextCarrier)}, it is only supported to be
     * called inside the {@link ExitTypeSpan#inject(ContextCarrier)}
     *
     * @param carrier  to carry the context for crossing process.
     * @param exitSpan to represent the scope of current injection.
     * @throws IllegalStateException if (1) the span isn't an exit one. (2) doesn't include peer.
     */
    public void inject(AbstractSpan exitSpan, ContextCarrier carrier) {
        if (!exitSpan.isExit()) {
            throw new IllegalStateException("Inject can be done only in Exit Span");
        }

        ExitTypeSpan spanWithPeer = (ExitTypeSpan) exitSpan;
        // 获取远端调用地址
        String peer = spanWithPeer.getPeer();
        if (StringUtil.isEmpty(peer)) {
            throw new IllegalStateException("Exit span doesn't include meaningful peer information.");
        }

        carrier.setTraceId(getReadablePrimaryTraceId());
        carrier.setTraceSegmentId(this.segment.getTraceSegmentId());
        carrier.setSpanId(exitSpan.getSpanId());
        carrier.setParentService(Config.Agent.SERVICE_NAME);
        carrier.setParentServiceInstance(Config.Agent.INSTANCE_NAME);
        // first() --> firstSpan 永远指向栈底
        carrier.setParentEndpoint(first().getOperationName());
        carrier.setAddressUsedAtClient(peer);

        this.correlationContext.inject(carrier);
        this.extensionContext.inject(carrier);
    }

    /**
     * Extract the carrier to build the reference for the pre segment.
     *
     * @param carrier carried the context from a cross-process segment. Ref to {@link AbstractTracerContext#extract(ContextCarrier)}
     */
    @Override
    public void extract(ContextCarrier carrier) {
        TraceSegmentRef ref = new TraceSegmentRef(carrier);
        this.segment.ref(ref);
        this.segment.relatedGlobalTrace(new PropagatedTraceId(carrier.getTraceId()));
        AbstractSpan span = this.activeSpan();
        if (span instanceof EntrySpan) {
            // 通过 ref 实现TraceSegment的连接
            span.ref(ref);
        }

        carrier.extractExtensionTo(this);
        carrier.extractCorrelationTo(this);
    }

    /**
     * Capture the snapshot of current context.
     *
     * @return the snapshot of context for cross-thread propagation Ref to {@link AbstractTracerContext#capture()}
     */
    @Override
    public ContextSnapshot capture() {
        ContextSnapshot snapshot = new ContextSnapshot(
                segment.getTraceSegmentId(),
                activeSpan().getSpanId(),
                getPrimaryTraceId(),
                first().getOperationName(),
                this.correlationContext,
                this.extensionContext
        );

        return snapshot;
    }

    /**
     * Continue the context from the given snapshot of parent thread.
     *
     * @param snapshot from {@link #capture()} in the parent thread. Ref to {@link AbstractTracerContext#continued(ContextSnapshot)}
     */
    @Override
    public void continued(ContextSnapshot snapshot) {
        if (snapshot.isValid()) {
            TraceSegmentRef segmentRef = new TraceSegmentRef(snapshot);
            this.segment.ref(segmentRef);
            this.activeSpan().ref(segmentRef);
            this.segment.relatedGlobalTrace(snapshot.getTraceId());
            this.correlationContext.continued(snapshot);
            this.extensionContext.continued(snapshot);
            this.extensionContext.handle(this.activeSpan());
        }
    }

    /**
     * @return the first global trace id.
     */
    @Override
    public String getReadablePrimaryTraceId() {
        return getPrimaryTraceId().getId();
    }

    private DistributedTraceId getPrimaryTraceId() {
        return segment.getRelatedGlobalTrace();
    }

    @Override
    public String getSegmentId() {
        return segment.getTraceSegmentId();
    }

    @Override
    public int getSpanId() {
        return activeSpan().getSpanId();
    }

    /**
     * Create an entry span
     *
     * @param operationName most likely a service name
     * @return span instance. Ref to {@link EntrySpan}
     */
    @Override
    public AbstractSpan createEntrySpan(final String operationName) {
        // 判断当前Segment中是否超过300个Span
        if (isLimitMechanismWorking()) {
            NoopSpan span = new NoopSpan();
            return push(span);
        }
        AbstractSpan entrySpan;
        TracingContext owner = this;
        // 创建Span前 弹出栈顶的Span 弹出的Span作为当前创建的Span的Parent
        final AbstractSpan parentSpan = peek();
        // 获取弹出的SpanID，如果parent不存在，则 设置当前Span的ParentSpan = -1
        final int parentSpanId = parentSpan == null ? -1 : parentSpan.getSpanId();
        // EntrySpan 的复用逻辑 -->
        if (parentSpan != null && parentSpan.isEntry()) {
            /*
             * Only add the profiling recheck on creating entry span,
             * as the operation name could be overrided.
             *
             * 仅在创建条目范围时添加分析重新检查，因为操作名称可能会被覆盖。
             */
            profilingRecheck(parentSpan, operationName);
            // 设置操作名称
            parentSpan.setOperationName(operationName);
            entrySpan = parentSpan;
            return entrySpan.start();
        } else {
            // 创建第一个EntrySpan
            entrySpan = new EntrySpan(
                    spanIdGenerator++, parentSpanId,
                    operationName, owner
            );
            entrySpan.start();
            return push(entrySpan);
        }
    }

    /**
     * Create a local span
     * LocalSpan不需要复用 直接创建
     *
     * @param operationName most likely a local method signature, or business name.
     * @return the span represents a local logic block. Ref to {@link LocalSpan}
     */
    @Override
    public AbstractSpan createLocalSpan(final String operationName) {
        if (isLimitMechanismWorking()) {
            NoopSpan span = new NoopSpan();
            return push(span);
        }
        AbstractSpan parentSpan = peek();
        final int parentSpanId = parentSpan == null ? -1 : parentSpan.getSpanId();
        AbstractTracingSpan span = new LocalSpan(spanIdGenerator++, parentSpanId, operationName, this);
        span.start();
        return push(span);
    }

    /**
     * Create an exit span
     * 复用ExitSpan
     *
     * @param operationName most likely a service name of remote
     * @param remotePeer    the network id(ip:port, hostname:port or ip1:port1,ip2,port, etc.). Remote peer could be set
     *                      later, but must be before injecting.
     * @return the span represent an exit point of this segment.
     * @see ExitSpan
     */
    @Override
    public AbstractSpan createExitSpan(final String operationName, final String remotePeer) {
        if (isLimitMechanismWorking()) {
            NoopExitSpan span = new NoopExitSpan(remotePeer);
            return push(span);
        }

        AbstractSpan exitSpan;
        // 从SpanStack 中去除Span信息，不会删除stack中的这个Span
        AbstractSpan parentSpan = peek();
        TracingContext owner = this;
        if (parentSpan != null && parentSpan.isExit()) {
            // 复用
            exitSpan = parentSpan;
        } else {
            // 创建
            final int parentSpanId = parentSpan == null ? -1 : parentSpan.getSpanId();
            exitSpan = new ExitSpan(spanIdGenerator++, parentSpanId, operationName, remotePeer, owner);
            push(exitSpan);
        }
        exitSpan.start();
        return exitSpan;
    }

    /**
     * @return the active span of current context, the top element of {@link #activeSpanStack}
     */
    @Override
    public AbstractSpan activeSpan() {
        AbstractSpan span = peek();
        if (span == null) {
            throw new IllegalStateException("No active span.");
        }
        return span;
    }

    /**
     * Stop the given span, if and only if this one is the top element of {@link #activeSpanStack}.
     * Because the tracing core must make sure the span must match in a stack module, like any program did.
     * 操作栈顶的Span
     *
     * @param span to finish
     */
    @Override
    public boolean stopSpan(AbstractSpan span) {
        // 从栈顶区取出一个Span
        AbstractSpan lastSpan = peek();
        // 对比两者是否相同
        if (lastSpan == span) {
            if (lastSpan instanceof AbstractTracingSpan) {
                // 将当前的ExitSpan放入到TraceSegment的Spans属性中
                AbstractTracingSpan toFinishSpan = (AbstractTracingSpan) lastSpan;
                if (toFinishSpan.finish(segment)) {
                    // 从栈顶将ExitSpan删除
                    pop();
                }
            } else {
                pop();
            }
        } else {
            throw new IllegalStateException("Stopping the unexpected span = " + span);
        }
        // 数据发送
        finish();

        return activeSpanStack.isEmpty();
    }

    @Override
    public AbstractTracerContext awaitFinishAsync() {
        if (!isRunningInAsyncMode) {
            synchronized (this) {
                if (!isRunningInAsyncMode) {
                    asyncFinishLock = new ReentrantLock();
                    ASYNC_SPAN_COUNTER_UPDATER.set(this, 0);
                    isRunningInAsyncMode = true;
                }
            }
        }
        ASYNC_SPAN_COUNTER_UPDATER.incrementAndGet(this);
        return this;
    }

    @Override
    public void asyncStop(AsyncSpan span) {
        ASYNC_SPAN_COUNTER_UPDATER.decrementAndGet(this);
        // 数据发送
        finish();
    }

    @Override
    public CorrelationContext getCorrelationContext() {
        return this.correlationContext;
    }

    /**
     * Re-check current trace need profiling, encase third part plugin change the operation name.
     *
     * @param span          current modify span
     * @param operationName change to operation name
     */
    public void profilingRecheck(AbstractSpan span, String operationName) {
        // only recheck first span
        if (span.getSpanId() != 0) {
            return;
        }

        PROFILE_TASK_EXECUTION_SERVICE.profilingRecheck(this, segment.getTraceSegmentId(), operationName);
    }

    /**
     * 将链路追踪的数据发送出去
     *
     * Finish this context, and notify all {@link TracingContextListener}s, managed by {@link
     * TracingContext.ListenerManager} and {@link TracingContext.TracingThreadListenerManager}
     */
    private void finish() {
        if (isRunningInAsyncMode) {
            // 异步锁
            asyncFinishLock.lock();
        }
        try {
            boolean isFinishedInMainThread = activeSpanStack.isEmpty() && running;
            if (isFinishedInMainThread) {
                /*
                 * Notify after tracing finished in the main thread.
                 * 在主线程中跟踪完成后通知。
                 */
                TracingThreadListenerManager.notifyFinish(this);
            }
            // 栈为空 且 没有异步操作
            if (isFinishedInMainThread && (!isRunningInAsyncMode || asyncSpanCounter == 0)) {
                // 发送通知
                TraceSegment finishedSegment = segment.finish(isLimitMechanismWorking());
                // 将链路追踪的数据发送出去
                TracingContext.ListenerManager.notifyFinish(finishedSegment);
                running = false;
            }
        } finally {
            if (isRunningInAsyncMode) {
                asyncFinishLock.unlock();
            }
        }
    }

    /**
     * The <code>ListenerManager</code> represents an event notify for every registered listener, which are notified
     * when the <code>TracingContext</code> finished, and {@link #segment} is ready for further process.
     */
    public static class ListenerManager {
        private static List<TracingContextListener> LISTENERS = new LinkedList<>();

        /**
         * Add the given {@link TracingContextListener} to {@link #LISTENERS} list.
         *
         * @param listener the new listener.
         */
        public static synchronized void add(TracingContextListener listener) {
            LISTENERS.add(listener);
        }

        /**
         * Notify the {@link TracingContext.ListenerManager} about the given {@link TraceSegment} have finished. And
         * trigger {@link TracingContext.ListenerManager} to notify all {@link #LISTENERS} 's {@link
         * TracingContextListener#afterFinished(TraceSegment)}
         *
         * @param finishedSegment the segment that has finished
         */
        static void notifyFinish(TraceSegment finishedSegment) {
            for (TracingContextListener listener : LISTENERS) {
                listener.afterFinished(finishedSegment);
            }
        }

        /**
         * Clear the given {@link TracingContextListener}
         */
        public static synchronized void remove(TracingContextListener listener) {
            LISTENERS.remove(listener);
        }

    }

    /**
     * The <code>ListenerManager</code> represents an event notify for every registered listener, which are notified
     * <p>
     * ListenerManager表示每个注册监听器的事件通知，这些监听器会被通知
     */
    public static class TracingThreadListenerManager {
        // TracingThreadListener 用于性能追踪
        private static List<TracingThreadListener> LISTENERS = new LinkedList<>();

        public static synchronized void add(TracingThreadListener listener) {
            LISTENERS.add(listener);
        }

        static void notifyFinish(TracingContext finishedContext) {
            for (TracingThreadListener listener : LISTENERS) {
                listener.afterMainThreadFinish(finishedContext);
            }
        }

        public static synchronized void remove(TracingThreadListener listener) {
            LISTENERS.remove(listener);
        }
    }

    /**
     * @return the top element of 'ActiveSpanStack', and remove it.
     */
    private AbstractSpan pop() {
        return activeSpanStack.removeLast();
    }

    /**
     * Add a new Span at the top of 'ActiveSpanStack'
     *
     * @param span the {@code span} to push
     */
    private AbstractSpan push(AbstractSpan span) {
        if (firstSpan == null) {
            firstSpan = span;
        }
        activeSpanStack.addLast(span);
        this.extensionContext.handle(span);
        return span;
    }

    /**
     * @return the top element of 'ActiveSpanStack' only.
     */
    private AbstractSpan peek() {
        if (activeSpanStack.isEmpty()) {
            return null;
        }
        return activeSpanStack.getLast();
    }

    private AbstractSpan first() {
        return firstSpan;
    }

    /**
     * 判断当前Segment中是否超过300个Span
     *
     * @return 超过300个Span时返回true 表示不允许在创建更多的Span
     */
    private boolean isLimitMechanismWorking() {
        if (spanIdGenerator >= spanLimitWatcher.getSpanLimit()) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - lastWarningTimestamp > 30 * 1000) {
                LOGGER.warn(
                        new RuntimeException("Shadow tracing context. Thread dump"),
                        "More than {} spans required to create", spanLimitWatcher.getSpanLimit()
                );
                lastWarningTimestamp = currentTimeMillis;
            }
            return true;
        } else {
            return false;
        }
    }

    public long createTime() {
        return this.createTime;
    }

    public ProfileStatusReference profileStatus() {
        return this.profileStatus;
    }
}
