package com.taotao.skywalking.oap.server.receiver.taotao.listener;

import com.taotao.skywalking.oap.server.receiver.taotao.TaotaoConfig;
import org.apache.skywalking.oap.server.library.module.ModuleManager;

public interface TaoSflowListenerFactory {

    TaoSflowAnalysisListener create(ModuleManager moduleManager, TaotaoConfig moduleConfig);

}
