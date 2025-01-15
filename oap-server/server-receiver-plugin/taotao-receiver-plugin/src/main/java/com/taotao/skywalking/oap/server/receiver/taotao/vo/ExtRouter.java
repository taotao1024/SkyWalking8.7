package com.taotao.skywalking.oap.server.receiver.taotao.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ExtRouter {

    @JsonProperty("NextHop")
    private String nexthop;

    @JsonProperty("SrcMask")
    private String srcmask;

    @JsonProperty("DstMask")
    private String dstmask;

}