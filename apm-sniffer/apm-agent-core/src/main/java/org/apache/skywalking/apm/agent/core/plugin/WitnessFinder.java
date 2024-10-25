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

import net.bytebuddy.pool.TypePool;

import java.util.HashMap;
import java.util.Map;

/**
 * The <code>WitnessFinder</code> represents a pool of {@link TypePool}s, each {@link TypePool} matches a {@link
 * ClassLoader}, which helps to find the class declaration existed or not.
 */
public enum WitnessFinder {
    INSTANCE;
    /**
     * TypePool 类型池
     * key:ClassLoader value:这个ClassLoader的类型池,也就是这个ClassLoader所有能加载的类
     */
    private final Map<ClassLoader, TypePool> poolMap = new HashMap<ClassLoader, TypePool>();

    /**
     * witnessClass校验时，会基于传入的classLoader构造TypePool来判断witnessClass是否存在，
     * TypePool最终会存储到Map中
     * <p>
     * witnessMethod校验时，先判断该方法所在的类是否在这个ClassLoader中（走witnessClass校验
     * 的流程），再判断该方法是否存在
     *
     * @param classLoader for finding the witnessClass
     * @return true, if the given witnessClass exists, through the given classLoader.
     */
    public boolean exist(String witnessClass, ClassLoader classLoader) {
        return getResolution(witnessClass, classLoader)
                .isResolved();
    }

    /**
     * get TypePool.Resolution of the witness class
     * @param witnessClass class name
     * @param classLoader classLoader for finding the witnessClass
     * @return TypePool.Resolution
     */
    private TypePool.Resolution getResolution(String witnessClass, ClassLoader classLoader) {
        ClassLoader mappingKey = classLoader == null ? NullClassLoader.INSTANCE : classLoader;
        if (!poolMap.containsKey(mappingKey)) {
            synchronized (poolMap) {
                if (!poolMap.containsKey(mappingKey)) {
                    // 把所有的类加载进来
                    // classLoader == null,基于BootStrapClassLoader构造TypePool
                    // 否则基于自身的classLoader构造TypePool
                    TypePool classTypePool = classLoader == null ? TypePool.Default.ofBootLoader() : TypePool.Default.of(classLoader);
                    poolMap.put(mappingKey, classTypePool);
                }
            }
        }
        TypePool typePool = poolMap.get(mappingKey);
        // 查到当前类是否在池子中 相当于 find()
        return typePool.describe(witnessClass);
    }

    /**
     * @param classLoader for finding the witness method
     * @return true, if the given witness method exists, through the given classLoader.
     */
    public boolean exist(WitnessMethod witnessMethod, ClassLoader classLoader) {
        // 方法所在的类是否在这个ClassLoader中
        TypePool.Resolution resolution = getResolution(witnessMethod.getDeclaringClassName(), classLoader);
        if (!resolution.isResolved()) {
            return false;
        }
        // 判断该方法是否存在
        return !resolution.resolve()
                .getDeclaredMethods()
                .filter(witnessMethod.getElementMatcher())
                .isEmpty();
    }

}

final class NullClassLoader extends ClassLoader {
    static NullClassLoader INSTANCE = new NullClassLoader();
}
