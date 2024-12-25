package com.taotao.application.mock.c.server;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

import javax.annotation.PostConstruct;
import java.util.concurrent.ForkJoinPool;

public class NetworkNettyServer {
    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(NetworkNettyServer.class);


    @Value("${svc.network.nettyHost}")
    private String nettyHost;
    @Value("${svc.network.nettyPort}")
    private Integer nettyPort;

    @PostConstruct
    public void init() {
        ForkJoinPool.commonPool().submit(() -> {
            startServer(nettyHost, nettyPort);
        });
    }

    public void startServer(String nettyHost, int nettyPort) {
        LOGGER.info("Init Netty Server...");
        try {
            LOGGER.info("Network RPC Server Start Success");
        } catch (Exception e) {
            LOGGER.error("Network RPC Server start failed", e);
        }
    }
}
