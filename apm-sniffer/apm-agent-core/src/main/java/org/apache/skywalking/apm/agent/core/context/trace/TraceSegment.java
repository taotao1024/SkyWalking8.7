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

package org.apache.skywalking.apm.agent.core.context.trace;

import java.util.LinkedList;
import java.util.List;

import org.apache.skywalking.apm.agent.core.conf.Config;
import org.apache.skywalking.apm.agent.core.context.ids.DistributedTraceId;
import org.apache.skywalking.apm.agent.core.context.ids.GlobalIdGenerator;
import org.apache.skywalking.apm.agent.core.context.ids.NewDistributedTraceId;
import org.apache.skywalking.apm.network.language.agent.v3.SegmentObject;

/**
 * {@link TraceSegment} is a segment or fragment of the distributed trace.
 * See https://github.com/opentracing/specification/blob/master/specification.md#the-opentracing-data-model
 * A {@link TraceSegment} means the segment, which exists in current {@link Thread}. And the distributed trace is formed
 * by multi {@link TraceSegment}s, because the distributed trace crosses multi-processes, multi-threads. <p>
 * <p>
 * Trace绑定线程
 * 而分布式跟踪是由多个 {@link TraceSegment} 形成的，因为分布式跟踪跨越多进程、多线程。
 * <p>
 * Trace 不是一个具体的数据模型、而是多Segment串起来表示的逻辑对象
 */
public class TraceSegment {
    /**
     * The id of this trace segment. Every segment has its unique-global-id.
     */
    private String traceSegmentId;

    /**
     * TraceSegment 引用
     * <p>
     * The refs of parent trace segments, except the primary one. For most RPC call, {@link #ref} contains only one
     * element, but if this segment is a start span of batch process, the segment faces multi parents, at this moment,
     * we only cache the first parent segment reference.
     * <p>
     * 指向当前 Segment 的 Parent Segment 指针，针对大多数的RPC调用，这个引用只会包含一个元素。
     * 但是如果这个segment 是一个批处理或消息队列， 那么会有多个parent, 这里只会保存第一个 parent。
     *
     * <p>
     * This field will not be serialized. Keeping this field is only for quick accessing.
     * 为了快速访问整条链路 该变量不会被序列化
     */
    private TraceSegmentRef ref;

    /**
     * The spans belong to this trace segment. They all have finished. All active spans are hold and controlled by
     * "skywalking-api" module.
     */
    private List<AbstractTracingSpan> spans;

    /**
     * The <code>relatedGlobalTraceId</code> represent the related trace. Most time it related only one
     * element, because only one parent {@link TraceSegment} exists, but, in batch scenario, the num becomes greater
     * than 1, also meaning multi-parents {@link TraceSegment}. But we only related the first parent TraceSegment.
     * <p>
     * 当前 Segment 所在 Trace 的 ID
     */
    private DistributedTraceId relatedGlobalTraceId;

    private boolean ignore = false;

    private boolean isSizeLimited = false;

    private final long createTime;

    /**
     * Create a default/empty trace segment, with current time as start time, and generate a new segment id.
     */
    public TraceSegment() {
        this.traceSegmentId = GlobalIdGenerator.generate();
        this.spans = new LinkedList<>();
        this.relatedGlobalTraceId = new NewDistributedTraceId();
        this.createTime = System.currentTimeMillis();
    }

    /**
     * Establish the link between this segment and its parents.
     *
     * @param refSegment {@link TraceSegmentRef}
     */
    public void ref(TraceSegmentRef refSegment) {
        if (null == ref) {
            this.ref = refSegment;
        }
    }

    /**
     * Establish the line between this segment and the relative global trace id.
     * <p>
     * 在此分段和相对全局跟踪 ID 之间建立线。
     */
    public void relatedGlobalTrace(DistributedTraceId distributedTraceId) {
        if (relatedGlobalTraceId instanceof NewDistributedTraceId) {
            this.relatedGlobalTraceId = distributedTraceId;
        }
    }

    /**
     * After {@link AbstractSpan} is finished, as be controller by "skywalking-api" module, notify the {@link
     * TraceSegment} to archive it.
     */
    public void archive(AbstractTracingSpan finishedSpan) {
        spans.add(finishedSpan);
    }

    /**
     * Finish this {@link TraceSegment}. <p> return this, for chaining
     * 关闭 Segment 时 需要传入标识符 表示当前是否超过300个操作
     */
    public TraceSegment finish(boolean isSizeLimited) {
        this.isSizeLimited = isSizeLimited;
        return this;
    }

    public String getTraceSegmentId() {
        return traceSegmentId;
    }

    /**
     * Get the first parent segment reference.
     */
    public TraceSegmentRef getRef() {
        return ref;
    }

    public DistributedTraceId getRelatedGlobalTrace() {
        return relatedGlobalTraceId;
    }

    public boolean isSingleSpanSegment() {
        return this.spans != null && this.spans.size() == 1;
    }

    public boolean isIgnore() {
        return ignore;
    }

    public void setIgnore(boolean ignore) {
        this.ignore = ignore;
    }

    /**
     * This is a high CPU cost method, only called when sending to collector or test cases.
     * 序列化
     *
     * @return the segment as GRPC service parameter
     */
    public SegmentObject transform() {
        SegmentObject.Builder traceSegmentBuilder = SegmentObject.newBuilder();
        traceSegmentBuilder.setTraceId(getRelatedGlobalTrace().getId());
        /*
         * Trace Segment
         */
        traceSegmentBuilder.setTraceSegmentId(this.traceSegmentId);
        // Don't serialize TraceSegmentReference

        // SpanObject
        for (AbstractTracingSpan span : this.spans) {
            traceSegmentBuilder.addSpans(span.transform());
        }
        traceSegmentBuilder.setService(Config.Agent.SERVICE_NAME);
        traceSegmentBuilder.setServiceInstance(Config.Agent.INSTANCE_NAME);
        traceSegmentBuilder.setIsSizeLimited(this.isSizeLimited);

        return traceSegmentBuilder.build();
    }

    @Override
    public String toString() {
        return "TraceSegment{" + "traceSegmentId='" + traceSegmentId + '\'' + ", ref=" + ref + ", spans=" + spans + "}";
    }

    public long createTime() {
        return this.createTime;
    }
}
