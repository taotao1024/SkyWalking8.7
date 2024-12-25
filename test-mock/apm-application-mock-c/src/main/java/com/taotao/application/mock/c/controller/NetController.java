package com.taotao.application.mock.c.controller;

import com.taotao.application.mock.c.service.INetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/taotao/plugin")
public class NetController {

    @Autowired
    INetService iNetService;

    /**
     * 测试-SpringMVC组件
     *
     * @throws Exception
     */
    @GetMapping("/net/http")
    public void pluginTestNetHttp() throws Exception {
        iNetService.test();
    }
}
