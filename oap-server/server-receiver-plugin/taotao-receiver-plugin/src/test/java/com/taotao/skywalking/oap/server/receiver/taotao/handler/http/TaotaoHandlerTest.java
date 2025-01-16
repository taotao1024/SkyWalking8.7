package com.taotao.skywalking.oap.server.receiver.taotao.handler.http;

import com.google.gson.Gson;
import com.taotao.skywalking.oap.server.receiver.taotao.vo.SflowRootBean;
import org.junit.Test;

public class TaotaoHandlerTest {

    @Test
    public void testGson() {
        String json = "{\"Version\":5,\"IPVersion\":1,\"AgentSubID\":0,\"SequenceNo\":7205430,\"SysUpTime\":1568406992,\"SamplesNo\":3,\"Samples\":[{\"SequenceNo\":10684287,\"SourceID\":{},\"SamplingRate\":1000,\"SamplePool\":2094353408,\"Drops\":0,\"Input\":{},\"Output\":{},\"RecordsNo\":5,\"Records\":{\"ExtRouter\":{\"NextHop\":\"172.16.3.254\",\"SrcMask\":24,\"DstMask\":24},\"ExtSwitch\":{\"SrcVlan\":1,\"SrcPriority\":0,\"DstVlan\":3,\"DstPriority\":0},\"RawHeader\":{\"L2\":{\"SrcMAC\":\"d0:c6:5b:34:6c:ab\",\"DstMAC\":\"04:fe:8d:bc:1b:30\",\"Vlan\":1,\"EtherType\":2048},\"L3\":{\"Version\":4,\"TOS\":0,\"TotalLen\":1317,\"ID\":0,\"Flags\":0,\"FragOff\":0,\"TTL\":52,\"Protocol\":17,\"Checksum\":16390,\"Src\":\"58.216.23.185\",\"Dst\":\"172.16.3.33\"},\"L4\":{\"SrcPort\":8004,\"DstPort\":45299}}}},{\"SequenceNo\":10684288,\"SourceID\":{},\"SamplingRate\":1000,\"SamplePool\":2094354408,\"Drops\":0,\"Input\":{},\"Output\":{},\"RecordsNo\":3,\"Records\":{\"ExtSwitch\":{\"SrcVlan\":1,\"SrcPriority\":0,\"DstVlan\":1,\"DstPriority\":0},\"RawHeader\":{\"L2\":{\"SrcMAC\":\"04:fe:8d:bc:1b:30\",\"DstMAC\":\"d0:c6:5b:34:6c:ab\",\"Vlan\":1,\"EtherType\":2048},\"L3\":{\"Version\":4,\"TOS\":0,\"TotalLen\":40,\"ID\":0,\"Flags\":0,\"FragOff\":0,\"TTL\":63,\"Protocol\":6,\"Checksum\":42718,\"Src\":\"172.16.3.193\",\"Dst\":\"36.110.192.178\"},\"L4\":{\"SrcPort\":50109,\"DstPort\":443,\"DataOffset\":5,\"Reserved\":0,\"Flags\":16}}}}],\"Counters\":[],\"IPAddress\":\"172.16.40.254\",\"ColTime\":1723167276}";
        Gson gson = new Gson();
        SflowRootBean sflowRootBean = gson.fromJson(json, SflowRootBean.class);
        System.out.println(sflowRootBean);
    }

}