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

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.Getter;
import lombok.Setter;
import org.apache.skywalking.oap.server.core.CoreModule;
import org.apache.skywalking.oap.server.core.UnexpectedException;
import org.apache.skywalking.oap.server.core.analysis.DownSampling;
import org.apache.skywalking.oap.server.core.analysis.MetricsExtension;
import org.apache.skywalking.oap.server.core.analysis.Stream;
import org.apache.skywalking.oap.server.core.analysis.StreamDefinition;
import org.apache.skywalking.oap.server.core.analysis.StreamProcessor;
import org.apache.skywalking.oap.server.core.analysis.metrics.Metrics;
import org.apache.skywalking.oap.server.core.config.DownSamplingConfigService;
import org.apache.skywalking.oap.server.core.storage.IMetricsDAO;
import org.apache.skywalking.oap.server.core.storage.StorageBuilderFactory;
import org.apache.skywalking.oap.server.core.storage.StorageDAO;
import org.apache.skywalking.oap.server.core.storage.StorageException;
import org.apache.skywalking.oap.server.core.storage.StorageModule;
import org.apache.skywalking.oap.server.core.storage.annotation.Storage;
import org.apache.skywalking.oap.server.core.storage.model.Model;
import org.apache.skywalking.oap.server.core.storage.model.ModelCreator;
import org.apache.skywalking.oap.server.core.storage.type.StorageBuilder;
import org.apache.skywalking.oap.server.core.worker.IWorkerInstanceSetter;
import org.apache.skywalking.oap.server.library.module.ModuleDefineHolder;

/**
 * MetricsStreamProcessor represents the entrance and creator of the metrics streaming aggregation work flow.
 *
 * {@link #in(Metrics)} provides the major entrance for metrics streaming calculation.
 *
 * {@link #create(ModuleDefineHolder, Stream, Class)} creates the workers and work flow for every metrics.
 */
public class MetricsStreamProcessor implements StreamProcessor<Metrics> {
    /**
     * Singleton instance.
     */
    private final static MetricsStreamProcessor PROCESSOR = new MetricsStreamProcessor();

    /**
     * Worker table hosts all entrance workers.
     */
    private Map<Class<? extends Metrics>, MetricsAggregateWorker> entryWorkers = new HashMap<>();

    /**
     * Worker table hosts all persistent workers.
     */
    @Getter
    private List<MetricsPersistentWorker> persistentWorkers = new ArrayList<>();

    /**
     * The period of L1 aggregation flush. Unit is ms.
     */
    @Setter
    @Getter
    private long l1FlushPeriod = 500;
    /**
     * Hold and forward CoreModuleConfig#enableDatabaseSession to the persistent worker.
     */
    @Setter
    @Getter
    private boolean enableDatabaseSession;
    /**
     * The threshold of session time. Unit is ms. Default value is 70s.
     */
    @Setter
    private long storageSessionTimeout = 70_000;
    /**
     * @since 8.7.0 TTL settings from {@link org.apache.skywalking.oap.server.core.CoreModuleConfig#getMetricsDataTTL()}
     */
    @Setter
    private int metricsDataTTL = 3;

    public static MetricsStreamProcessor getInstance() {
        return PROCESSOR;
    }

    @Override
    public void in(Metrics metrics) {
        MetricsAggregateWorker worker = entryWorkers.get(metrics.getClass());
        if (worker != null) {
            worker.in(metrics);
        }
    }

    /**
     * Create the workers and work flow for every metrics.
     *
     * @param moduleDefineHolder pointer of the module define.
     * @param stream             definition of the metrics class.
     * @param metricsClass       data type of the streaming calculation.
     */
    @Override
    public void create(ModuleDefineHolder moduleDefineHolder,
                       Stream stream,
                       Class<? extends Metrics> metricsClass) throws StorageException {
        this.create(moduleDefineHolder, StreamDefinition.from(stream), metricsClass);
    }

    @SuppressWarnings("unchecked")
    public void create(ModuleDefineHolder moduleDefineHolder,
                       StreamDefinition stream,
                       Class<? extends Metrics> metricsClass) throws StorageException {
        final StorageBuilderFactory storageBuilderFactory = moduleDefineHolder.find(StorageModule.NAME)
                                                                              .provider()
                                                                              .getService(StorageBuilderFactory.class);
        final Class<? extends StorageBuilder> builder = storageBuilderFactory.builderOf(
            metricsClass, stream.getBuilder());

        StorageDAO storageDAO = moduleDefineHolder.find(StorageModule.NAME).provider().getService(StorageDAO.class);
        IMetricsDAO metricsDAO;
        try {
            // 初始化MetricsBuilder类 最为参数 传入初始化的JDBCMetricsDao对象 在后续的L2级聚合数据落库时使用
            metricsDAO = storageDAO.newMetricsDao(builder.getDeclaredConstructor().newInstance());
        } catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            throw new UnexpectedException("Create " + stream.getBuilder().getSimpleName() + " metrics DAO failure.", e);
        }
        // 该对象用于后续创建数据表
        ModelCreator modelSetter = moduleDefineHolder.find(CoreModule.NAME).provider().getService(ModelCreator.class);
        DownSamplingConfigService configService = moduleDefineHolder.find(CoreModule.NAME)
                                                                    .provider()
                                                                    .getService(DownSamplingConfigService.class);

