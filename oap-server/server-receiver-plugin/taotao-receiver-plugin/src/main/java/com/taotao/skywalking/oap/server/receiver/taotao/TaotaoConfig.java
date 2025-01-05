package com.taotao.skywalking.oap.server.receiver.taotao;

import lombok.Getter;
import lombok.Setter;
import org.apache.skywalking.oap.server.library.module.ModuleConfig;

@Setter
@Getter
public class TaotaoConfig extends ModuleConfig {

    private Integer item;
}
