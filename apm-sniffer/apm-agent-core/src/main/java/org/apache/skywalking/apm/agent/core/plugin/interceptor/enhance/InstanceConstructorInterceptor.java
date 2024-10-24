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

package org.apache.skywalking.apm.agent.core.plugin.interceptor.enhance;

/**
 * The instance constructor's interceptor interface. Any plugin, which wants to intercept constructor, must implement
 * this interface.
 * <p>
 *
 * class Person{
 *     Person(){
 *         // doConstruct()
 *         // 在原生的构造器执行后执行 相当于在原生构造器最后一行添加代码
 *         onConstruct()
 *     }
 * }
 */
public interface InstanceConstructorInterceptor {
    /**
     * Called after the origin constructor invocation.
     */
    void onConstruct(EnhancedInstance objInst, Object[] allArguments) throws Throwable;
}
