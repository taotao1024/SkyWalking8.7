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

import org.apache.skywalking.oap.server.library.util.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

class BootstrapFlow {
    private static final Logger LOGGER = LoggerFactory.getLogger(BootstrapFlow.class);

    private Map<String, ModuleDefine> loadedModules;
    private List<ModuleProvider> startupSequence;

    BootstrapFlow(Map<String, ModuleDefine> loadedModules) throws CycleDependencyException, ModuleNotFoundException {
        this.loadedModules = loadedModules;
        startupSequence = new LinkedList<>();
        // 遍历loadedModules中所有的ModuleDefine对应的ModuleProvider,然后根据每个ModuleProvider依赖的ModuleDefine进行排序
        makeSequence();
    }

    @SuppressWarnings("unchecked")
    void start(ModuleManager moduleManager) throws ModuleNotFoundException, ServiceNotProvidedException, ModuleStartException {
        int i = 0;
        for (ModuleProvider provider : startupSequence) {
            LOGGER.info("start [{}/{}] the provider [{}] in [{}] module. Start", ++i, startupSequence.size(), provider.name(), provider.getModuleName());
            provider.requiredCheck(provider.getModule().services());
            // 初始化 操作句柄、监听器 等
            provider.start();
            LOGGER.info("start [{}/{}] the provider [{}] in [{}] module.  End ", i, startupSequence.size(), provider.name(), provider.getModuleName());
        }
    }

    void notifyAfterCompleted() throws ServiceNotProvidedException, ModuleStartException {
        int i = 0;
        for (ModuleProvider provider : startupSequence) {
            LOGGER.info("notify [{}/{}] the provider [{}] in [{}] module. Start", ++i, startupSequence.size(), provider.name(), provider.getModuleName());
            provider.notifyAfterCompleted();
            LOGGER.info("notify [{}/{}] the provider [{}] in [{}] module.  End ", i, startupSequence.size(), provider.name(), provider.getModuleName());
        }
    }

    private void makeSequence() throws CycleDependencyException, ModuleNotFoundException {
        List<ModuleProvider> allProviders = new ArrayList<>();
        for (final ModuleDefine module : loadedModules.values()) {
            // 取出所有以来的模块
            String[] requiredModules = module.provider().requiredModules();
            if (requiredModules != null) {
                for (String requiredModule : requiredModules) {
                    if (!loadedModules.containsKey(requiredModule)) {
                        throw new ModuleNotFoundException(
                            requiredModule + " module is required by "
                                + module.provider().getModuleName() + "."
                                + module.provider().name() + ", but not found.");
                    }
                }
            }

            allProviders.add(module.provider());
        }
        // 根据依赖关系 进行排序
        do {
            int numOfToBeSequenced = allProviders.size();
            for (int i = 0; i < allProviders.size(); i++) {
                ModuleProvider provider = allProviders.get(i);
                String[] requiredModules = provider.requiredModules();
                if (CollectionUtils.isNotEmpty(requiredModules)) {
                    boolean isAllRequiredModuleStarted = true;
                    for (String module : requiredModules) {
                        // find module in all ready existed startupSequence
                        boolean exist = false;
                        for (ModuleProvider moduleProvider : startupSequence) {
                            if (moduleProvider.getModuleName().equals(module)) {
                                exist = true;
                                break;
                            }
                        }
                        if (!exist) {
                            isAllRequiredModuleStarted = false;
                            break;
                        }
                    }

                    if (isAllRequiredModuleStarted) {
                        startupSequence.add(provider);
                        allProviders.remove(i);
                        i--;
                    }
                } else {
                    startupSequence.add(provider);
                    allProviders.remove(i);
                    i--;
                }
            }

            if (numOfToBeSequenced == allProviders.size()) {
                StringBuilder unSequencedProviders = new StringBuilder();
                allProviders.forEach(provider -> unSequencedProviders.append(provider.getModuleName())
                                                                     .append("[provider=")
                                                                     .append(provider.getClass().getName())
                                                                     .append("]\n"));
                throw new CycleDependencyException(
                    "Exist cycle module dependencies in \n" + unSequencedProviders.substring(0, unSequencedProviders
                        .length() - 1));
            }
        }
        while (allProviders.size() != 0);
    }
}
