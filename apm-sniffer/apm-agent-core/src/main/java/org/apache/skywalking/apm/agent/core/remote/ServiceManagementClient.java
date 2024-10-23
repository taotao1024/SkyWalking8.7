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

package org.apache.skywalking.apm.agent.core.remote;

import io.grpc.Channel;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import org.apache.skywalking.apm.agent.core.boot.BootService;
import org.apache.skywalking.apm.agent.core.boot.DefaultImplementor;
import org.apache.skywalking.apm.agent.core.boot.DefaultNamedThreadFactory;
import org.apache.skywalking.apm.agent.core.boot.ServiceManager;
import org.apache.skywalking.apm.agent.core.commands.CommandService;
import org.apache.skywalking.apm.agent.core.conf.Config;
import org.apache.skywalking.apm.agent.core.jvm.LoadedLibraryCollector;
import org.apache.skywalking.apm.agent.core.logging.api.ILog;
import org.apache.skywalking.apm.agent.core.logging.api.LogManager;
import org.apache.skywalking.apm.agent.core.os.OSUtil;
import org.apache.skywalking.apm.network.common.v3.Commands;
import org.apache.skywalking.apm.network.common.v3.KeyStringValuePair;
import org.apache.skywalking.apm.network.management.v3.InstancePingPkg;
import org.apache.skywalking.apm.network.management.v3.InstanceProperties;
import org.apache.skywalking.apm.network.management.v3.ManagementServiceGrpc;
import org.apache.skywalking.apm.util.RunnableWithExceptionProtection;

import static org.apache.skywalking.apm.agent.core.conf.Config.Collector.GRPC_UPSTREAM_TIMEOUT;

/**
 * 1、OAP保持心跳(KeepAlive)
 * 2、汇报当前客户端的状态
 */
@DefaultImplementor
public class ServiceManagementClient implements BootService, Runnable, GRPCChannelListener {
    private static final ILog LOGGER = LogManager.getLogger(ServiceManagementClient.class);
    private static List<KeyStringValuePair> SERVICE_INSTANCE_PROPERTIES;
    /**
     * 当前网络连接状态
     */
    private volatile GRPCChannelStatus status = GRPCChannelStatus.DISCONNECT;
    /**
     * 网络服务
     */
    private volatile ManagementServiceGrpc.ManagementServiceBlockingStub managementServiceBlockingStub;
    /**
     * 心跳定时任务
     */
    private volatile ScheduledFuture<?> heartbeatFuture;
    /**
     * 信息发送计数器
     */
    private volatile AtomicInteger sendPropertiesCounter = new AtomicInteger(0);

    /**
     * 找到 GRPCChannelManager 服务 并 获取网络连接
     * grpc 的stub 可以理解为 protobuf 中定义的 XxxService
     * @param status
     */
    @Override
    public void statusChanged(GRPCChannelStatus status) {
        if (GRPCChannelStatus.CONNECTED.equals(status)) {
            // 找到 GRPCChannelManager 服务 并 获取网络连接
            Channel channel = ServiceManager.INSTANCE.findService(GRPCChannelManager.class).getChannel();
            // grpc 的stub 可以理解为 protobuf 中定义的 XxxService
            // 例如 Management.proto
            managementServiceBlockingStub = ManagementServiceGrpc.newBlockingStub(channel);
        } else {
            managementServiceBlockingStub = null;
        }
        this.status = status;
    }

    @Override
    public void prepare() {
        // 将自己注册成监听器
        ServiceManager.INSTANCE.findService(GRPCChannelManager.class).addChannelListener(this);

        SERVICE_INSTANCE_PROPERTIES = new ArrayList<>();
        // 将配置文件中的Agent Client 信息放入集合、等待发送
        for (String key : Config.Agent.INSTANCE_PROPERTIES.keySet()) {
            SERVICE_INSTANCE_PROPERTIES.add(KeyStringValuePair.newBuilder()
                    .setKey(key)
                    .setValue(Config.Agent.INSTANCE_PROPERTIES.get(key))
                    .build()
            );
        }
    }

    @Override
    public void boot() {
        // KeepAlive 每间隔30秒执行一次
        heartbeatFuture = Executors.newSingleThreadScheduledExecutor(
                new DefaultNamedThreadFactory("ServiceManagementClient")
        ).scheduleAtFixedRate(
                new RunnableWithExceptionProtection(
                        this,
                        t -> LOGGER.error("unexpected exception.", t)
                ), 0, Config.Collector.HEARTBEAT_PERIOD,
                TimeUnit.SECONDS
        );
    }

    @Override
    public void onComplete() {
    }

    @Override
    public void shutdown() {
        heartbeatFuture.cancel(true);
    }

    @Override
    public void run() {
        LOGGER.debug("ServiceManagementClient running, status:{}.", status);
        // 创建网络连接状态
        if (GRPCChannelStatus.CONNECTED.equals(status)) {
            try {
                if (managementServiceBlockingStub != null) {
                    // 使用绝对值为了避免超过int的最大值
                    // 心跳周期 = 30s 信息汇报频率因子 = 10 ==> 默认配置 每5分钟 向 OAP 汇报一次
                    if (Math.abs(sendPropertiesCounter.getAndAdd(1)) % Config.Collector.PROPERTIES_REPORT_PERIOD_FACTOR == 0) {

                        managementServiceBlockingStub
                                .withDeadlineAfter(GRPC_UPSTREAM_TIMEOUT, TimeUnit.SECONDS)
                                .reportInstanceProperties(InstanceProperties.newBuilder()
                                        .setService(Config.Agent.SERVICE_NAME)
                                        .setServiceInstance(Config.Agent.INSTANCE_NAME)// 如果为空，则由ServiceInstanceGenerator 服务生成。
                                        .addAllProperties(OSUtil.buildOSInfo(Config.OsInfo.IPV4_LIST_SIZE))
                                        .addAllProperties(SERVICE_INSTANCE_PROPERTIES)
                                        .addAllProperties(LoadedLibraryCollector.buildJVMInfo())
                                        .build());
                    } else {
                        // 向服务端发送数据
                        final Commands commands = managementServiceBlockingStub.withDeadlineAfter(
                                GRPC_UPSTREAM_TIMEOUT, TimeUnit.SECONDS
                        ).keepAlive(InstancePingPkg.newBuilder()
                                .setService(Config.Agent.SERVICE_NAME)
                                .setServiceInstance(Config.Agent.INSTANCE_NAME)
                                .build());
                        // CommandService 处理服务端相应
                        ServiceManager.INSTANCE.findService(CommandService.class).receiveCommand(commands);
                    }
                }
            } catch (Throwable t) {
                LOGGER.error(t, "ServiceManagementClient execute fail.");
                ServiceManager.INSTANCE.findService(GRPCChannelManager.class).reportError(t);
            }
        }
    }
}
