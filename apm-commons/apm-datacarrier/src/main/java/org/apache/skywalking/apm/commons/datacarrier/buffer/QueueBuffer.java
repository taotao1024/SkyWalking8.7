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

package org.apache.skywalking.apm.commons.datacarrier.buffer;

import java.util.List;

/**
 * Queue buffer interface.
 */
public interface QueueBuffer<T> {
    /**
     * Save data into the queue;
     * <p>
     * 将数据存入队列；
     *
     * @param data to add.
     * @return true if saved
     */
    boolean save(T data);

    /**
     * Set different strategy when queue is full.
     * <p>
     * 当队列满时设置不同的策略。
     */
    void setStrategy(BufferStrategy strategy);

    /**
     * Obtain the existing data from the queue
     * <p>
     * 从队列中获取现有数据
     */
    void obtain(List<T> consumeList);

    int getBufferSize();
}
