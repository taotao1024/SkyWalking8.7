package com.taotao.skywalking.oap.server.receiver.taotao.vo;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class ExtRouter {

    @SerializedName("NextHop")
    private String nexthop;

    @SerializedName("SrcMask")
    private String srcmask;

    @SerializedName("DstMask")
    private String dstmask;

}