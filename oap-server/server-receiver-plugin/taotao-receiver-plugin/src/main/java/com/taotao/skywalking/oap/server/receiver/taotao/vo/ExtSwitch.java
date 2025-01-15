package com.taotao.skywalking.oap.server.receiver.taotao.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;


@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ExtSwitch {

    @JsonProperty("SrcVlan")
    private String srcvlan;

    @JsonProperty("SrcPriority")
    private String srcpriority;

    @JsonProperty("DstVlan")
    private String dstvlan;

    @JsonProperty("DstPriority")
    private String dstpriority;


}