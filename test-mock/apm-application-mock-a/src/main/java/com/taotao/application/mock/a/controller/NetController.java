package com.taotao.application.mock.a.controller;

import com.gientech.service.plugin.PluginCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/taotao/plugin")
public class NetController {

    @Autowired
    PluginCheckService pluginCheckService;

    /**
     * 测试-Network组件
     *
     * @throws Exception
     */
    @GetMapping("/net/http")
    public void pluginTestNetHttp() throws Exception {
        pluginCheckService.netHttp();
    }

    /**
     * 测试-Network组件
     *
     * @throws Exception
     */
    @GetMapping("/net/addr")
    public void pluginTestNetAddr() throws Exception {
        pluginCheckService.netAddr();
    }

    /**
     * 测试-Network组件
     *
     * @throws Exception
     */
    @GetMapping("/net/netty")
    public void pluginTestNetNetty() throws Exception {
        pluginCheckService.netNetty();
    }
}
