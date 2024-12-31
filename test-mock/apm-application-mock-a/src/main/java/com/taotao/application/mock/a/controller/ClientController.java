package com.taotao.application.mock.a.controller;


import com.alibaba.fastjson2.JSONObject;
import com.taotao.application.mock.a.service.impl.ClientConsumer;
import com.taotao.application.mock.a.bean.PersonInfoModel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/loginAction")
@Api(tags = "接口列表")
public class ClientController {

    @Autowired
    ClientConsumer clientConsumer;

    @PostMapping(value = "/v1/queryInfo", consumes = "application/json", produces = "application/json")
    @ApiOperation(notes = "queryInfo", value = "查询人员信息(简单grpc) ")
    public JSONObject queryInfo(@ApiParam(name = "人员信息") @RequestBody PersonInfoModel customerListModel) {
        return clientConsumer.queryInfo(customerListModel);
    }

    @PostMapping(value = "/v1/querySomeData", produces = "application/json")
    @ApiOperation(notes = "querySomeData", value = "查询数据(服务端流式grpc) ")
    public JSONObject querySomeData(@ApiParam(value = "id", required = true) @RequestParam int id) {
        return clientConsumer.querySomeData(id);
    }

    @PostMapping(value = "/v1/sendBooksInfo", produces = "application/json")
    @ApiOperation(notes = "sendBooksInfo", value = "发送书籍信息(客户端流式grpc) ")
    public JSONObject sendBooksInfo(@ApiParam(value = "id", required = true) @RequestParam int id) {
        return clientConsumer.sendBooksInfo(id);
    }

    @PostMapping(value = "/v1/calculateSum", produces = "application/json")
    @ApiOperation(notes = "calculateSum", value = "计算一到一万的和(双向流grpc) ")
    public JSONObject calculateSum(@ApiParam(value = "id", required = true) @RequestParam int id) {
        return clientConsumer.calculateSum(id);
    }

    @PostMapping(value = "/v1/sayHello", produces = "application/json")
    @ApiOperation(notes = "sayHello", value = "测试SayHello ")
    public JSONObject sayHello() {
        return clientConsumer.sayHello();
    }
}
