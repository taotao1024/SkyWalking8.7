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
import org.apache.skywalking.apm.commons.datacarrier.common.AtomicRangeInteger;

/**
 * Self implementation ring queue.
 * <p>
 * 环状队列
 */
public class Buffer<T> implements QueueBuffer<T> {
    private final Object[] buffer;
    private BufferStrategy strategy;
    private AtomicRangeInteger index;

    Buffer(int bufferSize, BufferStrategy strategy) {
        // 数组长度
        buffer = new Object[bufferSize];
        this.strategy = strategy;
        index = new AtomicRangeInteger(0, bufferSize);
    }

    @Override
    public void setStrategy(BufferStrategy strategy) {
        this.strategy = strategy;
    }

    @Override
    public boolean save(T data) {
        int i = index.getAndIncrement();
        if (buffer[i] != null) {
            switch (strategy) {
                case IF_POSSIBLE:
                    // 抛弃数据
                    return false;
                default:
            }
        }
        buffer[i] = data;
        return true;
    }

    @Override
    public int getBufferSize() {
        return buffer.length;
    }

    @Override
    public void obtain(List<T> consumeList) {
        this.obtain(consumeList, 0, buffer.length);
    }

    void obtain(List<T> consumeList, int start, int end) {
        for (int i = start; i < end; i++) {
            if (buffer[i] != null) {
                consumeList.add((T) buffer[i]);
                buffer[i] = null;
            }
        }
    }

}
