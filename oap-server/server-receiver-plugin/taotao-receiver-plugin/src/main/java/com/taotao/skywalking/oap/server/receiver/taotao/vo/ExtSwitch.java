package com.taotao.skywalking.oap.server.receiver.taotao.vo;

import com.google.gson.annotations.SerializedName;
import lombok.Data;


@Data
public class ExtSwitch {

    @SerializedName("SrcVlan")
    private String srcvlan;

    @SerializedName("SrcPriority")
    private String srcpriority;

    @SerializedName("DstVlan")
    private String dstvlan;

    @SerializedName("DstPriority")
    private String dstpriority;


}