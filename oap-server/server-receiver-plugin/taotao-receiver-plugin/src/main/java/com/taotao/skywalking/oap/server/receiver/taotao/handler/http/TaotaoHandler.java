package com.taotao.skywalking.oap.server.receiver.taotao.handler.http;

import lombok.extern.slf4j.Slf4j;
import org.apache.skywalking.oap.server.library.server.jetty.JettyHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
public class TaotaoHandler extends JettyHandler {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("123123");
    }

    @Override
    public String pathSpec() {
        return "/taotao/test";
    }
}
