package com.taotao.application.mock.c.server;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

import javax.annotation.PostConstruct;
import java.util.concurrent.ForkJoinPool;

public class NetworkVertxServer {
    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(NetworkVertxServer.class);

    @Value("${svc.network.vertxHost}")
    private String vertxHost;
    @Value("${svc.network.vertxPort}")
    private Integer vertxPort;

    @PostConstruct
    public void init() {
        ForkJoinPool.commonPool().submit(() -> {
            startServer(vertxHost, vertxPort);
        });
    }

    public void startServer(String vertxHost, int vertxPort) {
        LOGGER.info("Init Vert.X Server...");
        try {
            LOGGER.info("Vert.X Server Start Success");
        } catch (Exception e) {
            LOGGER.error("Network Vert.X Server start failed", e);
        }
    }
}
