package com.taotao.skywalking.oap.server.receiver.taotao;

import com.taotao.skywalking.oap.server.receiver.taotao.handler.http.TaotaoHandler;
import com.taotao.skywalking.oap.server.receiver.taotao.service.ILogService;
import com.taotao.skywalking.oap.server.receiver.taotao.service.ITaoService;
import com.taotao.skywalking.oap.server.receiver.taotao.service.impl.ILogServiceImpl;
import com.taotao.skywalking.oap.server.receiver.taotao.service.impl.ITaoServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.apache.skywalking.oap.server.configuration.api.ConfigurationModule;
import org.apache.skywalking.oap.server.core.CoreModule;
import org.apache.skywalking.oap.server.core.server.JettyHandlerRegister;
import org.apache.skywalking.oap.server.library.module.*;
import org.apache.skywalking.oap.server.receiver.sharing.server.SharingServerModule;

@Slf4j
public class TaotaoProvider extends ModuleProvider {

    private TaotaoConfig taotaoConfig;

    public TaotaoProvider() {
        this.taotaoConfig = new TaotaoConfig();
    }

    /**
     * 与 ${SW_RECEIVER_TAOTAO:default} 关联
     *
     * @return
     */
    @Override
    public String name() {
        return "default";
    }

    @Override
    public Class<? extends ModuleDefine> module() {
        return TaotaoModule.class;
    }

    @Override
    public ModuleConfig createConfigBeanIfAbsent() {
        return taotaoConfig;
    }

    @Override
    public void prepare() throws ServiceNotProvidedException, ModuleStartException {
        log.info("------------ 正在准备{} ------------", this.getClass().getName());
        this.registerServiceImplementation(ILogService.class, new ILogServiceImpl());
        this.registerServiceImplementation(ITaoService.class, new ITaoServiceImpl());
        log.info("------------ 正在准备{} ------------", this.getClass().getName());
    }

    @Override
    public void start() throws ServiceNotProvidedException, ModuleStartException {
        log.info("------------ 正在启动{} ------------", this.getClass().getName());

        JettyHandlerRegister httpService = getManager().find(SharingServerModule.NAME)
                .provider()
                .getService(JettyHandlerRegister.class);
        httpService.addHandler(new TaotaoHandler());

        log.info("------------ 正在启动{} ------------", this.getClass().getName());
    }

    @Override
    public void notifyAfterCompleted() throws ServiceNotProvidedException, ModuleStartException {

    }

    @Override
    public String[] requiredModules() {
        return new String[]{
                CoreModule.NAME,
                SharingServerModule.NAME,
                ConfigurationModule.NAME
        };
    }
}
