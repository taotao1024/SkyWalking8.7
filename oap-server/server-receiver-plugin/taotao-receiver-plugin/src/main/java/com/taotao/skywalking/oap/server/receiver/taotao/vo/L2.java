package com.taotao.skywalking.oap.server.receiver.taotao.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;


@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class L2 {

    @JsonProperty("SrcMAC")
    private String srcmac;

    @JsonProperty("DstMAC")
    private String dstmac;

    @JsonProperty("Vlan")
    private String vlan;

    @JsonProperty("EtherType")
    private String ethertype;
}