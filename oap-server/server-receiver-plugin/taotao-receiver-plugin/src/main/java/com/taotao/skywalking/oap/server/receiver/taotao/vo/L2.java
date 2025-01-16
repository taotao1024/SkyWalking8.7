package com.taotao.skywalking.oap.server.receiver.taotao.vo;

import com.google.gson.annotations.SerializedName;
import lombok.Data;


@Data
public class L2 {

    @SerializedName("SrcMAC")
    private String srcmac;

    @SerializedName("DstMAC")
    private String dstmac;

    @SerializedName("Vlan")
    private String vlan;

    @SerializedName("EtherType")
    private String ethertype;
}