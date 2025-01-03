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

package org.apache.skywalking.apm.toolkit.trace;

import java.util.function.Supplier;

/**
 * 处理线程交叉的埋点
 * <p>
 * SkyWalking 官方文档
 * https://skywalking.apache.org/docs/skywalking-java/v9.0.0/en/setup/service-agent/java-agent/application-toolkit-trace-cross-thread/
 *
 * @param <V>
 */
@TraceCrossThread
public class SupplierWrapper<V> implements Supplier<V> {
    final Supplier<V> supplier;

    public static <V> SupplierWrapper<V> of(Supplier<V> r) {
        return new SupplierWrapper<>(r);
    }

    public SupplierWrapper(Supplier<V> supplier) {
        this.supplier = supplier;
    }

    @Override
    public V get() {
        return supplier.get();
    }
}
