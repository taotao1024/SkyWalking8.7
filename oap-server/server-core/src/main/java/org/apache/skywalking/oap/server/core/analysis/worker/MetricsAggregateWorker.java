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

package org.apache.skywalking.oap.server.core.analysis.worker;

import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.apache.skywalking.apm.commons.datacarrier.DataCarrier;
import org.apache.skywalking.apm.commons.datacarrier.consumer.BulkConsumePool;
import org.apache.skywalking.apm.commons.datacarrier.consumer.ConsumerPoolFactory;
import org.apache.skywalking.apm.commons.datacarrier.consumer.IConsumer;
import org.apache.skywalking.oap.server.core.UnexpectedException;
import org.apache.skywalking.oap.server.core.analysis.data.MergableBufferedData;
import org.apache.skywalking.oap.server.core.analysis.metrics.Metrics;
import org.apache.skywalking.oap.server.core.worker.AbstractWorker;
import org.apache.skywalking.oap.server.library.module.ModuleDefineHolder;
import org.apache.skywalking.oap.server.telemetry.TelemetryModule;
import org.apache.skywalking.oap.server.telemetry.api.CounterMetrics;
import org.apache.skywalking.oap.server.telemetry.api.MetricsCreator;
import org.apache.skywalking.oap.server.telemetry.api.MetricsTag;

/**
 * MetricsAggregateWorker provides an in-memory metrics merging capability. This aggregation is called L1 aggregation,
 * it merges the data just after the receiver analysis. The metrics belonging to the same entity, metrics type and time
 * bucket, the L1 aggregation will merge them into one metrics object to reduce the unnecessary memory and network
 * payload.
 * <p>
 * MetricsAggregateWorker 提供内存中的指标合并功能。这种聚合称为 L1 聚合，它在接收者分析之后合并数据。属于同一实体、指标类型和时间存储桶的指标，
 * L1 聚合会将它们合并到一个指标对象中，以减少不必要的内存和网络负载。
 */
@Slf4j
public class MetricsAggregateWorker extends AbstractWorker<Metrics> {
    public final long l1FlushPeriod;
    private AbstractWorker<Metrics> nextWorker;
    private final DataCarrier<Metrics> dataCarrier;
    private final MergableBufferedData<Metrics> mergeDataCache;
    private CounterMetrics aggregationCounter;
    private long lastSendTime = 0;

    MetricsAggregateWorker(ModuleDefineHolder moduleDefineHolder, AbstractWorker<Metrics> nextWorker,
                           String modelName, long l1FlushPeriod) {
        super(moduleDefineHolder);
        this.nextWorker = nextWorker;
        this.mergeDataCache = new MergableBufferedData();
        String name = "METRICS_L1_AGGREGATION";
        this.dataCarrier = new DataCarrier<>("MetricsAggregateWorker." + modelName, name, 2, 10000);

        BulkConsumePool.Creator creator = new BulkConsumePool.Creator(
            name, BulkConsumePool.Creator.recommendMaxSize() * 2, 20);
        try {
            ConsumerPoolFactory.INSTANCE.createIfAbsent(name, creator);
        } catch (Exception e) {
            throw new UnexpectedException(e.getMessage(), e);
        }
        this.dataCarrier.consume(ConsumerPoolFactory.INSTANCE.get(name), new AggregatorConsumer());

        MetricsCreator metricsCreator = moduleDefineHolder.find(TelemetryModule.NAME)
                                                          .provider()
                                                          .getService(MetricsCreator.class);
        aggregationCounter = metricsCreator.createCounter(
            "metrics_aggregation", "The number of rows in aggregation",
            new MetricsTag.Keys("metricName", "level", "dimensionality"),
            new MetricsTag.Values(modelName, "1", "minute")
        );
        this.l1FlushPeriod = l1FlushPeriod;
    }

    /**
     * MetricsAggregateWorker#in operation does include enqueue only
     */
    @Override
    public final void in(Metrics metrics) {
        dataCarrier.produce(metrics);
    }

    /**
     * Dequeue consuming. According to {@link IConsumer#consume(List)}, this is a serial operation for every work
     * instance.
     * 数据消费
     *
     * @param metricsList from the queue.
     */
    private void onWork(List<Metrics> metricsList) {
        metricsList.forEach(metrics -> {
            aggregationCounter.inc();
            // mergeDataCache 用于存储当前L1级聚合已经处理过的Metric数据，
            // 因为在声明L1级聚合的时候，会设置L1级聚合 冲刷buffer的时间为500ms.
            mergeDataCache.accept(metrics);
        });

        flush();
    }

    private void flush() {
        long currentTime = System.currentTimeMillis();
        if (currentTime - lastSendTime > l1FlushPeriod) {
            mergeDataCache.read().forEach(
                data -> {
                    if (log.isDebugEnabled()) {
                        log.debug(data.toString());
                    }
                    nextWorker.in(data);
                }
            );
            lastSendTime = currentTime;
        }
    }

    /**
     * 数据消费者
     */
    private class AggregatorConsumer implements IConsumer<Metrics> {
        @Override
        public void init() {
        }

        @Override
        public void consume(List<Metrics> data) {
            MetricsAggregateWorker.this.onWork(data);
        }

        @Override
        public void onError(List<Metrics> data, Throwable t) {
            log.error(t.getMessage(), t);
        }

        @Override
        public void onExit() {
        }

        @Override
        public void nothingToConsume() {
            flush();
        }
    }
}