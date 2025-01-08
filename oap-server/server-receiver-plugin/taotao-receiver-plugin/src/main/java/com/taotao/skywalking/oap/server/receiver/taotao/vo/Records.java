package com.taotao.skywalking.oap.server.receiver.taotao.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Records {

    @JsonProperty("ExtRouter")
    private ExtRouter extrouter;

    @JsonProperty("ExtSwitch")
    private ExtSwitch extswitch;

    @JsonProperty("RawHeader")
    private RawHeader rawheader;
}