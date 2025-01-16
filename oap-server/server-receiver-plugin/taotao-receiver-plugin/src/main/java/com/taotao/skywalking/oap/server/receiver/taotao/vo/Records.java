package com.taotao.skywalking.oap.server.receiver.taotao.vo;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class Records {

    @SerializedName("ExtRouter")
    private ExtRouter extrouter;

    @SerializedName("ExtSwitch")
    private ExtSwitch extswitch;

    @SerializedName("RawHeader")
    private RawHeader rawheader;
}