package com.taotao.skywalking.oap.server.receiver.taotao.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class Netflowv9Vo {

    @JsonProperty("AgentID")
    private String AgentID;

    @JsonProperty("Header")
    private HeaderBean Header;

    @Data
    public static class HeaderBean{
        @JsonProperty("Version")
        private String Version;

        @JsonProperty("Count")
        private String Count;

        @JsonProperty("SysUpTime")
        private Long SysUpTime;

        @JsonProperty("UNIXSecs")
        private Long UNIXSecs;

        @JsonProperty("SeqNum")
        private Long SeqNum;

        @JsonProperty("SrcID")
        private Long SrcID;

    }

    @JsonProperty("DataSets")
    private List<List<KeyValueBean>> DataSets;

    @Data
    public static class KeyValueBean{
        @JsonProperty("I")
        private String I;

        @JsonProperty("V")
        private String V;
    }
}
