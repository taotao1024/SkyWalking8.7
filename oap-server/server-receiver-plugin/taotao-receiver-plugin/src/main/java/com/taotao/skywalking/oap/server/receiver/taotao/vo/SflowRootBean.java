package com.taotao.skywalking.oap.server.receiver.taotao.vo;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.util.List;

@Data
public class SflowRootBean {

    @SerializedName("Version")
    private String version;

    @SerializedName("IPVersion")
    private String ipversion;

    @SerializedName("AgentSubID")
    private String agentsubid;

    @SerializedName("SequenceNo")
    private String sequenceno;

    @SerializedName("SysUpTime")
    private String sysuptime;

    @SerializedName("SamplesNo")
    private String samplesno;

    @SerializedName("Samples")
    private List<Samples> samples;

//    @SerializedName("Counters")
//    private List<Object> counters;

    @SerializedName("IPAddress")
    private String ipaddress;

    @SerializedName("ColTime")
    private String coltime;

}