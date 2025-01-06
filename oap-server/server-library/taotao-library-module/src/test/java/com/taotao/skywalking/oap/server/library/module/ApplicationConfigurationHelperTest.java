package com.taotao.skywalking.oap.server.library.module;

import com.taotao.skywalking.oap.server.receiver.taotao.TaotaoModule;
import com.taotao.skywalking.oap.server.receiver.taotao.service.ILogService;
import org.apache.skywalking.oap.server.library.module.ApplicationConfiguration;
import org.apache.skywalking.oap.server.library.module.ModuleManager;
import org.junit.Test;

public class ApplicationConfigurationHelperTest {

    @Test
    public void getApplicationConfiguration() throws Exception {
        ModuleManager moduleManager = new ModuleManager();
        ApplicationConfiguration appConfig = new ApplicationConfigurationHelper().getApplicationConfiguration();
        moduleManager.init(appConfig);

        moduleManager.find(TaotaoModule.NAME)
                .provider()
                .getService(ILogService.class)
                .deleteStr();

        moduleManager.find(TaotaoModule.NAME)
                .provider()
                .getService(ILogService.class)
                .queryStr();

        moduleManager.find(TaotaoModule.NAME)
                .provider()
                .getService(ILogService.class)
                .inertStr();
    }
}