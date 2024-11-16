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

package org.apache.skywalking.oap.server.core.remote;

import java.util.List;
import org.apache.skywalking.oap.server.core.CoreModule;
import org.apache.skywalking.oap.server.core.remote.client.RemoteClient;
import org.apache.skywalking.oap.server.core.remote.client.RemoteClientManager;
import org.apache.skywalking.oap.server.core.remote.data.StreamData;
import org.apache.skywalking.oap.server.core.remote.selector.ForeverFirstSelector;
import org.apache.skywalking.oap.server.core.remote.selector.HashCodeSelector;
import org.apache.skywalking.oap.server.core.remote.selector.RollingSelector;
import org.apache.skywalking.oap.server.core.remote.selector.Selector;
import org.apache.skywalking.oap.server.library.module.ModuleManager;
import org.apache.skywalking.oap.server.library.module.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * RemoteSenderService represents a gRPC client to send metrics from one OAP node to another through network. It
 * provides several routing mode to select target OAP node.
 * <p>
 * RemoteSenderService 表示一个 gRPC 客户端，用于通过网络将指标从一个 OAP 节点发送到另一个 OAP 节点。它提供了多种路由模式来选择目标 OAP 节点。
 */
public class RemoteSenderService implements Service {
    private static final Logger LOGGER = LoggerFactory.getLogger(RemoteSenderService.class);

    private final ModuleManager moduleManager;
    private final HashCodeSelector hashCodeSelector;
    private final ForeverFirstSelector foreverFirstSelector;
    private final RollingSelector rollingSelector;

    public RemoteSenderService(ModuleManager moduleManager) {
        this.moduleManager = moduleManager;
        this.hashCodeSelector = new HashCodeSelector();
        this.foreverFirstSelector = new ForeverFirstSelector();
        this.rollingSelector = new RollingSelector();
    }

    /**
     * Send data to the target based on the given selector
     * <p>
     * 根据给定的选择器将数据发送到目标
     *
     * @param nextWorkName points to the worker to process the data when {@link RemoteServiceHandler} received.
     * @param streamData   data to be sent
     * @param selector     strategy implementation to choose suitable OAP node.
     */
    public void send(String nextWorkName, StreamData streamData, Selector selector) {
        // 从CoreModuleProvider中获取到初始化好的RemoteClientManager对象
        RemoteClientManager clientManager = moduleManager.find(CoreModule.NAME)
                                                         .provider()
                                                         .getService(RemoteClientManager.class);
        RemoteClient remoteClient = null;
        // 获取到L2级客户端地址、如果本身是Mixed角色 就会获取到 SelfRemoteClient 反之 GRPCRemoteClient
        // 否则获取到集群中的Aggregator身份的L2级oap-server
        // 默认值为 mixed   ${SW_CORE_ROLE:Mixed}
        List<RemoteClient> clientList = clientManager.getRemoteClient();
        if (clientList.size() == 0) {
            LOGGER.warn(
                "There is no available remote server for now, ignore the streaming data until the cluster metadata initialized.");
            return;
        }
        switch (selector) {
            case HashCode:
                //  hash 下一个oap Server
                remoteClient = hashCodeSelector.select(clientList, streamData);
                break;
            case Rolling:
                //  轮询 下一个oap Server
                remoteClient = rollingSelector.select(clientList, streamData);
                break;
            case ForeverFirst:
                // 永远拿第一个 oap Server
                remoteClient = foreverFirstSelector.select(clientList, streamData);
                break;
        }
        // 发送数据
        remoteClient.push(nextWorkName, streamData);
    }
}
