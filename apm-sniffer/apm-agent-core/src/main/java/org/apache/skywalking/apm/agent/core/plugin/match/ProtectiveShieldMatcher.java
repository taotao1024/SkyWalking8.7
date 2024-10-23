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

package org.apache.skywalking.apm.agent.core.plugin.match;

import net.bytebuddy.matcher.ElementMatcher;
import org.apache.skywalking.apm.agent.core.logging.api.ILog;
import org.apache.skywalking.apm.agent.core.logging.api.LogManager;

/**
 * In some cases, some frameworks and libraries use some binary codes tech too. From the community feedback, some of
 * them have compatible issues with byte-buddy core, which trigger "Can't resolve type description" exception.
 * <p>
 * 在某些情况下，一些框架和库也使用一些二进制代码技术。从社区反馈来看，其中一些存在与 byte-buddy core 的兼容问题，
 * 从而触发 Can't resolve type description（无法解析类型描述）异常。
 * <p>
 * So I build this protective shield by a nested matcher. When the origin matcher(s) can't resolve the type, the
 * SkyWalking agent ignores this types.
 * 因此，我通过嵌套匹配器构建了这个保护盾。当源匹配器无法解析类型时，SkyWalking 代理将忽略此类型。
 * <p>
 * Notice: this ignore mechanism may miss some instrumentations, but at most cases, it's same. If missing happens,
 * please pay attention to the WARNING logs.
 * 注意：此 ignore 机制可能会遗漏一些 instrumentation，但在大多数情况下，它是相同的。如果发生 MISSING 事件，请注意 WARNING 日志。
 */
public class ProtectiveShieldMatcher<T> extends ElementMatcher.Junction.AbstractBase<T> {
    private static final ILog LOGGER = LogManager.getLogger(ProtectiveShieldMatcher.class);

    private final ElementMatcher<? super T> matcher;

    public ProtectiveShieldMatcher(ElementMatcher<? super T> matcher) {
        this.matcher = matcher;
    }

    @Override
    public boolean matches(T target) {
        try {
            return this.matcher.matches(target);
        } catch (Throwable t) {
            if (LOGGER.isDebugEnable()) {
                LOGGER.debug(t, "Byte-buddy occurs exception when match type.");
            }
            return false;
        }
    }
}
