package com.taotao.skywalking.oap.server.receiver.taotao.vo;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.util.List;

@Data
public class Netflowv9Vo {

    @SerializedName("AgentID")
    private String AgentID;

    @SerializedName("Header")
    private HeaderBean Header;

    @Data
    public static class HeaderBean{
        @SerializedName("Version")
        private String Version;

        @SerializedName("Count")
        private String Count;

        @SerializedName("SysUpTime")
        private Long SysUpTime;

        @SerializedName("UNIXSecs")
        private Long UNIXSecs;

        @SerializedName("SeqNum")
        private Long SeqNum;

        @SerializedName("SrcID")
        private Long SrcID;

    }

    @SerializedName("DataSets")
    private List<List<KeyValueBean>> DataSets;

    @Data
    public static class KeyValueBean{
        @SerializedName("I")
        private String I;

        @SerializedName("V")
        private String V;
    }
}
