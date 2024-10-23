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

package org.apache.skywalking.apm.agent.core.plugin.interceptor.enhance;

import java.io.PrintStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import org.apache.skywalking.apm.agent.core.plugin.bootstrap.IBootstrapLog;

/**
 * This assist help all bootstrap class core interceptor.
 * 此辅助帮助所有 bootstrap 类核心拦截器。
 */
public class BootstrapInterRuntimeAssist {
    private static final String AGENT_CLASSLOADER_DEFAULT = "org.apache.skywalking.apm.agent.core.plugin.loader.AgentClassLoader";
    private static final String DEFAULT_AGENT_CLASSLOADER_INSTANCE = "DEFAULT_LOADER";
    private static final String LOG_MANAGER_CLASS = "org.apache.skywalking.apm.agent.core.plugin.bootstrap.BootstrapPluginLogBridge";
    private static final String LOG_MANAGER_GET_LOGGER_METHOD = "getLogger";
    private static final PrintStream OUT = System.out;

    /**
     *
     * @return 返回 AgentClassLoader 实例对象(单例对象)
     */
    public static ClassLoader getAgentClassLoader() {
        try {
            ClassLoader loader = Thread.currentThread().getContextClassLoader();
            if (loader == null) {
                return null;
            }
            // 用当前线程 加载 AgentClassLoader 类加载器
            Class<?> agentClassLoaderClass = Class.forName(AGENT_CLASSLOADER_DEFAULT, true, loader);
            // 通过反射 获取 AgentClassLoader 实例的 DEFAULT_LOADER 字段
            // 其中 DEFAULT_LOADER 为 AgentClassLoader 的单例实例对象
            Field defaultLoaderField = agentClassLoaderClass.getDeclaredField(DEFAULT_AGENT_CLASSLOADER_INSTANCE);
            defaultLoaderField.setAccessible(true);
            ClassLoader defaultAgentClassLoader = (ClassLoader) defaultLoaderField.get(null);

            return defaultAgentClassLoader;
        } catch (Exception e) {
            e.printStackTrace(OUT);
            return null;
        }
    }

    public static IBootstrapLog getLogger(ClassLoader defaultAgentClassLoader, String interceptor) {
        try {
            Class<?> logManagerClass = Class.forName(LOG_MANAGER_CLASS, true, defaultAgentClassLoader);
            Method getLogger = logManagerClass.getMethod(LOG_MANAGER_GET_LOGGER_METHOD, String.class);
            return (IBootstrapLog) getLogger.invoke(null, interceptor + "_internal");
        } catch (Exception e) {
            e.printStackTrace(OUT);
            return null;
        }
    }

    public static <T> T createInterceptor(ClassLoader defaultAgentClassLoader, String className, IBootstrapLog log) {
        try {
            Class<?> interceptor = Class.forName(className, true, defaultAgentClassLoader);
            return (T) interceptor.newInstance();
        } catch (Exception e) {
            log.error(e, "Interceptor[{}] not found", className);
        }
        return null;
    }
}
