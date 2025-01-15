package com.taotao.skywalking.oap.server.receiver.taotao.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Samples {

    @JsonProperty("SequenceNo")
    private String sequenceno;

    @JsonProperty("SourceID")
    private SourceID sourceid;

    @JsonProperty("SamplingRate")
    private String samplingrate;

    @JsonProperty("SamplePool")
    private String samplepool;

    @JsonProperty("Drops")
    private String drops;

    @JsonProperty("Input")
    private Input input;

    @JsonProperty("Output")
    private Output output;

    @JsonProperty("RecordsNo")
    private String RecordsNo;

    @JsonProperty("Records")
    private Records records;
}