package com.taotao.skywalking.oap.server.receiver.taotao.vo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class SflowRootBean {

    @JsonProperty("Version")
    private String version;

    @JsonProperty("IPVersion")
    private String ipversion;

    @JsonProperty("AgentSubID")
    private String agentsubid;

    @JsonProperty("SequenceNo")
    private String sequenceno;

    @JsonProperty("SysUpTime")
    private String sysuptime;

    @JsonProperty("SamplesNo")
    private String samplesno;

    @JsonProperty("Samples")
    private List<Samples> samples;

//    @JsonProperty("Counters")
//    private List<Object> counters;

    @JsonProperty("IPAddress")
    private String ipaddress;

    @JsonProperty("ColTime")
    private String coltime;

}