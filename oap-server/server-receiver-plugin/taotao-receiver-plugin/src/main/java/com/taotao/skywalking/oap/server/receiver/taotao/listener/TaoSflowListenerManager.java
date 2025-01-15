package com.taotao.skywalking.oap.server.receiver.taotao.listener;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class TaoSflowListenerManager {

    //注意这儿的list中放的都是XxxListenerFactory的实现类！
    @Getter
    private final List<TaoSflowListenerFactory> perfDataListenerFactories = new ArrayList<>();

    public void add(final TaoSflowListenerFactory factory) {
        perfDataListenerFactories.add(factory);
    }
}
