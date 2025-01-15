package com.taotao.skywalking.oap.server.receiver.taotao.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class RawHeader {

    @JsonProperty("L2")
    private L2 l2;

    @JsonProperty("L3")
    private L3 l3;

    @JsonProperty("L4")
    private L4 l4;

}