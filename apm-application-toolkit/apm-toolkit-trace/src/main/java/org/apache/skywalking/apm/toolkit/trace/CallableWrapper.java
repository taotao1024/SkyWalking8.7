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

import java.util.concurrent.Callable;

/**
 * 处理线程交叉的埋点
 * <p>
 * SkyWalking 官方文档
 * https://skywalking.apache.org/docs/skywalking-java/v9.0.0/en/setup/service-agent/java-agent/application-toolkit-trace-cross-thread/
 *
 * @param <V>
 */
@TraceCrossThread
public class CallableWrapper<V> implements Callable<V> {
    final Callable<V> callable;

    public static <V> CallableWrapper<V> of(Callable<V> r) {
        return new CallableWrapper<>(r);
    }

    public CallableWrapper(Callable<V> callable) {
        this.callable = callable;
    }

    @Override
    public V call() throws Exception {
        return callable.call();
    }
}
