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

package org.apache.skywalking.oap.server.analyzer.provider.trace.parser.listener;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.skywalking.apm.network.language.agent.v3.RefType;
import org.apache.skywalking.apm.network.language.agent.v3.SegmentObject;
import org.apache.skywalking.apm.network.language.agent.v3.SpanLayer;
import org.apache.skywalking.apm.network.language.agent.v3.SpanObject;
import org.apache.skywalking.oap.server.core.CoreModule;
import org.apache.skywalking.oap.server.core.analysis.NodeType;
import org.apache.skywalking.oap.server.core.analysis.TimeBucket;
import org.apache.skywalking.oap.server.core.config.NamingControl;
import org.apache.skywalking.oap.server.core.source.NetworkAddressAliasSetup;
import org.apache.skywalking.oap.server.core.source.SourceReceiver;
import org.apache.skywalking.oap.server.library.module.ModuleManager;
import org.apache.skywalking.oap.server.analyzer.provider.AnalyzerModuleConfig;

/**
 * NetworkAddressAliasMappingListener use the propagated data in the segment reference, set up the alias relationship
 * between network address and current service and instance. The alias relationship will be used in the {@link
 * MultiScopesAnalysisListener#parseExit(SpanObject, SegmentObject)} to setup the accurate target destination service
 * and instance.
 * <p>
 * This is a key point of SkyWalking header propagation protocol.
 * <p>
 * NetworkAddressAliasMappingListener的作用:
 * 在一个分布式系统中，服务A可能通过某个IP地址访问服务B，然而这个IP地址并不直接对应服务B的逻辑名称。
 * NetworkAddressAliasMappingListener的工作就是识别并记录这种地址与服务之间的关系。例如:
 * 服务A调用192.168.1.2:8080这个地址，SkyWalking会通过NetworkAddressAliasMappingListener知道这个地址实际上对应服务B的实例
 * 当服务A调用这个地址时，SkyWalking可以正确地将调用链条展示为"服务A调用了服务B"，而不是"服务A调用了192.168.1.2:8080"
 * <p>
 * 最终NetworkAddressAliasMappingListener是通过维护所络地址和服务实例之间的映射关系，确保分布式调用链的完整性和准确性
 */
@Slf4j
@RequiredArgsConstructor
public class NetworkAddressAliasMappingListener implements EntryAnalysisListener {
    private final SourceReceiver sourceReceiver;
    private final AnalyzerModuleConfig config;
    private final NamingControl namingControl;

    @Override
    public void parseEntry(SpanObject span, SegmentObject segmentObject) {
        if (span.getSkipAnalysis()) {
            return;
        }
        if (log.isDebugEnabled()) {
            log.debug("service instance mapping listener parse reference");
        }
        // 判断spanspanLayer属性
        if (!span.getSpanLayer().equals(SpanLayer.MQ)) {
            // 只有在EntrySpan中 refs属性才不会为空 所以refs中记录的是当前segment关联的上级segment
            span.getRefsList().forEach(segmentReference -> {
                // 仅处理 跨进程调用
                if (RefType.CrossProcess.equals(segmentReference.getRefType())) {
                    final String networkAddressUsedAtPeer = namingControl.formatServiceName(
                            segmentReference.getNetworkAddressUsedAtPeer());
                    if (config.getUninstrumentedGatewaysConfig().isAddressConfiguredAsGateway(
                            networkAddressUsedAtPeer)) {
                        /*
                         * If this network address has been set as an uninstrumented gateway, no alias should be set.
                         */
                        return;
                    }
                    // 格式化 serviceName
                    final String serviceName = namingControl.formatServiceName(segmentObject.getService());
                    // 格式化 instanceName
                    final String instanceName = namingControl.formatInstanceName(
                            segmentObject.getServiceInstance());
                    // NetworkAddressAliasSetup 是一个 source
                    final NetworkAddressAliasSetup networkAddressAliasSetup = new NetworkAddressAliasSetup();
                    networkAddressAliasSetup.setAddress(networkAddressUsedAtPeer);
                    networkAddressAliasSetup.setRepresentService(serviceName);
                    networkAddressAliasSetup.setRepresentServiceNodeType(NodeType.Normal);
                    networkAddressAliasSetup.setRepresentServiceInstance(instanceName);
                    networkAddressAliasSetup.setTimeBucket(TimeBucket.getMinuteTimeBucket(span.getStartTime()));
                    /**
                     * sourceReceiver 是从 CoreModuleProvider中获取的 SourceReceiverImpl实例化对象
                     * {@link org.apache.skywalking.oap.server.core.source.SourceReceiverImpl}
                     */
                    sourceReceiver.receive(networkAddressAliasSetup);
                }

            });
        }
    }

    @Override
    public void build() {
    }

    @Override
    public boolean containsPoint(Point point) {
        return Point.Entry.equals(point);
    }

    public static class Factory implements AnalysisListenerFactory {
        private final SourceReceiver sourceReceiver;
        private final NamingControl namingControl;

        public Factory(ModuleManager moduleManager) {
            this.sourceReceiver = moduleManager.find(CoreModule.NAME).provider().getService(SourceReceiver.class);
            this.namingControl = moduleManager.find(CoreModule.NAME)
                    .provider()
                    .getService(NamingControl.class);
        }

        @Override
        public AnalysisListener create(ModuleManager moduleManager, AnalyzerModuleConfig config) {
            return new NetworkAddressAliasMappingListener(sourceReceiver, config, namingControl);
        }
    }
}
