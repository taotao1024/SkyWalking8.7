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

package org.apache.skywalking.apm.commons.datacarrier.consumer;

import java.util.List;

public interface IConsumer<T> {
    /**
     * 初始化
     */
    void init();

    /**
     * 消费
     *
     * @param data
     */
    void consume(List<T> data);

    /**
     * 异常
     *
     * @param data
     * @param t
     */
    void onError(List<T> data, Throwable t);

    /**
     * 退出
     */
    void onExit();

    /**
     * Notify the implementation, if there is nothing fetched from the queue. This could be used as a timer to trigger
     * reaction if the queue has no element.
     * <p>
     * 如果没有从队列中获取任何内容，则通知实现。如果队列没有元素，这可以用作计时器来触发反应。
     */
    default void nothingToConsume() {
        return;
    }
}
