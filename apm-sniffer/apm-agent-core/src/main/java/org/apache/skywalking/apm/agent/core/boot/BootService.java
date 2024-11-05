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
 * SamplingService  SamplingService是来控制是否要采样该链路。每条链路都是被追踪到的，但是考虑到序列化/反序列化
 * 的CPU消耗以及网络带宽，如果开启采样，SkyWalking Agent并不会把所有的链路都发送给OAP。默认
 * 采样是开启的，可以通过修改agent.config中的agent.sample_n_per_3_secs配置项控制每3秒最多采样
 * 多少条链路
 * GRPCLogReportServiceClient   日志发送
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
