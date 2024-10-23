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

package org.apache.skywalking.apm.commons.datacarrier.common;

import java.io.Serializable;
import java.util.concurrent.atomic.AtomicIntegerArray;

public class AtomicRangeInteger extends Number implements Serializable {
    private static final long serialVersionUID = -4099792402691141643L;
    /**
     * 可以原子化操作数组的一个数组封装 基于CAS
     */
    private AtomicIntegerArray values;

    private static final int VALUE_OFFSET = 15;
    /**
     * 默认值为 0
     */
    private int startValue;
    private int endValue;

    public AtomicRangeInteger(int startValue, int maxValue) {
        // 创建了一个长度为31的数组
        this.values = new AtomicIntegerArray(31);
        // 将 values 这个数组的下标为15的值(即 第16个元素)，设置成固定值(默认为0)
        this.values.set(VALUE_OFFSET, startValue);
        this.startValue = startValue;
        this.endValue = maxValue - 1;
    }

    public final int getAndIncrement() {
        // 默认下标为15
        int next;
        do {
            next = this.values.incrementAndGet(VALUE_OFFSET);
            // 如果 next > endValue 表示数据越界 需要将values 中下表为15的元素重置为 startValue(即为0)
            // 通过这里实现了 环操作
            // 当下标越界后刷新成初始值
            if (next > endValue && this.values.compareAndSet(VALUE_OFFSET, next, startValue)) {
                return endValue;
            }
        }
        while (next > endValue);

        return next - 1;
    }

    public final int get() {
        return this.values.get(VALUE_OFFSET);
    }

    @Override
    public int intValue() {
        return this.values.get(VALUE_OFFSET);
    }

    @Override
    public long longValue() {
        return this.values.get(VALUE_OFFSET);
    }

    @Override
    public float floatValue() {
        return this.values.get(VALUE_OFFSET);
    }

    @Override
    public double doubleValue() {
        return this.values.get(VALUE_OFFSET);
    }
}
