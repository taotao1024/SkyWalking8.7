package com.taotao.skywalking.oap.server.receiver.taotao.vo;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class RawHeader {

    @SerializedName("L2")
    private L2 l2;

    @SerializedName("L3")
    private L3 l3;

    @SerializedName("L4")
    private L4 l4;

}