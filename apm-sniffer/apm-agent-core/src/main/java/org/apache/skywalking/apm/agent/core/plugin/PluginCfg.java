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

package org.apache.skywalking.apm.agent.core.plugin;

import org.apache.skywalking.apm.agent.core.plugin.exception.IllegalPluginDefineException;
import org.apache.skywalking.apm.agent.core.logging.api.ILog;
import org.apache.skywalking.apm.agent.core.logging.api.LogManager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public enum PluginCfg {
    INSTANCE;

    private static final ILog LOGGER = LogManager.getLogger(PluginCfg.class);

    private List<PluginDefine> pluginClassList = new ArrayList<PluginDefine>();
    private PluginSelector pluginSelector = new PluginSelector();

    /**
     * PluginCfg的方法会把skywalking-plugin.def转换为PluginDefine对象
     * 属性：插件名和插件定义的类名 最后剔除配置文件中指定的不需要启用的插
     * @param input
     * @throws IOException
     */
    void load(InputStream input) throws IOException {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));
            String pluginDefine;
            while ((pluginDefine = reader.readLine()) != null) {
                try {
                    if (pluginDefine.trim().length() == 0 || pluginDefine.startsWith("#")) {
                        continue;
                    }
                    // skywalking-plugin.def转换为PluginDefine对象
                    PluginDefine plugin = PluginDefine.build(pluginDefine);
                    pluginClassList.add(plugin);
                } catch (IllegalPluginDefineException e) {
                    LOGGER.error(e, "Failed to format plugin({}) define.", pluginDefine);
                }
            }
            // 排除不起用的插件
            // 剔除配置文件中指定的不需要启用的插件
            pluginClassList = pluginSelector.select(pluginClassList);
        } finally {
            input.close();
        }
    }

    public List<PluginDefine> getPluginClassList() {
        return pluginClassList;
    }

}
