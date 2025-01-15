package com.taotao.skywalking.oap.server.receiver.taotao.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;


@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class L4 {

    @JsonProperty("SrcPort")
    private String srcport;

    @JsonProperty("DstPort")
    private String dstport;

    @JsonProperty("DataOffset")
    private String dataoffset;

    @JsonProperty("Reserved")
    private String reserved;

    @JsonProperty("Flags")
    private String flags;

}