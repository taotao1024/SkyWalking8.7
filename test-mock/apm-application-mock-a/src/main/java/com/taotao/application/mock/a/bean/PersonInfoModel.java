package com.taotao.application.mock.a.bean;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Setter
@Getter
@ToString
public class PersonInfoModel {
    @ApiModelProperty(value = "id", required = true, example = "1")
    int id;
    @ApiModelProperty(value = "学校", example = "一中")
    String school;
    @ApiModelProperty(value = "是否是男生", example = "false")
    boolean isBoy;
    @ApiModelProperty(value = "身份信息")
    List<IdentityModel> personalInfos;
}