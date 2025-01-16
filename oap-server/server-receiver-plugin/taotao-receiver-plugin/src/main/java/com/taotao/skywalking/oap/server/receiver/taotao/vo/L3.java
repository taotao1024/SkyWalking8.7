package com.taotao.skywalking.oap.server.receiver.taotao.vo;

import com.google.gson.annotations.SerializedName;
import lombok.Data;


@Data
public class L3 {

    @SerializedName("Version")
    private String version;

    @SerializedName("TOS")
    private String tos;

    @SerializedName("TotalLen")
    private String totallen;

    @SerializedName("ID")
    private String id;

    @SerializedName("Flags")
    private String flags;

    @SerializedName("FragOff")
    private String fragoff;

    @SerializedName("TTL")
    private String ttl;

    @SerializedName("Protocol")
    private String protocol;

    @SerializedName("Checksum")
    private String checksum;

    @SerializedName("Src")
    private String src;

    @SerializedName("Dst")
    private String dst;

}