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

package org.apache.skywalking.oap.server.receiver.sharing.server;

import java.util.Objects;
import org.apache.logging.log4j.util.Strings;
import org.apache.skywalking.apm.util.StringUtil;
import org.apache.skywalking.oap.server.core.CoreModule;
import org.apache.skywalking.oap.server.core.remote.health.HealthCheckServiceHandler;
import org.apache.skywalking.oap.server.core.server.GRPCHandlerRegister;
import org.apache.skywalking.oap.server.core.server.GRPCHandlerRegisterImpl;
import org.apache.skywalking.oap.server.core.server.JettyHandlerRegister;
import org.apache.skywalking.oap.server.core.server.JettyHandlerRegisterImpl;
import org.apache.skywalking.oap.server.core.server.auth.AuthenticationInterceptor;
import org.apache.skywalking.oap.server.library.module.ModuleConfig;
import org.apache.skywalking.oap.server.library.module.ModuleDefine;
import org.apache.skywalking.oap.server.library.module.ModuleProvider;
import org.apache.skywalking.oap.server.library.module.ModuleStartException;
import org.apache.skywalking.oap.server.library.server.ServerException;
import org.apache.skywalking.oap.server.library.server.grpc.GRPCServer;
import org.apache.skywalking.oap.server.library.server.jetty.JettyServer;
import org.apache.skywalking.oap.server.library.server.jetty.JettyServerConfig;

/**
 * 共享服务器模块提供程序
 */
public class SharingServerModuleProvider extends ModuleProvider {

    private final SharingServerConfig config;
    private GRPCServer grpcServer;
    private JettyServer jettyServer;
    private ReceiverGRPCHandlerRegister receiverGRPCHandlerRegister;
    private ReceiverJettyHandlerRegister receiverJettyHandlerRegister;
    private AuthenticationInterceptor authenticationInterceptor;

    public SharingServerModuleProvider() {
        super();
        this.config = new SharingServerConfig();
    }

    @Override
    public String name() {
        return "default";
    }

    @Override
    public Class<? extends ModuleDefine> module() {
        return SharingServerModule.class;
    }

    @Override
    public ModuleConfig createConfigBeanIfAbsent() {
        return config;
    }

    @Override
    public void prepare() {
        if (config.getRestPort() > 0) {
            JettyServerConfig jettyServerConfig =
                JettyServerConfig.builder()
                                 .host(config.getRestHost()).port(config.getRestPort())
                                 .contextPath(config.getRestContextPath())
                                 .jettyMinThreads(config.getRestMinThreads())
                                 .jettyMaxThreads(config.getRestMaxThreads())
                                 .jettyAcceptQueueSize(config.getRestAcceptQueueSize())
                                 .jettyAcceptorPriorityDelta(
                                     config.getRestAcceptorPriorityDelta())
                                 .jettyIdleTimeOut(config.getRestIdleTimeOut())
                                 .jettyHttpMaxRequestHeaderSize(config.getHttpMaxRequestHeaderSize()).build();
            jettyServerConfig.setHost(Strings.isBlank(config.getRestHost()) ? "0.0.0.0" : config.getRestHost());
            jettyServerConfig.setPort(config.getRestPort());
            jettyServerConfig.setContextPath(config.getRestContextPath());

            jettyServer = new JettyServer(jettyServerConfig);
            jettyServer.initialize();

            this.registerServiceImplementation(JettyHandlerRegister.class, new JettyHandlerRegisterImpl(jettyServer));
        } else {
            // 默认 restPort == 0
            this.receiverJettyHandlerRegister = new ReceiverJettyHandlerRegister();
            this.registerServiceImplementation(JettyHandlerRegister.class, receiverJettyHandlerRegister);
        }

        if (StringUtil.isNotEmpty(config.getAuthentication())) {
            authenticationInterceptor = new AuthenticationInterceptor(config.getAuthentication());
        }

        if (config.getGRPCPort() != 0) {
            // 初始化 GRPCServer
            if (config.isGRPCSslEnabled()) {
                grpcServer = new GRPCServer(
                    Strings.isBlank(config.getGRPCHost()) ? "0.0.0.0" : config.getGRPCHost(),
                    config.getGRPCPort(),
                    config.getGRPCSslCertChainPath(),
                    config.getGRPCSslKeyPath()
                );
            } else {
                grpcServer = new GRPCServer(
                    Strings.isBlank(config.getGRPCHost()) ? "0.0.0.0" : config.getGRPCHost(),
                    config.getGRPCPort()
                );
            }
            // 最大消息长度
            if (config.getMaxMessageSize() > 0) {
                grpcServer.setMaxMessageSize(config.getMaxMessageSize());
            }
            // 最大连接数
            if (config.getMaxConcurrentCallsPerConnection() > 0) {
                grpcServer.setMaxConcurrentCallsPerConnection(config.getMaxConcurrentCallsPerConnection());
            }
            // 线程池
            if (config.getGRPCThreadPoolQueueSize() > 0) {
                grpcServer.setThreadPoolQueueSize(config.getGRPCThreadPoolQueueSize());
            }
            // 线程池
            if (config.getGRPCThreadPoolSize() > 0) {
                grpcServer.setThreadPoolSize(config.getGRPCThreadPoolSize());
            }
            // 初始化
            grpcServer.initialize();
            // 放入service 属性中
            GRPCHandlerRegisterImpl grpcHandlerRegister = new GRPCHandlerRegisterImpl(grpcServer);
            if (Objects.nonNull(authenticationInterceptor)) {
                grpcHandlerRegister.addFilter(authenticationInterceptor);
            }
            this.registerServiceImplementation(GRPCHandlerRegister.class, grpcHandlerRegister);
        } else {
            // 初始化 内部属性暂时没有赋值
            this.receiverGRPCHandlerRegister = new ReceiverGRPCHandlerRegister();
            if (Objects.nonNull(authenticationInterceptor)) {
                receiverGRPCHandlerRegister.addFilter(authenticationInterceptor);
            }
            // 默认走这里 因为 GRPCPort == 0
            this.registerServiceImplementation(GRPCHandlerRegister.class, receiverGRPCHandlerRegister);
        }
    }

    @Override
    public void start() {
        if (Objects.nonNull(grpcServer)) {
            grpcServer.addHandler(new HealthCheckServiceHandler());
        }
        // GRPC 于Agent通讯
        if (Objects.nonNull(receiverGRPCHandlerRegister)) {
            receiverGRPCHandlerRegister.setGrpcHandlerRegister(getManager().find(CoreModule.NAME)
                                                                           .provider()
                                                                           .getService(GRPCHandlerRegister.class));
        }
        // Jetty 与UI通讯
        if (Objects.nonNull(receiverJettyHandlerRegister)) {
            receiverJettyHandlerRegister.setJettyHandlerRegister(getManager().find(CoreModule.NAME)
                                                                             .provider()
                                                                             .getService(JettyHandlerRegister.class));
        }
    }

    @Override
    public void notifyAfterCompleted() throws ModuleStartException {
        try {
            if (Objects.nonNull(grpcServer)) {
                grpcServer.start();
            }
            if (Objects.nonNull(jettyServer)) {
                jettyServer.start();
            }
        } catch (ServerException e) {
            throw new ModuleStartException(e.getMessage(), e);
        }
    }

    @Override
    public String[] requiredModules() {
        return new String[] {CoreModule.NAME};
    }
}
