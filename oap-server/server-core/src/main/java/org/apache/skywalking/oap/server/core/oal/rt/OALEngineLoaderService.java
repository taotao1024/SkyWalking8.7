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

package org.apache.skywalking.oap.server.core.oal.rt;

import java.lang.reflect.Constructor;
import java.util.HashSet;
import java.util.Set;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.skywalking.oap.server.core.CoreModule;
import org.apache.skywalking.oap.server.core.analysis.StreamAnnotationListener;
import org.apache.skywalking.oap.server.core.source.SourceReceiver;
import org.apache.skywalking.oap.server.core.storage.StorageBuilderFactory;
import org.apache.skywalking.oap.server.core.storage.StorageModule;
import org.apache.skywalking.oap.server.library.module.ModuleManager;
import org.apache.skywalking.oap.server.library.module.ModuleProvider;
import org.apache.skywalking.oap.server.library.module.ModuleStartException;
import org.apache.skywalking.oap.server.library.module.Service;

/**
 * Activate {@link OALEngine} according to {@link OALDefine}
 */
@Slf4j
@RequiredArgsConstructor
public class OALEngineLoaderService implements Service {

    private final Set<OALDefine> oalDefineSet = new HashSet<>();
    private final ModuleManager moduleManager;

    /**
     * Normally it is invoked in the {@link ModuleProvider#start()} of the receiver-plugin module.
     */
    public void load(OALDefine define) throws ModuleStartException {
        // 判断该OAL 是否被激活 oalDefineSet中记录 激活的OAL
        if (oalDefineSet.contains(define)) {
            // each oal define will only be activated once
            return;
        }
        try {
            // 获取 OALRuntime 实例
            OALEngine engine = loadOALEngine(define);
            // 初始化 StreamAnnotationListener 对象
            StreamAnnotationListener streamAnnotationListener = new StreamAnnotationListener(moduleManager);
            // 把初始化的 StreamAnnotationListener 对象 设置到OALEngine属性中
            engine.setStreamListener(streamAnnotationListener);
            // 在CoreModuleProvider 中找到SourceReceiverImpl对象，然后调用getDispatcherDetectorListener()方法 获取到最终的 DispatcherDetector 对象
            engine.setDispatcherListener(moduleManager.find(CoreModule.NAME)
                                                      .provider()
                                                      .getService(SourceReceiver.class)
                                                      .getDispatcherDetectorListener());
            // 获取MysqlStorageProvider中初始化好的storageBuilderFactory对象 其实是 StorageBuilderFactory.Definition 对象
            engine.setStorageBuilderFactory(moduleManager.find(StorageModule.NAME)
                                                         .provider()
                                                         .getService(StorageBuilderFactory.class));
            // 获取到 自己的ClassLoader 并调用OALRuntime的start()方法 启动
            engine.start(OALEngineLoaderService.class.getClassLoader());
            // 通知
            engine.notifyAllListeners();

            oalDefineSet.add(define);
        } catch (ReflectiveOperationException | OALCompileException e) {
            throw new ModuleStartException(e.getMessage(), e);
        }
    }

    /**
     * Load the OAL Engine runtime, because runtime module depends on core, so we have to use class::forname to locate
     * it.
     */
    private static OALEngine loadOALEngine(OALDefine define) throws ReflectiveOperationException {
        Class<?> engineRTClass = Class.forName("org.apache.skywalking.oal.rt.OALRuntime");
        Constructor<?> engineRTConstructor = engineRTClass.getConstructor(OALDefine.class);
        return (OALEngine) engineRTConstructor.newInstance(define);
    }
}
