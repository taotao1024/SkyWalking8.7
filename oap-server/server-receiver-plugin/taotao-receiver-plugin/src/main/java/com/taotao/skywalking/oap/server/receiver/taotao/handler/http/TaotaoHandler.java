package com.taotao.skywalking.oap.server.receiver.taotao.handler.http;

import org.apache.skywalking.oap.server.library.server.jetty.JettyHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class TaotaoHandler extends JettyHandler {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("123123");
    }

    @Override
    public String pathSpec() {
        return "/taotao/test";
    }
}
