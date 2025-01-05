package com.taotao.skywalking.oap.server.receiver.taotao;

import com.taotao.skywalking.oap.server.receiver.taotao.service.ILogService;
import com.taotao.skywalking.oap.server.receiver.taotao.service.ITaoService;
import org.apache.skywalking.oap.server.library.module.ModuleDefine;

public class TaotaoModule extends ModuleDefine {
    /**
     * oap-server/server-bootstrap/src/main/resources/application.yml
     */
    public static final String NAME = "taotao-receiver";

    public TaotaoModule() {
        super(NAME);
    }

    /**
     * 该模块堆外提供的服务
     *
     * @return
     */
    @Override
    public Class[] services() {
        return new Class[]{
                ILogService.class,
                ITaoService.class,
        };
    }
}
