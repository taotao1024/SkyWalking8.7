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

import org.apache.skywalking.apm.agent.core.context.trace.AbstractSpan;

/**
 * The <code>AbstractTracerContext</code> represents the tracer context manager.
 * Tracer 跟踪器上下文管理器
 */
public interface AbstractTracerContext {
    /**
     * Prepare for the cross-process propagation. How to initialize the carrier, depends on the implementation.
     * <p>
     * 跨进程传输数据
     * 注入 将某些数据放到 ContextCarrier 中
     *
     * @param carrier to carry the context for crossing process.
     *                传递数据的载体
     */
    void inject(ContextCarrier carrier);

    /**
     * Build the reference between this segment and a cross-process segment. How to build, depends on the
     * implementation.
     * 跨进程传输数据
     * 构建一个引用，当前Segment 与 跨进程Segment
     *
     * @param carrier carried the context from a cross-process segment.
     *                传递数据的载体
     */
    void extract(ContextCarrier carrier);

    /**
     * Capture a snapshot for cross-thread propagation. It's a similar concept with ActiveSpan.Continuation in
     * OpenTracing-java How to build, depends on the implementation.
     * 跨线程传播数据
     * <p>
     * 跨线程不需要数据载体 会自己生成一个
     *
     * @return the {@link ContextSnapshot} , which includes the reference context.
     */
    ContextSnapshot capture();

    /**
     * Build the reference between this segment and a cross-thread segment. How to build, depends on the
     * implementation.
     * 跨线程传播数据
     *
     * @param snapshot from {@link #capture()} in the parent thread.
     *                 传递数据的载体
     */
    void continued(ContextSnapshot snapshot);

    /**
     * Get the global trace id, if needEnhance. How to build, depends on the implementation.
     * <p>
     * 获取 全局跟踪ID {@link org.apache.skywalking.apm.agent.core.context.ids.GlobalIdGenerator}
     *
     * @return the string represents the id.
     */
    String getReadablePrimaryTraceId();

    /**
     * Get the current segment id, if needEnhance. How to build, depends on the implementation.
     * <p>
     * 获取 当前的SegmentID
     *
     * @return the string represents the id.
     */
    String getSegmentId();

    /**
     * Get the active span id, if needEnhance. How to build, depends on the implementation.
     * <p>
     * 获取 活跃的SpanID
     *
     * @return the string represents the id.
     */
    int getSpanId();

    /**
     * Create an entry span
     *
     * @param operationName most likely a service name
     * @return the span represents an entry point of this segment.
     */
    AbstractSpan createEntrySpan(String operationName);

    /**
     * Create a local span
     *
     * @param operationName most likely a local method signature, or business name.
     * @return the span represents a local logic block.
     */
    AbstractSpan createLocalSpan(String operationName);

    /**
     * Create an exit span
     *
     * @param operationName most likely a service name of remote
     * @param remotePeer    the network id(ip:port, hostname:port or ip1:port1,ip2,port, etc.). Remote peer could be set
     *                      later, but must be before injecting.
     * @return the span represent an exit point of this segment.
     */
    AbstractSpan createExitSpan(String operationName, String remotePeer);

    /**
     * @return the active span of current tracing context(stack)
     */
    AbstractSpan activeSpan();

    /**
     * Finish the given span, and the given span should be the active span of current tracing context(stack)
     * <p>
     * 活跃的Span
     * <p>
     * 调用 finish(TraceSegment owner)
     *
     * @param span to finish
     * @return true when context should be clear.
     */
    boolean stopSpan(AbstractSpan span);

    /**
     * Notify this context, current span is going to be finished async in another thread.
     * <p>
     * 等待异步Span结束
     *
     * @return The current context
     */
    AbstractTracerContext awaitFinishAsync();

    /**
     * The given span could be stopped officially.
     * <p>
     * 异步Span关闭
     *
     * @param span to be stopped.
     */
    void asyncStop(AsyncSpan span);

    /**
     * Get current correlation context
     * 性能追踪
     */
    CorrelationContext getCorrelationContext();
}
