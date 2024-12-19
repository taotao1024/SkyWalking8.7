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

import java.util.HashMap;
import java.util.Map;
import lombok.Setter;

/**
 * 管理所有的ModuleDefine
 * <p>
 * The <code>ModuleProvider</code> is an implementation of a {@link ModuleDefine}.
 * <p>
 * And each moduleDefine can have one or more implementation, which depends on `application.yml`
 */
public abstract class ModuleProvider implements ModuleServiceHolder {
    @Setter
    private ModuleManager manager;
    @Setter
    private ModuleDefine moduleDefine;
    private final Map<Class<? extends Service>, Service> services = new HashMap<>();

    public ModuleProvider() {
    }

    protected final ModuleManager getManager() {
        return manager;
    }

    /**
     * provider的名称与上面的模块配置中selector选择的名称对应
     *
     * @return the name of this provider.
     */
    public abstract String name();

    /**
     * 返回具体模块的类型
     * @return the moduleDefine name
     */
    public abstract Class<? extends ModuleDefine> module();

    /**
     * 方法会返回该模块的配置
     */
    public abstract ModuleConfig createConfigBeanIfAbsent();

    /**
     * In prepare stage, the moduleDefine should initialize things which are irrelative other modules.
     * <p>
     * 在 prepare 阶段，moduleDefine 应该初始化与其他模块无关的东西。
     */
    public abstract void prepare() throws ServiceNotProvidedException, ModuleStartException;

    /**
     * In start stage, the moduleDefine has been ready for interop.
     * <p>
     * 在 start 阶段，moduleDefine 已准备好进行互操作。
     */
    public abstract void start() throws ServiceNotProvidedException, ModuleStartException;

    /**
     * This callback executes after all modules start up successfully.
     * <p>
     * 此回调在所有模块成功启动后执行。
     */
    public abstract void notifyAfterCompleted() throws ServiceNotProvidedException, ModuleStartException;

    /**
     * 所需模块
     *
     * @return moduleDefine names which does this moduleDefine require?
     */
    public abstract String[] requiredModules();

    /**
     * Register an implementation for the service of this moduleDefine provider.
     * <p>
     * 为此模块的服务注册一个实现Define provide
     */
    @Override
    public final void registerServiceImplementation(Class<? extends Service> serviceType,
                                                    Service service) throws ServiceNotProvidedException {
        if (serviceType.isInstance(service)) {
            this.services.put(serviceType, service);
        } else {
            throw new ServiceNotProvidedException(serviceType + " is not implemented by " + service);
        }
    }

    /**
     * Make sure all required services have been implemented.
     * {@link org.apache.skywalking.oap.server.core.CoreModule#services()}
     * <p>
     * 确保已实施所有必需的服务。
     *
     * @param requiredServices must be implemented by the moduleDefine.
     * @throws ServiceNotProvidedException when exist unimplemented service.
     */
    void requiredCheck(Class<? extends Service>[] requiredServices) throws ServiceNotProvidedException {
        if (requiredServices == null)
            return;
        // 在ModuleProvider的prepare方法中初始化所有的service
        // 都需要跟moduleDefine中的services方法中 定义的 Class[] 中的每一个元素一一对应
        for (Class<? extends Service> service : requiredServices) {
            if (!services.containsKey(service)) {
                throw new ServiceNotProvidedException("Service:" + service.getName() + " not provided");
            }
        }

        if (requiredServices.length != services.size()) {
            throw new ServiceNotProvidedException("The " + this.name() + " provider in " + moduleDefine.name() + " moduleDefine provide more service implementations than ModuleDefine requirements.");
        }
    }

    @Override
    public @SuppressWarnings("unchecked") <T extends Service> T getService(Class<T> serviceType) throws ServiceNotProvidedException {
        Service serviceImpl = services.get(serviceType);
        if (serviceImpl != null) {
            return (T) serviceImpl;
        }

        throw new ServiceNotProvidedException("Service " + serviceType.getName() + " should not be provided, based on moduleDefine define.");
    }

    ModuleDefine getModule() {
        return moduleDefine;
    }

    String getModuleName() {
        return moduleDefine.name();
    }
}
