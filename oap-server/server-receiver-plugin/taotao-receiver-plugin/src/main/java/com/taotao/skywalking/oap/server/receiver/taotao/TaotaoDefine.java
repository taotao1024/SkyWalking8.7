package com.taotao.skywalking.oap.server.receiver.taotao;

import org.apache.skywalking.oap.server.core.oal.rt.OALDefine;

public class TaotaoDefine extends OALDefine {

    public static final TaotaoDefine INSTANCE = new TaotaoDefine();
    public static final String SOURCE_PACKAGE = "org.apache.skywalking.oap.server.core.source";

    /**
     * "org.apache.skywalking.oap.server.core.source"
     * "com.taotao.skywalking.oap.server.receiver.taotao.source"
     */
    private TaotaoDefine() {
        super("oal/taotao.oal", SOURCE_PACKAGE);
    }
}
