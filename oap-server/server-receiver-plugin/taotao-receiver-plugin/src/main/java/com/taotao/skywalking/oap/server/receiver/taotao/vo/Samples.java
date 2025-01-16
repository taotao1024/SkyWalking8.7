package com.taotao.skywalking.oap.server.receiver.taotao.vo;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class Samples {

    @SerializedName("SequenceNo")
    private String sequenceno;

    @SerializedName("SourceID")
    private SourceID sourceid;

    @SerializedName("SamplingRate")
    private String samplingrate;

    @SerializedName("SamplePool")
    private String samplepool;

    @SerializedName("Drops")
    private String drops;

    @SerializedName("Input")
    private Input input;

    @SerializedName("Output")
    private Output output;

    @SerializedName("RecordsNo")
    private String RecordsNo;

    @SerializedName("Records")
    private Records records;
}