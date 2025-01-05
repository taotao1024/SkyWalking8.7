package com.taotao.skywalking.oap.query.springmvc;

import com.taotao.skywalking.oap.server.receiver.taotao.TaotaoModule;
import com.taotao.skywalking.oap.server.receiver.taotao.service.ILogService;
import com.taotao.skywalking.oap.server.receiver.taotao.service.ITaoService;
import lombok.extern.slf4j.Slf4j;
import org.apache.skywalking.oap.server.library.module.ModuleConfig;
import org.apache.skywalking.oap.server.library.module.ModuleDefine;
import org.apache.skywalking.oap.server.library.module.ModuleProvider;
import org.apache.skywalking.oap.server.library.module.ModuleStartException;
import org.apache.skywalking.oap.server.library.module.ServiceNotProvidedException;

@Slf4j
public class SpringMvcProvider extends ModuleProvider {

    private SpringMvcConfig springMvcConfig;

    public SpringMvcProvider() {
        this.springMvcConfig = new SpringMvcConfig();
    }

    /**
     * 与 ${SW_SPRINGMVC:default} 关联
     *
     * @return
     */
    @Override
    public String name() {
        return "default";
    }

    @Override
    public Class<? extends ModuleDefine> module() {
        return SpringMvcModule.class;
    }

    @Override
    public ModuleConfig createConfigBeanIfAbsent() {
        return springMvcConfig;
    }

    @Override
    public void prepare() throws ServiceNotProvidedException, ModuleStartException {
        log.info("------------ 正在准备{} ------------", this.getClass().getName());
        log.info("------------ 正在准备{} ------------", this.getClass().getName());
    }

    @Override
    public void start() throws ServiceNotProvidedException, ModuleStartException {
        log.info("------------ 正在启动{} ------------", this.getClass().getName());
        ILogService logService = getManager().find(TaotaoModule.NAME)
                .provider()
                .getService(ILogService.class);
        ITaoService taoService = getManager().find(TaotaoModule.NAME)
                .provider()
                .getService(ITaoService.class);
        log.info("------------ 正在启动{} ------------", this.getClass().getName());
    }

    @Override
    public void notifyAfterCompleted() throws ServiceNotProvidedException, ModuleStartException {

    }

    @Override
    public String[] requiredModules() {
        return new String[]{
                TaotaoModule.NAME,
        };
    }
}
