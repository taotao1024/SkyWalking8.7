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

import java.util.Map;

import org.apache.skywalking.apm.agent.core.context.AsyncSpan;
import org.apache.skywalking.apm.agent.core.context.tag.AbstractTag;
import org.apache.skywalking.apm.agent.core.context.tag.Tags;
import org.apache.skywalking.apm.network.trace.component.Component;
import org.apache.skywalking.apm.network.trace.component.ComponentsDefine;

/**
 * The <code>AbstractSpan</code> represents the span's skeleton, which contains all open methods.
 * <p>
 * {@link AbstractSpan} 表示 span 的框架，其中包含所有开放的方法。
 */
public interface AbstractSpan extends AsyncSpan {
    /**
     * Set the component id, which defines in {@link ComponentsDefine}
     * <p>
     * 设置组件 ID 由ComponentsDefine 决定
     * 指定当前操作发生在某个插件中
     *
     * @param component 由ComponentsDefine决定 其中OfficialComponent表示官方插件 自定义插件是需要在ComponentsDefine中新增
     * @return the span for chaining.
     */
    AbstractSpan setComponent(Component component);

    /**
     * 指定当前Span 表示的操作所在的插件属于哪一种类型 由SkyWalking决定
     *
     * @param layer Span 类型
     * @return
     */
    AbstractSpan setLayer(SpanLayer layer);

    /**
     * Set a key:value tag on the Span.
     * 在 Span 上设置 key：value 标签 已禁用 建议使用 tag(AbstractTag<?> tag, String value)
     *
     * @return this Span instance, for chaining
     * @deprecated use {@link #tag(AbstractTag, String)} in companion with {@link Tags#ofKey(String)} instead
     */
    @Deprecated
    AbstractSpan tag(String key, String value);

    /**
     * 在 Span 上设置 key：value 标签
     * <p>
     * 可以通过AbstractTag的泛型指定
     */
    AbstractSpan tag(AbstractTag<?> tag, String value);

    /**
     * Record an exception event of the current wallTime timestamp.
     * <p>
     * wallTime 挂钟时间、本地时间
     * serverTime 服务器时间
     * <p>
     * 记录异常发生的时间
     *
     * @param t any subclass of {@link Throwable}, which occurs in this span.
     * @return the Span, for chaining
     */
    AbstractSpan log(Throwable t);

    /**
     * 错误发生时 需要做的事情
     *
     * @return
     */
    AbstractSpan errorOccurred();

    /**
     * 进入Span
     *
     * @return true if the actual span is an entry span.
     */
    boolean isEntry();

    /**
     * 推出Span
     *
     * @return true if the actual span is an exit span.
     */
    boolean isExit();

    /**
     * Record an event at a specific timestamp.
     * <p>
     * 记录指定异常时间  和 事件
     *
     * @param timestamp The explicit timestamp for the log record.
     * @param event     the events
     * @return the Span, for chaining
     */
    AbstractSpan log(long timestamp, Map<String, ?> event);

    /**
     * Sets the string name for the logical operation this span represents.
     * <p>
     * 设置当前Span的操作:
     * 如果是HTTP请求，则 operationName 就是 请求的URL
     * 如果是SQL语句，则 operationName 就是 SQL 的类型
     * 如果是Redis操作，则 operationName 就是 Redis 命令
     *
     * @return this Span instance, for chaining
     */
    AbstractSpan setOperationName(String operationName);

    /**
     * Start a span.
     * 记录动作开始时 执行span的方法
     *
     * @return this Span instance, for chaining
     */
    AbstractSpan start();

    /**
     * Get the id of span
     *
     * @return id value.
     */
    int getSpanId();

    String getOperationName();

    /**
     * Reference other trace segment.
     * <p>
     * 跨segment场景时，关联下一个segment。
     *
     * @param ref segment ref
     */
    void ref(TraceSegmentRef ref);

    AbstractSpan start(long startTime);

    /**
     * Peer -> 对端地址
     * 因为一个请求可能会跨越多个进程，操作多种中间件。那么：
     * 每一次rpc，对面的服务地址就是 remotePeer。
     * 每一次中间件操作，中间件的地址就是remotePeer。
     *
     * @param remotePeer
     * @return
     */
    AbstractSpan setPeer(String remotePeer);

    /**
     * 和诊断、链路跟踪相关
     *
     * @return true if the span's owner(tracing context main thread) is been profiled.
     */
    boolean isProfiling();

    /**
     * 分析标致
     * Should skip analysis in the backend.
     */
    void skipAnalysis();
}
