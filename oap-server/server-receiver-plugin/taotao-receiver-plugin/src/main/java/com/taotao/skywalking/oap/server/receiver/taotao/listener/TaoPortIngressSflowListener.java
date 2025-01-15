package com.taotao.skywalking.oap.server.receiver.taotao.listener;

import com.taotao.skywalking.oap.server.receiver.taotao.TaotaoConfig;
import org.apache.skywalking.oap.server.core.source.TaoPortIngressSource;
import com.taotao.skywalking.oap.server.receiver.taotao.vo.Samples;
import com.taotao.skywalking.oap.server.receiver.taotao.vo.SflowRootBean;
import org.apache.skywalking.oap.server.core.CoreModule;
import org.apache.skywalking.oap.server.core.analysis.TimeBucket;
import org.apache.skywalking.oap.server.core.config.NamingControl;
import org.apache.skywalking.oap.server.core.source.ISource;
import org.apache.skywalking.oap.server.core.source.SourceReceiver;
import org.apache.skywalking.oap.server.library.module.ModuleManager;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TaoPortIngressSflowListener implements TaoSflowAnalysisListener {

    private final SourceReceiver sourceReceiver;

    private final NamingControl namingControl;

    private List<ISource> source = new ArrayList<>();

    public TaoPortIngressSflowListener(SourceReceiver sourceReceiver, NamingControl namingControl) {
        this.sourceReceiver = sourceReceiver;

        this.namingControl = namingControl;
    }


    @Override
    public void build() {
        source.forEach(everySource -> {
            sourceReceiver.receive(everySource);
        });
        //重置source
        source.clear();
    }

    @Override
    public void parse(SflowRootBean sflowRootBean) {

        for (Samples sample : sflowRootBean.getSamples()) {
            TaoPortIngressSource sflowSource = new TaoPortIngressSource();
            sflowSource.setServiceName(sflowRootBean.getIpaddress());
            sflowSource.setName(sample.getRecords().getRawheader().getL4().getDstport());
            sflowSource.setTotalLen(Integer.valueOf(sample.getRecords().getRawheader().getL3().getTotallen()));
            sflowSource.setTimeBucket(TimeBucket.getMinuteTimeBucket(new Date().getTime()));
            source.add(sflowSource);
        }
    }

    public static class Factory implements TaoSflowListenerFactory {

        private final SourceReceiver sourceReceiver;

        private final NamingControl namingControl;

        public Factory(ModuleManager moduleManager, TaotaoConfig moduleConfig) {
            this.sourceReceiver = moduleManager.find(CoreModule.NAME).provider().getService(SourceReceiver.class);
            this.namingControl = moduleManager.find(CoreModule.NAME).provider().getService(NamingControl.class);
        }

        @Override
        public TaoSflowAnalysisListener create(ModuleManager moduleManager, TaotaoConfig moduleConfig) {
            return new TaoPortIngressSflowListener(sourceReceiver, namingControl);
        }
    }
}
