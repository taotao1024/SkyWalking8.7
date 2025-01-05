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

package org.apache.skywalking.oap.server.library.module;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.ServiceLoader;

/**
 * The <code>ModuleManager</code> takes charge of all {@link ModuleDefine}s in collector.
 */
public class ModuleManager implements ModuleDefineHolder {
    private static final Logger LOGGER = LoggerFactory.getLogger(ModuleManager.class);

    private boolean isInPrepareStage = true;
    private final Map<String, ModuleDefine> loadedModules = new HashMap<>();

    /**
     * Init the given modules
     */
    public void init(ApplicationConfiguration applicationConfiguration) throws ModuleNotFoundException,
            ProviderNotFoundException, ServiceNotProvidedException, CycleDependencyException,
            ModuleConfigException, ModuleStartException {
        String[] moduleNames = applicationConfiguration.moduleList();
        // SPI 加载 ModuleDefine
        ServiceLoader<ModuleDefine> moduleServiceLoader = ServiceLoader.load(ModuleDefine.class);
        for (ModuleDefine moduleDefine : moduleServiceLoader) {
            System.out.println(moduleDefine.name());
        }
        // SPI 加载 ModuleProvider
        ServiceLoader<ModuleProvider> moduleProviderLoader = ServiceLoader.load(ModuleProvider.class);
        for (ModuleProvider moduleProvider : moduleProviderLoader) {
            System.out.println(moduleProvider.module());
        }
        // moduleNames 去重
        HashSet<String> moduleSet = new HashSet<>(Arrays.asList(moduleNames));
        for (ModuleDefine module : moduleServiceLoader) {
            if (moduleSet.contains(module.name())) {
                // 运行模块的 prepare 阶段
                module.prepare(this, applicationConfiguration.getModuleConfiguration(module.name()), moduleProviderLoader);
                // 将已经加载好的XxxModule放到loadeModules中
                loadedModules.put(module.name(), module);
                // 降低 堆内存使用？
                moduleSet.remove(module.name());
            }
        }
        // 完成准备阶段
        isInPrepareStage = false;

        if (moduleSet.size() > 0) {
            throw new ModuleNotFoundException(moduleSet.toString() + " missing.");
        }
        // 遍历所有的ModuleDefine，根据与之对应的ModeleProvider依赖的ModuleDefine,对ModuleProvider进行排序，并排除了循环依赖的问题。
        BootstrapFlow bootstrapFlow = new BootstrapFlow(loadedModules);
        // 启动
        LOGGER.info("----------------------- 启动各模块 配置的服务提供者 -----------------------");
        bootstrapFlow.start(this);
        // 通知
        LOGGER.info("----------------------- 启动各模块 对应的回调函数  -----------------------");
        bootstrapFlow.notifyAfterCompleted();
    }

    @Override
    public boolean has(String moduleName) {
        return loadedModules.get(moduleName) != null;
    }

    @Override
    public ModuleProviderHolder find(String moduleName) throws ModuleNotFoundRuntimeException {
        assertPreparedStage();
        ModuleDefine module = loadedModules.get(moduleName);
        if (module != null)
            return module;
        throw new ModuleNotFoundRuntimeException(moduleName + " missing.");
    }

    private void assertPreparedStage() {
        if (isInPrepareStage) {
            throw new AssertionError("Still in preparing stage.");
        }
    }
}
