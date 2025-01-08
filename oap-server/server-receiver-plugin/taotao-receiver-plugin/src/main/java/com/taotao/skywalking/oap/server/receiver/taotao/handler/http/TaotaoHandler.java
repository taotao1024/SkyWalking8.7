package com.taotao.skywalking.oap.server.receiver.taotao.handler.http;

import com.taotao.skywalking.oap.server.receiver.taotao.TaotaoConfig;
import com.taotao.skywalking.oap.server.receiver.taotao.TaotaoSflowAnalyzer;
import com.taotao.skywalking.oap.server.receiver.taotao.listener.TaoSflowListenerManager;
import lombok.extern.slf4j.Slf4j;
import org.apache.skywalking.oap.server.library.module.ModuleManager;
import org.apache.skywalking.oap.server.library.server.jetty.JettyHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
public class TaotaoHandler extends JettyHandler {
    private final TaotaoConfig config;

    private final ModuleManager moduleManager;

    private TaoSflowListenerManager listenerManager;

    public TaotaoHandler(ModuleManager moduleManager, TaotaoConfig config, TaoSflowListenerManager listenerManager) {
        this.config = config;
        this.moduleManager = moduleManager;
        this.listenerManager = listenerManager;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("****************************");
        TaotaoSflowAnalyzer analyzer = new TaotaoSflowAnalyzer(moduleManager, listenerManager, config);
        // 解析器
        // analyzer.doAnalysis(req.getRemoteUser());
        log.info("****************************");
    }

    @Override
    public String pathSpec() {
        return "/taotao/test";
    }
}
