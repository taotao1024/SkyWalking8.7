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

package org.apache.skywalking.oap.server.core.storage;

import org.apache.skywalking.oap.server.core.storage.type.StorageBuilder;
import org.apache.skywalking.oap.server.library.module.Service;

/**
 * StorageDAO is a DAO factory for storage layer. Provide the implementations of typical DAO interfaces.
 * <p>
 * StorageDAO 是存储层的 DAO 工厂。提供典型 DAO 接口的实现。
 */
public interface StorageDAO extends Service {

    IMetricsDAO newMetricsDao(StorageBuilder storageBuilder);

    IRecordDAO newRecordDao(StorageBuilder storageBuilder);

    INoneStreamDAO newNoneStreamDao(StorageBuilder storageBuilder);

    IManagementDAO newManagementDao(StorageBuilder storageBuilder);
}
