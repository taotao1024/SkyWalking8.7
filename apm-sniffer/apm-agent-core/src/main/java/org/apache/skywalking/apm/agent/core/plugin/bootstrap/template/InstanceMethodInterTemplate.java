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

package org.apache.skywalking.apm.agent.core.plugin.bootstrap.template;

import java.lang.reflect.Method;
import java.util.concurrent.Callable;

import net.bytebuddy.implementation.bind.annotation.AllArguments;
import net.bytebuddy.implementation.bind.annotation.Origin;
import net.bytebuddy.implementation.bind.annotation.RuntimeType;
import net.bytebuddy.implementation.bind.annotation.SuperCall;
import net.bytebuddy.implementation.bind.annotation.This;
import org.apache.skywalking.apm.agent.core.plugin.bootstrap.IBootstrapLog;
import org.apache.skywalking.apm.agent.core.plugin.interceptor.enhance.BootstrapInterRuntimeAssist;
import org.apache.skywalking.apm.agent.core.plugin.interceptor.enhance.EnhancedInstance;
import org.apache.skywalking.apm.agent.core.plugin.interceptor.enhance.InstanceMethodsAroundInterceptor;
import org.apache.skywalking.apm.agent.core.plugin.interceptor.enhance.MethodInterceptResult;

/**
 * --------CLASS TEMPLATE---------
 * <p>Author, Wu Sheng </p>
 * <p>Comment, don't change this unless you are 100% sure the agent core mechanism for bootstrap class
 * instrumentation.</p>
 * 除非您 100% 确定引导类插桩的代理核心机制，否则不要更改此机制
 * <p>Date, 24th July 2019</p>
 * -------------------------------
 * <p>
 * This class wouldn't be loaded in real env. This is a class template for dynamic class generation.
 * 这个类不会在真实环境中加载。这是用于动态类生成的类模板。
 * <p>
 * InstanceMethodInterTemplate.java  可以当多 InstanceMethodInterTemplate.txt 来看
 */
public class InstanceMethodInterTemplate {
    /**
     * This field is never set in the template, but has value in the runtime.
     */
    private static String TARGET_INTERCEPTOR;

    private static InstanceMethodsAroundInterceptor INTERCEPTOR;
    private static IBootstrapLog LOGGER;

    /**
     * Intercept the target instance method.
     *
     * @param obj          target class instance.
     * @param allArguments all method arguments
     * @param method       method description.
     * @param zuper        the origin call ref.
     * @return the return value of target instance method.
     * @throws Exception only throw exception because of zuper.call() or unexpected exception in sky-walking ( This is a
     *                   bug, if anything triggers this condition ).
     */
    @RuntimeType
    public static Object intercept(@This Object obj, @AllArguments Object[] allArguments, @SuperCall Callable<?> zuper,
                                   @Origin Method method) throws Throwable {
        EnhancedInstance targetObject = (EnhancedInstance) obj;
        // 准备上下文。链接到 AppClassLoader 中的代理核心。
        prepare();

        MethodInterceptResult result = new MethodInterceptResult();
        try {
            if (INTERCEPTOR != null) {
                INTERCEPTOR.beforeMethod(targetObject, method, allArguments, method.getParameterTypes(), result);
            }
        } catch (Throwable t) {
            if (LOGGER != null) {
                LOGGER.error(t, "class[{}] before method[{}] intercept failure", obj.getClass(), method.getName());
            }
        }

        Object ret = null;
        try {
            if (!result.isContinue()) {
                ret = result._ret();
            } else {
                ret = zuper.call();
            }
        } catch (Throwable t) {
            try {
                if (INTERCEPTOR != null) {
                    INTERCEPTOR.handleMethodException(targetObject, method, allArguments, method.getParameterTypes(), t);
                }
            } catch (Throwable t2) {
                if (LOGGER != null) {
                    LOGGER.error(t2, "class[{}] handle method[{}] exception failure", obj.getClass(), method.getName());
                }
            }
            throw t;
        } finally {
            try {
                if (INTERCEPTOR != null) {
                    ret = INTERCEPTOR.afterMethod(targetObject, method, allArguments, method.getParameterTypes(), ret);
                }
            } catch (Throwable t) {
                if (LOGGER != null) {
                    LOGGER.error(t, "class[{}] after method[{}] intercept failure", obj.getClass(), method.getName());
                }
            }
        }

        return ret;
    }

    /**
     * Prepare the context. Link to the agent core in AppClassLoader.
     * 准备上下文。链接到 AppClassLoader 中的代理核心。
     * <p>
     * 1、打通 BootstrapClassLoader 和 AgentClassLoader
     * - 拿到ILog 生成日志
     * - 拿到插件自定义的拦截器实例
     * 2、代替 非JDK 核心类库插件运行逻辑中的
     * interceptor = InterceptorInstanceLoader.load(instanceMethodsAroundInterceptorClassName, classLoader); 功能
     */
    private static void prepare() {
        if (INTERCEPTOR == null) {
            // BootstrapInterRuntimeAssist 此辅助帮助所有 bootstrap 类核心拦截器。
            // 获取 AgentClassLoader 实例对象(单例对象)
            ClassLoader loader = BootstrapInterRuntimeAssist.getAgentClassLoader();

            if (loader != null) {
                // 获取 BootstrapPluginLogBridge 的 Logger 用AgentClassLoader反射获取Logger
                IBootstrapLog logger = BootstrapInterRuntimeAssist.getLogger(loader, TARGET_INTERCEPTOR);
                if (logger != null) {
                    LOGGER = logger;
                    //
                    INTERCEPTOR = BootstrapInterRuntimeAssist.createInterceptor(loader, TARGET_INTERCEPTOR, LOGGER);
                }
            } else {
                LOGGER.error("Runtime ClassLoader not found when create {}." + TARGET_INTERCEPTOR);
            }
        }
    }
}

