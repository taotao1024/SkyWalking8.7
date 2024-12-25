package com.taotao.application.mock.a.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class SendMsgUtils {
    private static final Logger LOGGER = LoggerFactory.getLogger(SendMsgUtils.class);

    @Value("${svc.network.httpHost}")
    private String httpHost;
    @Value("${svc.network.httpPort}")
    private Integer httpPort;

    public void sendOKHttpFroOkHttp(String uriResource) throws IOException {
    }
}
