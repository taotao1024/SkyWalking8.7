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

import net.bytebuddy.description.method.MethodDescription;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.dynamic.DynamicType;
import net.bytebuddy.implementation.FieldAccessor;
import net.bytebuddy.implementation.MethodDelegation;
import net.bytebuddy.implementation.SuperMethodCall;
import net.bytebuddy.implementation.bind.annotation.Morph;
import net.bytebuddy.matcher.ElementMatcher;
import net.bytebuddy.matcher.ElementMatchers;
import org.apache.skywalking.apm.agent.core.logging.api.ILog;
import org.apache.skywalking.apm.agent.core.logging.api.LogManager;
import org.apache.skywalking.apm.agent.core.plugin.AbstractClassEnhancePluginDefine;
import org.apache.skywalking.apm.agent.core.plugin.EnhanceContext;
import org.apache.skywalking.apm.agent.core.plugin.PluginException;
import org.apache.skywalking.apm.agent.core.plugin.bootstrap.BootstrapInstrumentBoost;
import org.apache.skywalking.apm.agent.core.plugin.interceptor.ConstructorInterceptPoint;
import org.apache.skywalking.apm.agent.core.plugin.interceptor.DeclaredInstanceMethodsInterceptPoint;
import org.apache.skywalking.apm.agent.core.plugin.interceptor.EnhanceException;
import org.apache.skywalking.apm.agent.core.plugin.interceptor.InstanceMethodsInterceptPoint;
import org.apache.skywalking.apm.agent.core.plugin.interceptor.StaticMethodsInterceptPoint;
import org.apache.skywalking.apm.agent.core.plugin.interceptor.v2.InstanceMethodsInterceptV2Point;
import org.apache.skywalking.apm.agent.core.plugin.interceptor.v2.StaticMethodsInterceptV2Point;
import org.apache.skywalking.apm.util.StringUtil;

import static net.bytebuddy.jar.asm.Opcodes.ACC_PRIVATE;
import static net.bytebuddy.jar.asm.Opcodes.ACC_VOLATILE;
import static net.bytebuddy.matcher.ElementMatchers.isStatic;
import static net.bytebuddy.matcher.ElementMatchers.not;

/**
 * This class controls all enhance operations, including enhance constructors, instance methods and static methods. All
 * the enhances base on three types interceptor point: {@link ConstructorInterceptPoint}, {@link
 * InstanceMethodsInterceptPoint} and {@link StaticMethodsInterceptPoint} If plugin is going to enhance constructors,
 * instance methods, or both, {@link ClassEnhancePluginDefine} will add a field of {@link Object} type.
 */
public abstract class ClassEnhancePluginDefine extends AbstractClassEnhancePluginDefine {
    private static final ILog LOGGER = LogManager.getLogger(ClassEnhancePluginDefine.class);

