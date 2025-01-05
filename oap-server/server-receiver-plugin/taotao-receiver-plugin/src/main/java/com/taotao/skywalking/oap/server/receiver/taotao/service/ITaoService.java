package com.taotao.skywalking.oap.server.receiver.taotao.service;

import org.apache.skywalking.oap.server.library.module.Service;

public interface ITaoService extends Service {
    void queryStr();

    void inertStr();

    void deleteStr();
}
