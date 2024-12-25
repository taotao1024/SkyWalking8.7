package com.taotao.application.mock.a.service.impl;

import com.taotao.application.mock.a.service.INetService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Component
public class FinanceDevAddressServiceFactory implements INetService {
    private static final Logger LOGGER = LoggerFactory.getLogger(FinanceDevAddressServiceFactory.class);

    @Value("${mock.call.nettyPort}")
    private Integer nettyPort;
    @Value("${mock.call.nettyHost}")
    private String nettyHost;
    @Value("${mock.call.vertxHost}")
    private String vertxHost;
    @Value("${mock.call.vertxPort}")
    private Integer vertxPort;
    @Value("${mock.call.grpcHost}")
    private String grpcHost;
    @Value("${mock.call.grpcPort}")
    private Integer grpcPort;

    @Override
    public void test() {
        System.out.println("我被调用了");
    }
}
