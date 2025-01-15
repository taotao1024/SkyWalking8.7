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

package org.apache.skywalking.oap.server.receiver.trace.provider;

import org.apache.skywalking.oap.server.analyzer.module.AnalyzerModule;
import org.apache.skywalking.oap.server.configuration.api.ConfigurationModule;
import org.apache.skywalking.oap.server.core.CoreModule;
import org.apache.skywalking.oap.server.core.server.GRPCHandlerRegister;
import org.apache.skywalking.oap.server.core.server.JettyHandlerRegister;
import org.apache.skywalking.oap.server.library.module.ModuleConfig;
import org.apache.skywalking.oap.server.library.module.ModuleDefine;
import org.apache.skywalking.oap.server.library.module.ModuleProvider;
import org.apache.skywalking.oap.server.library.module.ServiceNotProvidedException;
import org.apache.skywalking.oap.server.receiver.sharing.server.SharingServerModule;
import org.apache.skywalking.oap.server.receiver.trace.module.TraceModule;
import org.apache.skywalking.oap.server.receiver.trace.provider.handler.v8.grpc.TraceSegmentReportServiceHandler;
import org.apache.skywalking.oap.server.receiver.trace.provider.handler.v8.grpc.TraceSegmentReportServiceHandlerCompat;
import org.apache.skywalking.oap.server.receiver.trace.provider.handler.v8.rest.TraceSegmentReportListServletHandler;
import org.apache.skywalking.oap.server.receiver.trace.provider.handler.v8.rest.TraceSegmentReportSingleServletHandler;
import org.apache.skywalking.oap.server.telemetry.TelemetryModule;

/**
 * TODO OAP 链路数据入口
 * 跟踪模块提供程序
 * OAP 接受 Agent服务前 启动GRpc服务和Http服务
 */
public class TraceModuleProvider extends ModuleProvider {

    @Override
    public String name() {
        return "default";
    }

    @Override
    public Class<? extends ModuleDefine> module() {
        return TraceModule.class;
    }

    @Override
    public ModuleConfig createConfigBeanIfAbsent() {
        return null;
    }

    @Override
    public void prepare() throws ServiceNotProvidedException {

    }

    @Override
    public void start() {
        /**
         * {@link org.apache.skywalking.oap.server.receiver.sharing.server.SharingServerModuleProvider}
         */
        // 从 GRPC获取积压的消息
        GRPCHandlerRegister grpcHandlerRegister = getManager().find(SharingServerModule.NAME)
                .provider()
                .getService(GRPCHandlerRegister.class);
        // 从 HTTP获取积压消息
        JettyHandlerRegister jettyHandlerRegister = getManager().find(SharingServerModule.NAME)
                .provider()
                .getService(JettyHandlerRegister.class);
        // TraceSegmentReportServiceHandler.collect() OAP接收Agent链路跟踪的数据入口
        TraceSegmentReportServiceHandler traceSegmentReportServiceHandler = new TraceSegmentReportServiceHandler(getManager());
        // 处理消息
        grpcHandlerRegister.addHandler(traceSegmentReportServiceHandler);
        grpcHandlerRegister.addHandler(new TraceSegmentReportServiceHandlerCompat(traceSegmentReportServiceHandler));

        jettyHandlerRegister.addHandler(new TraceSegmentReportListServletHandler(getManager()));
        jettyHandlerRegister.addHandler(new TraceSegmentReportSingleServletHandler(getManager()));
    }

    @Override
    public void notifyAfterCompleted() {

    }

    @Override
    public String[] requiredModules() {
        return new String[]{
                TelemetryModule.NAME,
                CoreModule.NAME,
                AnalyzerModule.NAME,
                SharingServerModule.NAME,
                ConfigurationModule.NAME
        };
    }

}
