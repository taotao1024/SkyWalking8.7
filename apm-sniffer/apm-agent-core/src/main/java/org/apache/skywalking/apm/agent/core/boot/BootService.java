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

package org.apache.skywalking.apm.agent.core.boot;

/**
 * The <code>BootService</code> is an interface to all remote, which need to boot when plugin mechanism begins to work.
 * {@link #boot()} will be called when <code>BootService</code> start up.
 * <p>
 * 是所有远程的接口，当插件机制开始工作时，它们需要启动。
 * <p>
 * GRPCChannelManager Agent 到 OAP的核心模块，用于gRPC网络通讯
 * ServiceManagementClient 和 OAP保持心跳(KeepAlive)、汇报当前客户端的状态
 * ServiceInstanceGenerator 生成默认的实例标识符
 * CommandService Command Scheduler 命令处理调度器
 * CommandExecutorService
 */
public interface BootService {
    /**
     * 准备时
     *
     * @throws Throwable
     */
    void prepare() throws Throwable;

    /**
     * 启动时
     *
     * @throws Throwable
     */
    void boot() throws Throwable;

    /**
     * 完成时
     *
     * @throws Throwable
     */
    void onComplete() throws Throwable;

    /**
     * 关闭
     *
     * @throws Throwable
     */
    void shutdown() throws Throwable;

    /**
     * {@code BootService}s with higher priorities will be started earlier, and shut down later than those {@code BootService}s with lower priorities.
     * 设置启动优先级 值越大越优先启动
     *
     * @return the priority of this {@code BootService}.
     */
    default int priority() {
        return 0;
    }
}
