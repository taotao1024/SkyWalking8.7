package com.taotao.skywalking.oap.server.receiver.taotao.service.impl;

import com.taotao.skywalking.oap.server.receiver.taotao.service.ITaoService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ITaoServiceImpl implements ITaoService {
    @Override
    public void queryStr() {
        log.info("{} success for {}", this.getClass().getName(), "queryStr");
    }

    @Override
    public void inertStr() {
        log.info("{} success for {}", this.getClass().getName(), "inertStr");
    }

    @Override
    public void deleteStr() {
        log.info("{} success for {}", this.getClass().getName(), "deleteStr");
    }
}