    /**
     * Enhance a class to intercept constructors and class instance methods.
     * <p>
     * 如果当前拦截的类没有实现EnhancedInstance接口且没有新增新的字段或者实现新的接口，则会新增一
     * 个private volatile的Object类型字段_$EnhancedClassField_ws，并实现EnhancedInstance接口的
     * get/set作为新增字段的get/set方法，最后设置标记位，保证该操作只会发生一次
     *
     * @param typeDescription target class description
     * @param newClassBuilder byte-buddy's builder to manipulate class bytecode.
     * @return new byte-buddy's builder for further manipulation.
     */
    protected DynamicType.Builder<?> enhanceInstance(TypeDescription typeDescription,
                                                     DynamicType.Builder<?> newClassBuilder, ClassLoader classLoader,
                                                     EnhanceContext context) throws PluginException {
        // 构造器拦截点
        ConstructorInterceptPoint[] constructorInterceptPoints = getConstructorsInterceptPoints();
        // 实例方法拦截点
        InstanceMethodsInterceptPoint[] instanceMethodsInterceptPoints = getInstanceMethodsInterceptPoints();
        String enhanceOriginClassName = typeDescription.getTypeName();
        boolean existedConstructorInterceptPoint = false;
        if (constructorInterceptPoints != null && constructorInterceptPoints.length > 0) {
            existedConstructorInterceptPoint = true;
        }
        boolean existedMethodsInterceptPoints = false;
        if (instanceMethodsInterceptPoints != null && instanceMethodsInterceptPoints.length > 0) {
            existedMethodsInterceptPoints = true;
        }

        /**
         * nothing need to be enhanced in class instance, maybe need enhance static methods.
         */
        if (!existedConstructorInterceptPoint && !existedMethodsInterceptPoints) {
            return newClassBuilder;
        }

        /**
         * Manipulate class source code.<br/>
         *
         * new class need:<br/>
         * 1.Add field, name {@link #CONTEXT_ATTR_NAME}.
         * 2.Add a field accessor for this field.
         *
         * And make sure the source codes manipulation only occurs once.
         * 确保源代码操作只发生一次。
         * isAssignableTo() 这个是否是接口的实现
         *
         */
        // 如果当前拦截的类没有实现EnhancedInstance接口
        if (!typeDescription.isAssignableTo(EnhancedInstance.class)) {
            // 没有新增新的字段或者实现新的接口
            if (!context.isObjectExtended()) {
                // bytebuddy API
                // 新增一个private volatile的Object类型字段 _$EnhancedClassField_ws
                // 实现EnhancedInstance接口的get/set作为新增字段的get/set方法
                newClassBuilder = newClassBuilder.defineField(
                                CONTEXT_ATTR_NAME, Object.class, ACC_PRIVATE | ACC_VOLATILE)
                        .implement(EnhancedInstance.class) // 对象扩展
                        .intercept(FieldAccessor.ofField(CONTEXT_ATTR_NAME)); // 字段扩展
                // 将记录状态的上下文EnhanceContext设置为已新增新的字段或者实现新的接口
                context.extendObjectCompleted();
            }
        }

        /**
         * 2. enhance constructors
         * 增强构造器
         * 构造方法拦截处理
         *
         *  StaticMethodsInter可以直接通过clazz.getClassLoader()获取类加载器是因为静态方法直接绑定了类
         */
        if (existedConstructorInterceptPoint) {
            for (ConstructorInterceptPoint constructorInterceptPoint : constructorInterceptPoints) {
                if (isBootstrapInstrumentation()) {
                    newClassBuilder = newClassBuilder.constructor(constructorInterceptPoint.getConstructorMatcher())
                            .intercept(SuperMethodCall.INSTANCE.andThen(MethodDelegation.withDefaultConfiguration()
                                    .to(BootstrapInstrumentBoost
                                            .forInternalDelegateClass(constructorInterceptPoint
                                                    .getConstructorInterceptor()))));
                } else {
                    newClassBuilder = newClassBuilder.constructor(constructorInterceptPoint.getConstructorMatcher())
                            .intercept(SuperMethodCall.INSTANCE.andThen(MethodDelegation.withDefaultConfiguration()
                                    .to(new ConstructorInter(constructorInterceptPoint
                                            .getConstructorInterceptor(), classLoader))));
                }
            }
        }

        /**
         * 3. enhance instance methods
         * 增强实例方法
         * 实例方法拦截
         *
         * InstMethodsInter需要从上层传递ClassLoader有两个原因：第一个是一份字节码可能被多个
         * ClassLoader加载，这样加载出来的每个实例都不相等，所以必须要绑定好ClassLoader。第二个原因是
         * InstMethodsInter里对拦截器的加载前置到了构造方法，这是因为可能出现无法加载拦截器成功的情
         * 况，如果放到intercept()方法里去延后加载拦截器，那么拦截器加载失败产生的异常将和字节码修改导
         * 致的异常、业务异常出现混乱，这里是为了让异常边界清晰而做的处理
         *
         * JDK类库中的类的实例方法插桩且不修改原方法入参会交给通过InstanceMethodInterTemplate生成的
         * 类去处理，实际也就是模板类InstanceMethodInterTemplate的TARGET_INTERCEPTOR赋值为插件拦
         * 截器全类名，
         *
         * 和实例方法插桩的InstMethodsInter的intercept()方法相比这里多调用了一个prepare()方法
         *
         */
        if (existedMethodsInterceptPoints) {
            for (InstanceMethodsInterceptPoint instanceMethodsInterceptPoint : instanceMethodsInterceptPoints) {
                String interceptor = instanceMethodsInterceptPoint.getMethodsInterceptor();
                if (StringUtil.isEmpty(interceptor)) {
                    throw new EnhanceException("no InstanceMethodsAroundInterceptor define to enhance class " + enhanceOriginClassName);
                }
                // 连接条件 非静态方法的匹配条件 进行拼接
                ElementMatcher.Junction<MethodDescription> junction = not(isStatic()).and(instanceMethodsInterceptPoint.getMethodsMatcher());
                // 如果拦截点为DeclaredInstanceMethodsInterceptPoint
                // 会新增匹配条件：拿到的方法必须是当前类上的
                if (instanceMethodsInterceptPoint instanceof DeclaredInstanceMethodsInterceptPoint) {
                    // Spring 使用的比较多
                    // 拿到的方法必须是当前类上的 通过注解匹配可能匹配到很多方法不是当前类上的
                    junction = junction.and(ElementMatchers.<MethodDescription>isDeclaredBy(typeDescription));
                }
                if (instanceMethodsInterceptPoint.isOverrideArgs()) {
                    if (isBootstrapInstrumentation()) {
                        // JDK类库方法插桩
                        newClassBuilder = newClassBuilder.method(junction)
                                .intercept(MethodDelegation.withDefaultConfiguration()
                                        .withBinders(Morph.Binder.install(OverrideCallable.class))
                                        .to(BootstrapInstrumentBoost.forInternalDelegateClass(interceptor)));
                    } else {
                        // 实例方法插桩修改原方法入参
                        newClassBuilder = newClassBuilder.method(junction)
                                .intercept(MethodDelegation.withDefaultConfiguration()
                                        .withBinders(Morph.Binder.install(OverrideCallable.class))
                                        .to(new InstMethodsInterWithOverrideArgs(interceptor, classLoader)));
                    }
                } else {
                    if (isBootstrapInstrumentation()) {
                        // JDK类库方法插桩
                        newClassBuilder = newClassBuilder.method(junction)
                                .intercept(MethodDelegation.withDefaultConfiguration()
                                        .to(BootstrapInstrumentBoost.forInternalDelegateClass(interceptor)));
                    } else {
                        // 实例方法插桩不修改原方法入参
                        newClassBuilder = newClassBuilder.method(junction)
                                .intercept(MethodDelegation.withDefaultConfiguration()
                                        .to(new InstMethodsInter(interceptor, classLoader)));
                    }
                }
            }
        }

        return newClassBuilder;
    }

