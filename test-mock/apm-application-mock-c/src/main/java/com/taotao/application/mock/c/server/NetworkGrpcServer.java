package com.taotao.application.mock.c.server;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

import javax.annotation.PostConstruct;
import java.util.concurrent.ForkJoinPool;

public class NetworkGrpcServer {
    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(NetworkGrpcServer.class);

    @Value("${svc.network.grpcHost}")
    private String grpcHost;
    @Value("${svc.network.grpcPort}")
    private Integer grpcPort;

    @PostConstruct
    public void init() {
        ForkJoinPool.commonPool().submit(() -> {
            startServer(grpcHost, grpcPort);
        });
    }

    public void startServer(String grpcHost, int grpcPort) {
        LOGGER.info("Init Grpc Server...");
        try {
            System.out.println("Grpc Server Start Success");
            LOGGER.info("Grpc Server Start Success");
        } catch (Exception e) {
            LOGGER.error("Network Grpc Server start failed", e);
        }
    }
}
