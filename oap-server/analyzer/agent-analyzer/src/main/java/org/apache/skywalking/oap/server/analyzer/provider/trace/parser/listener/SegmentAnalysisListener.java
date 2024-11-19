/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package org.apache.skywalking.oap.server.analyzer.provider.trace.parser.listener;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.skywalking.apm.network.language.agent.v3.SegmentObject;
import org.apache.skywalking.apm.network.language.agent.v3.SpanObject;
import org.apache.skywalking.apm.util.StringUtil;
import org.apache.skywalking.oap.server.analyzer.provider.AnalyzerModuleConfig;
import org.apache.skywalking.oap.server.analyzer.provider.trace.TraceLatencyThresholdsAndWatcher;
import org.apache.skywalking.oap.server.analyzer.provider.trace.parser.listener.strategy.SegmentStatusAnalyzer;
import org.apache.skywalking.oap.server.analyzer.provider.trace.parser.listener.strategy.SegmentStatusStrategy;
import org.apache.skywalking.oap.server.core.Const;
import org.apache.skywalking.oap.server.core.CoreModule;
import org.apache.skywalking.oap.server.core.analysis.IDManager;
import org.apache.skywalking.oap.server.core.analysis.NodeType;
import org.apache.skywalking.oap.server.core.analysis.TimeBucket;
import org.apache.skywalking.oap.server.core.analysis.manual.searchtag.Tag;
import org.apache.skywalking.oap.server.core.config.ConfigService;
import org.apache.skywalking.oap.server.core.config.NamingControl;
import org.apache.skywalking.oap.server.core.source.Segment;
import org.apache.skywalking.oap.server.core.source.SourceReceiver;
import org.apache.skywalking.oap.server.library.module.ModuleManager;
import org.apache.skywalking.oap.server.library.util.BooleanUtils;

/**
 * SegmentSpanListener forwards the segment raw data to the persistence layer with the query required conditions.
 */
@Slf4j
@RequiredArgsConstructor
public class SegmentAnalysisListener implements FirstAnalysisListener, EntryAnalysisListener, SegmentListener {
    private final SourceReceiver sourceReceiver;
    private final TraceSegmentSampler sampler;
    private final boolean forceSampleErrorSegment;
    private final NamingControl namingControl;
    private final List<String> searchableTagKeys;
    private final SegmentStatusAnalyzer segmentStatusAnalyzer;
    private final TraceLatencyThresholdsAndWatcher traceLatencyThresholdsAndWatcher;

    private final Segment segment = new Segment();
    private SAMPLE_STATUS sampleStatus = SAMPLE_STATUS.UNKNOWN;
    private String serviceName = Const.EMPTY_STRING;
    private String serviceId = Const.EMPTY_STRING;
    private String endpointId = Const.EMPTY_STRING;
    private String endpointName = Const.EMPTY_STRING;
    private long startTimestamp;
    private long endTimestamp;
    private int duration;
    private boolean isError;

    @Override
    public boolean containsPoint(Point point) {
        return Point.First.equals(point) || Point.Entry.equals(point) || Point.Segment.equals(point);
    }

    @Override
    public void parseFirst(SpanObject span, SegmentObject segmentObject) {
        if (sampleStatus.equals(SAMPLE_STATUS.IGNORE)) {
            return;
        }

        if (StringUtil.isEmpty(serviceId)) {
            serviceName = namingControl.formatServiceName(segmentObject.getService());
            serviceId = IDManager.ServiceID.buildId(
                serviceName,
                NodeType.Normal
            );
        }

        long timeBucket = TimeBucket.getRecordTimeBucket(startTimestamp);

        segment.setSegmentId(segmentObject.getTraceSegmentId());
        segment.setServiceId(serviceId);
        segment.setServiceInstanceId(IDManager.ServiceInstanceID.buildId(
            serviceId,
            namingControl.formatInstanceName(segmentObject.getServiceInstance())
        ));
        segment.setLatency(duration);
        segment.setStartTime(startTimestamp);
        segment.setTimeBucket(timeBucket);
        segment.setEndTime(endTimestamp);
        segment.setIsError(BooleanUtils.booleanToValue(isError));
        segment.setDataBinary(segmentObject.toByteArray());
        segment.setVersion(3);

        endpointName = namingControl.formatEndpointName(serviceName, span.getOperationName());
        endpointId = IDManager.EndpointID.buildId(
            serviceId,
            endpointName
        );
    }

    @Override
    public void parseEntry(SpanObject span, SegmentObject segmentObject) {
        if (StringUtil.isEmpty(serviceId)) {
            serviceName = namingControl.formatServiceName(segmentObject.getService());
            serviceId = IDManager.ServiceID.buildId(
                serviceName, NodeType.Normal);
        }

        endpointName = namingControl.formatEndpointName(serviceName, span.getOperationName());
        endpointId = IDManager.EndpointID.buildId(
            serviceId,
            endpointName
        );
    }

