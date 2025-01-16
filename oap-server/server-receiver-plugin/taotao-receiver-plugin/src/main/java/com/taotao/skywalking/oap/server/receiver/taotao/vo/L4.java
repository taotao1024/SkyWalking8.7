package com.taotao.skywalking.oap.server.receiver.taotao.vo;

import com.google.gson.annotations.SerializedName;
import lombok.Data;


@Data
public class L4 {

    @SerializedName("SrcPort")
    private String srcport;

    @SerializedName("DstPort")
    private String dstport;

    @SerializedName("DataOffset")
    private String dataoffset;

    @SerializedName("Reserved")
    private String reserved;

    @SerializedName("Flags")
    private String flags;

}