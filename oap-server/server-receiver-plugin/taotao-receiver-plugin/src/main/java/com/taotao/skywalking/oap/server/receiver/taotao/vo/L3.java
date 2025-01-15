package com.taotao.skywalking.oap.server.receiver.taotao.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;


@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class L3 {

    @JsonProperty("Version")
    private String version;

    @JsonProperty("TOS")
    private String tos;

    @JsonProperty("TotalLen")
    private String totallen;

    @JsonProperty("ID")
    private String id;

    @JsonProperty("Flags")
    private String flags;

    @JsonProperty("FragOff")
    private String fragoff;

    @JsonProperty("TTL")
    private String ttl;

    @JsonProperty("Protocol")
    private String protocol;

    @JsonProperty("Checksum")
    private String checksum;

    @JsonProperty("Src")
    private String src;

    @JsonProperty("Dst")
    private String dst;

}