    @Override
    public void parseSegment(SegmentObject segmentObject) {
        // Segment.traceId
        segment.setTraceId(segmentObject.getTraceId());
        // 遍历 Segment中 所有的 Span
        segmentObject.getSpansList().forEach(span -> {
            // 开始时间
            if (startTimestamp == 0 || startTimestamp > span.getStartTime()) {
                startTimestamp = span.getStartTime();
            }
            // 结束时间
            if (span.getEndTime() > endTimestamp) {
                endTimestamp = span.getEndTime();
            }
            // isError() --> FromEntrySpan、FormFirstSpan、FormSpanStatus
            // isError 默认值为 false
            // segmentStatusAnalyzer 由 Factory 进行初始化
            isError = isError || segmentStatusAnalyzer.isError(span);
            // 收集 Span 中的信息到 Tag 中
            appendSearchableTags(span);
        });
        // 耗时
        final long accurateDuration = endTimestamp - startTimestamp;
        // 时间间隔
        duration = accurateDuration > Integer.MAX_VALUE ? Integer.MAX_VALUE : (int) accurateDuration;
        // 默认值为 SAMPLE_STATUS.UNKNOWN
        if (sampleStatus.equals(SAMPLE_STATUS.UNKNOWN) || sampleStatus.equals(SAMPLE_STATUS.IGNORE)) {
            if (sampler.shouldSample(segmentObject.getTraceId())) {
                sampleStatus = SAMPLE_STATUS.SAMPLED;
            } else if (isError && forceSampleErrorSegment) {
                sampleStatus = SAMPLE_STATUS.SAMPLED;
            } else if (traceLatencyThresholdsAndWatcher.shouldSample(duration)) {
                sampleStatus = SAMPLE_STATUS.SAMPLED;
            } else {
                sampleStatus = SAMPLE_STATUS.IGNORE;
            }
        }
    }

    private void appendSearchableTags(SpanObject span) {
        HashSet<Tag> segmentTags = new HashSet<>();
        span.getTagsList().forEach(tag -> {
            if (searchableTagKeys.contains(tag.getKey())) {
                final Tag spanTag = new Tag(tag.getKey(), tag.getValue());
                if (!segmentTags.contains(spanTag)) {
                    segmentTags.add(spanTag);
                }

            }
        });
        segment.getTags().addAll(segmentTags);
    }

    @Override
    public void build() {
        if (sampleStatus.equals(SAMPLE_STATUS.IGNORE)) {
            if (log.isDebugEnabled()) {
                log.debug("segment ignored, trace id: {}", segment.getTraceId());
            }
            return;
        }

        if (log.isDebugEnabled()) {
            log.debug("segment listener build, segment id: {}", segment.getSegmentId());
        }

        segment.setEndpointId(endpointId);
        segment.setEndpointName(endpointName);

        sourceReceiver.receive(segment);
    }

    private enum SAMPLE_STATUS {
        UNKNOWN, SAMPLED, IGNORE
    }

    public static class Factory implements AnalysisListenerFactory {
        private final SourceReceiver sourceReceiver;
        private final TraceSegmentSampler sampler;
        private final boolean forceSampleErrorSegment;
        private final NamingControl namingControl;
        private final List<String> searchTagKeys;
        private final SegmentStatusAnalyzer segmentStatusAnalyzer;
        private final TraceLatencyThresholdsAndWatcher traceLatencyThresholdsAndWatcher;

        /**
         *
         * @param moduleManager
         * @param config {@link AnalyzerModuleConfig}
         */
        public Factory(ModuleManager moduleManager, AnalyzerModuleConfig config) {
            this.sourceReceiver = moduleManager.find(CoreModule.NAME).provider().getService(SourceReceiver.class);
            final ConfigService configService = moduleManager.find(CoreModule.NAME)
                                                             .provider()
                                                             .getService(ConfigService.class);
            this.searchTagKeys = Arrays.asList(configService.getSearchableTracesTags().split(Const.COMMA));
            this.sampler = new TraceSegmentSampler(config.getTraceSampleRateWatcher());
            this.forceSampleErrorSegment = config.isForceSampleErrorSegment();
            this.namingControl = moduleManager.find(CoreModule.NAME)
                                              .provider()
                                              .getService(NamingControl.class);
            this.segmentStatusAnalyzer = SegmentStatusStrategy.findByName(config.getSegmentStatusAnalysisStrategy())
                                                              .getExceptionAnalyzer();
            // 查看 application.yml 文件 得到  config.getSegmentStatusAnalysisStrategy()的值默认是 FROM_SPAN_STAT
            this.traceLatencyThresholdsAndWatcher = config.getTraceLatencyThresholdsAndWatcher();
        }

        @Override
        public AnalysisListener create(ModuleManager moduleManager, AnalyzerModuleConfig config) {
            return new SegmentAnalysisListener(
                sourceReceiver,
                sampler,
                forceSampleErrorSegment,
                namingControl,
                searchTagKeys,
                segmentStatusAnalyzer,
                traceLatencyThresholdsAndWatcher
            );
        }
    }
}
