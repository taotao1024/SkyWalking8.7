package com.taotao.skywalking.oap.server.receiver.taotao.service.impl;

import com.taotao.skywalking.oap.server.receiver.taotao.service.ILogService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ILogServiceImpl implements ILogService {
    @Override
    public void queryStr() {
        log.info("success for {}", "queryStr");
    }

    @Override
    public void inertStr() {
        log.info("success for {}", "inertStr");
    }

    @Override
    public void deleteStr() {
        log.info("success for {}", "deleteStr");
    }
}