    /**
     * Enhance a class to intercept class static methods.
     * <p>
     * 增强类以拦截类静态方法。
     *
     * @param typeDescription target class description
     * @param newClassBuilder byte-buddy's builder to manipulate class bytecode.
     * @return new byte-buddy's builder for further manipulation.
     */
    protected DynamicType.Builder<?> enhanceClass(TypeDescription typeDescription, DynamicType.Builder<?> newClassBuilder,
                                                  ClassLoader classLoader) throws PluginException {
        // 获取自定义修改类(插件)重写getStaticMethodsInterceptPoints方法
        StaticMethodsInterceptPoint[] staticMethodsInterceptPoints = getStaticMethodsInterceptPoints();
        String enhanceOriginClassName = typeDescription.getTypeName();
        if (staticMethodsInterceptPoints == null || staticMethodsInterceptPoints.length == 0) {
            // 如果没有重写则直接返回
            return newClassBuilder;
        }

        for (StaticMethodsInterceptPoint staticMethodsInterceptPoint : staticMethodsInterceptPoints) {
            // 获取自定义修改的逻辑
            String interceptor = staticMethodsInterceptPoint.getMethodsInterceptor();
            if (StringUtil.isEmpty(interceptor)) {
                throw new EnhanceException("no StaticMethodsAroundInterceptor define to enhance class " + enhanceOriginClassName);
            }
            // 是否需要覆盖原方法
            if (staticMethodsInterceptPoint.isOverrideArgs()) {
                if (isBootstrapInstrumentation()) {
                    newClassBuilder = newClassBuilder.method(isStatic().and(staticMethodsInterceptPoint.getMethodsMatcher()))
                            .intercept(MethodDelegation.withDefaultConfiguration()
                                    .withBinders(Morph.Binder.install(OverrideCallable.class))
                                    .to(BootstrapInstrumentBoost.forInternalDelegateClass(interceptor)));
                } else {
                    newClassBuilder = newClassBuilder.method(isStatic().and(staticMethodsInterceptPoint.getMethodsMatcher()))
                            .intercept(MethodDelegation.withDefaultConfiguration()
                                    .withBinders(Morph.Binder.install(OverrideCallable.class))
                                    .to(new StaticMethodsInterWithOverrideArgs(interceptor)));// 修改入参
                }
            } else {
                // 默认为false 是否为根加载器加载的类
                if (isBootstrapInstrumentation()) {
                    newClassBuilder = newClassBuilder.method(isStatic().and(staticMethodsInterceptPoint.getMethodsMatcher()))
                            .intercept(MethodDelegation.withDefaultConfiguration()
                                    .to(BootstrapInstrumentBoost.forInternalDelegateClass(interceptor)));
                } else {
                    // 通过StaticMethodsInter包装后 进行真正的字节码增强
                    newClassBuilder = newClassBuilder.method(isStatic().and(staticMethodsInterceptPoint.getMethodsMatcher()))
                            .intercept(MethodDelegation.withDefaultConfiguration()
                                    .to(new StaticMethodsInter(interceptor)));// 修改返回值
                }
            }

        }

        return newClassBuilder;
    }

    /**
     * @return null, means enhance no v2 instance methods.
     */
    @Override
    public InstanceMethodsInterceptV2Point[] getInstanceMethodsInterceptV2Points() {
        return null;
    }

    /**
     * @return null, means enhance no v2 static methods.
     */
    @Override
    public StaticMethodsInterceptV2Point[] getStaticMethodsInterceptV2Points() {
        return null;
    }

}
