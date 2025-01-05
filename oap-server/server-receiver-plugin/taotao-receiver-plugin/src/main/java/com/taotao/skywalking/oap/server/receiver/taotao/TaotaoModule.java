package com.taotao.skywalking.oap.server.receiver.taotao;

import org.apache.skywalking.oap.server.library.module.ModuleDefine;

public class TaotaoModule extends ModuleDefine {
    public TaotaoModule() {
        /**
         * oap-server/server-bootstrap/src/main/resources/application.yml
         */
        super("receiver-taotao");
    }

    /**
     * 该模块堆外提供的服务
     *
     * @return
     */
    @Override
    public Class[] services() {
        return new Class[0];
    }
}
