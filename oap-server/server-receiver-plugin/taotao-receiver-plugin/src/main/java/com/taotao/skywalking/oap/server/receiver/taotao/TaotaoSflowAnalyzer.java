package com.taotao.skywalking.oap.server.receiver.taotao;

import com.taotao.skywalking.oap.server.receiver.taotao.listener.TaoSflowAnalysisListener;
import com.taotao.skywalking.oap.server.receiver.taotao.listener.TaoSflowListenerManager;
import com.taotao.skywalking.oap.server.receiver.taotao.vo.SflowRootBean;
import lombok.RequiredArgsConstructor;
import org.apache.skywalking.oap.server.library.module.ModuleManager;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public class TaotaoSflowAnalyzer {
    private final ModuleManager moduleManager;
    private final TaoSflowListenerManager listenerManager;
    private final TaotaoConfig config;
    private List<TaoSflowAnalysisListener> analysisListeners = new ArrayList<>();

    public void doAnalysis(SflowRootBean sflowRootBean) {
        //拿到真正的listeners
        createListeners();
        //把数据解析到source
        notifyListener(sflowRootBean);
        //数据入库
        notifyListenerToBuild();
    }

    private void notifyListenerToBuild() {
        analysisListeners.forEach(TaoSflowAnalysisListener::build);
    }

    private void notifyListener(SflowRootBean sflowRootBean) {
        analysisListeners.forEach(listener -> {
            listener.parse(sflowRootBean);
        });
    }

    private void createListeners() {
        listenerManager.getPerfDataListenerFactories()
                .forEach(
                        factory -> analysisListeners.add(
                                factory.create(moduleManager, config)));
    }
}
