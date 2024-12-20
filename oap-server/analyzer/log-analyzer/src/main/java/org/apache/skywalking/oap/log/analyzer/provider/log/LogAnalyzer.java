/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.skywalking.oap.log.analyzer.provider.log;

import com.google.protobuf.Message;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.skywalking.apm.network.logging.v3.LogData;
import org.apache.skywalking.apm.util.StringUtil;
import org.apache.skywalking.oap.log.analyzer.provider.LogAnalyzerModuleConfig;
import org.apache.skywalking.oap.log.analyzer.provider.log.listener.LogAnalysisListener;
import org.apache.skywalking.oap.server.library.module.ModuleManager;

/**
 * Analyze the collected log data, is the entry point for log analysis.
 */
@Slf4j
@RequiredArgsConstructor
public class LogAnalyzer {
    private final ModuleManager moduleManager;
    private final LogAnalyzerModuleConfig moduleConfig;
    private final ILogAnalysisListenerFactoryManager factoryManager;

    private final List<LogAnalysisListener> listeners = new ArrayList<>();

    public void doAnalysis(LogData.Builder builder, Message extraLog) {
        if (StringUtil.isEmpty(builder.getService())) {
            // If the service name is empty, the log will be ignored.
            log.debug("The log is ignored because the Service name is empty");
            return;
        }
        // 创建监听
        createListeners();
        if (builder.getTimestamp() == 0) {
            // If no timestamp, OAP server would use the received timestamp as log's timestamp
            builder.setTimestamp(System.currentTimeMillis());
        }
        // 通知
        notifyListener(builder, extraLog);
        notifyListenerToBuild();
    }

    private void notifyListener(LogData.Builder builder, final Message extraLog) {
        listeners.forEach(listener -> listener.parse(builder, extraLog));
    }

    private void notifyListenerToBuild() {
        listeners.forEach(LogAnalysisListener::build);
    }

    private void createListeners() {
        factoryManager.getLogAnalysisListenerFactories()
                      .forEach(factory -> listeners.add(factory.create()));
    }
}
