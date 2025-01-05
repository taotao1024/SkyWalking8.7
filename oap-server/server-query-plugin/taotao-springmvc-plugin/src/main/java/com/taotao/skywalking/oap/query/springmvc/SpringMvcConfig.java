package com.taotao.skywalking.oap.query.springmvc;

import lombok.Getter;
import lombok.Setter;
import org.apache.skywalking.oap.server.library.module.ModuleConfig;

@Setter
@Getter
public class SpringMvcConfig extends ModuleConfig {

    private Integer port;
}