        MetricsPersistentWorker hourPersistentWorker = null;
        MetricsPersistentWorker dayPersistentWorker = null;

        MetricsTransWorker transWorker = null;

        final MetricsExtension metricsExtension = metricsClass.getAnnotation(MetricsExtension.class);
        /**
         * All metrics default are `supportDownSampling` and `insertAndUpdate`, unless it has explicit definition.
         */
        boolean supportDownSampling = true;
        boolean supportUpdate = true;
        boolean timeRelativeID = true;
        if (metricsExtension != null) {
            supportDownSampling = metricsExtension.supportDownSampling();
            supportUpdate = metricsExtension.supportUpdate();
            timeRelativeID = metricsExtension.timeRelativeID();
        }
        if (supportDownSampling) {
            // 小时
            if (configService.shouldToHour()) {
                // 创建Metrics信息 并创建数据表
                Model model = modelSetter.add(
                    metricsClass, stream.getScopeId(), new Storage(stream.getName(), timeRelativeID, DownSampling.Hour),
                    false
                );
                // 根据基于小时聚合数据的Worker 该聚合为L2级聚合
                // moduleDefineHolder 是 moduleNagage
                // metricsDAO 是 JDBCMetricsDao 里面有数据库连接句柄、MetricsBuilder 对象
                // model 需要操作的数据表信息
                hourPersistentWorker = downSamplingWorker(moduleDefineHolder, metricsDAO, model, supportUpdate);
            }
            // 天
            if (configService.shouldToDay()) {
                Model model = modelSetter.add(
                    metricsClass, stream.getScopeId(), new Storage(stream.getName(), timeRelativeID, DownSampling.Day),
                    false
                );
                dayPersistentWorker = downSamplingWorker(moduleDefineHolder, metricsDAO, model, supportUpdate);
            }

            transWorker = new MetricsTransWorker(
                moduleDefineHolder, hourPersistentWorker, dayPersistentWorker);
        }
        // 分钟
        Model model = modelSetter.add(
            metricsClass, stream.getScopeId(), new Storage(stream.getName(), timeRelativeID, DownSampling.Minute),
            false
        );
        // L2聚合 组合 ？ 调试后在添加注释
        MetricsPersistentWorker minutePersistentWorker = minutePersistentWorker(
            moduleDefineHolder, metricsDAO, model, transWorker, supportUpdate);

        String remoteReceiverWorkerName = stream.getName() + "_rec";
        IWorkerInstanceSetter workerInstanceSetter = moduleDefineHolder.find(CoreModule.NAME)
                                                                       .provider()
                                                                       .getService(IWorkerInstanceSetter.class);
        // 设置
        workerInstanceSetter.put(remoteReceiverWorkerName, minutePersistentWorker, metricsClass);
        // remoteWorker 是将L1级聚合好的数据 发送到L2级聚合的一个工具
        MetricsRemoteWorker remoteWorker = new MetricsRemoteWorker(moduleDefineHolder, remoteReceiverWorkerName);
        // 创建L1级聚合 L1级聚合初始化MetricsAggregateWorker
        MetricsAggregateWorker aggregateWorker = new MetricsAggregateWorker(
            moduleDefineHolder, remoteWorker, stream.getName(), l1FlushPeriod);
        // L1级对象  防区 EntryWorker
        entryWorkers.put(metricsClass, aggregateWorker);
    }

    private MetricsPersistentWorker minutePersistentWorker(ModuleDefineHolder moduleDefineHolder,
                                                           IMetricsDAO metricsDAO,
                                                           Model model,
                                                           MetricsTransWorker transWorker,
                                                           boolean supportUpdate) {
        AlarmNotifyWorker alarmNotifyWorker = new AlarmNotifyWorker(moduleDefineHolder);
        ExportWorker exportWorker = new ExportWorker(moduleDefineHolder);

        MetricsPersistentWorker minutePersistentWorker = new MetricsPersistentWorker(
            moduleDefineHolder, model, metricsDAO, alarmNotifyWorker, exportWorker, transWorker,
            enableDatabaseSession, supportUpdate, storageSessionTimeout, metricsDataTTL
        );
        persistentWorkers.add(minutePersistentWorker);

        return minutePersistentWorker;
    }

    private MetricsPersistentWorker downSamplingWorker(ModuleDefineHolder moduleDefineHolder,
                                                       IMetricsDAO metricsDAO,
                                                       Model model,
                                                       boolean supportUpdate) {
        // 初始化MetricsPersistentWorker 对象
        MetricsPersistentWorker persistentWorker = new MetricsPersistentWorker(
            moduleDefineHolder, model, metricsDAO,
            enableDatabaseSession, supportUpdate, storageSessionTimeout, metricsDataTTL
        );
        // 把创建好的L2级聚合对象放到persistentWorkers中
        persistentWorkers.add(persistentWorker);

        return persistentWorker;
    }
}
