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

package org.apache.skywalking.apm.agent.core.commands.executor;

import org.apache.skywalking.apm.agent.core.boot.ServiceManager;
import org.apache.skywalking.apm.agent.core.commands.CommandExecutionException;
import org.apache.skywalking.apm.agent.core.commands.CommandExecutor;
import org.apache.skywalking.apm.agent.core.conf.dynamic.ConfigurationDiscoveryService;
import org.apache.skywalking.apm.agent.core.logging.api.ILog;
import org.apache.skywalking.apm.agent.core.logging.api.LogManager;
import org.apache.skywalking.apm.network.trace.component.command.BaseCommand;
import org.apache.skywalking.apm.network.trace.component.command.ConfigurationDiscoveryCommand;

public class ConfigurationDiscoveryCommandExecutor implements CommandExecutor {

    private static final ILog LOGGER = LogManager.getLogger(ConfigurationDiscoveryCommandExecutor.class);

    @Override
    public void execute(BaseCommand command) throws CommandExecutionException {
        try {
            ConfigurationDiscoveryCommand agentDynamicConfigurationCommand = (ConfigurationDiscoveryCommand) command;

            ServiceManager.INSTANCE.findService(ConfigurationDiscoveryService.class)
                                    // 处理配置变更的命令
                                   .handleConfigurationDiscoveryCommand(agentDynamicConfigurationCommand);
        } catch (Exception e) {
            LOGGER.error(e, "Handle ConfigurationDiscoveryCommand error, command:{}", command.toString());
        }
    }
}
