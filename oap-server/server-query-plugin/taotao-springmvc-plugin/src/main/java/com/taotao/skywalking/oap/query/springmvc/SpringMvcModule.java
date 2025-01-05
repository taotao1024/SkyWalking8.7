package com.taotao.skywalking.oap.query.springmvc;

import org.apache.skywalking.oap.server.library.module.ModuleDefine;

public class SpringMvcModule extends ModuleDefine {
    public static final String NAME = "taotao-springmvc";

    public SpringMvcModule() {
        super(NAME);
    }

    /**
     * 该模块堆外提供的服务
     *
     * @return
     */
    @Override
    public Class[] services() {
        return new Class[]{};
    }
}
