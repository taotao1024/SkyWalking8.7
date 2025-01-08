package com.taotao.skywalking.oap.server.receiver.taotao.listener;

import com.taotao.skywalking.oap.server.receiver.taotao.vo.SflowRootBean;

public interface TaoSflowAnalysisListener {

    void build();

    void parse(SflowRootBean sflowRootBean);
}
