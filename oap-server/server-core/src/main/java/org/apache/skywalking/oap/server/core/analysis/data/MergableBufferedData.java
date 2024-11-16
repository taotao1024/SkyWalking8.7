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

package org.apache.skywalking.oap.server.core.analysis.data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.skywalking.oap.server.core.analysis.metrics.Metrics;

/**
 * MergableBufferedData is a thread no safe implementation of {@link BufferedData}. {@link Metrics} in this cache would
 * be {@link Metrics#combine(Metrics)} if their {@link Metrics#id()}s are same.
 * <p>
 * Concurrency {@link #accept(Metrics)}s and {@link #read()} while {@link #accept(Metrics)} are both not recommended.
 */
public class MergableBufferedData<METRICS extends Metrics> implements BufferedData<METRICS> {
    private Map<String, METRICS> buffer;

    public MergableBufferedData() {
        buffer = new HashMap<>();
    }

    /**
     * Accept the data into the cache and merge with the existing value.
     * <p>
     * This method is not thread safe, should avoid concurrency calling.
     *
     * @param data to be added potentially.
     */
    @Override
    public void accept(final METRICS data) {
        // 调用metrics的id方法 每个Metrics的Id()的值都是唯一的
        final String id = data.id();
        // 从缓存中读取
        final METRICS existed = buffer.get(id);
        if (existed == null) {
            buffer.put(id, data);
        } else {
            // 进行计算 每个实现的机制都不同
            // L1级聚合 实现内存中的数据计算 将计算结果也存储在内存中
            final boolean isAbandoned = !existed.combine(data);
            if (isAbandoned) {
                buffer.remove(id);
            }
        }
    }

    @Override
    public List<METRICS> read() {
        try {
            return buffer.values().stream().collect(Collectors.toList());
        } finally {
            buffer.clear();
        }
    }
}
