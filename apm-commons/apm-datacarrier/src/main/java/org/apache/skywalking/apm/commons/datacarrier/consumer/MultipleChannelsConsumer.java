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

package org.apache.skywalking.apm.commons.datacarrier.consumer;

import java.util.ArrayList;
import java.util.List;

import org.apache.skywalking.apm.commons.datacarrier.buffer.Channels;
import org.apache.skywalking.apm.commons.datacarrier.buffer.QueueBuffer;

/**
 * MultipleChannelsConsumer represent a single consumer thread, but support multiple channels with their {@link
 * IConsumer}s
 * <p>
 * MultipleChannelsConsumer 代表单个消费者线程，但支持多个通道
 */
public class MultipleChannelsConsumer extends Thread {
    private volatile boolean running;
    // 一起启动多个ConsumerThread
    private volatile ArrayList<Group> consumeTargets;
    @SuppressWarnings("NonAtomicVolatileUpdate")
    private volatile long size;
    private final long consumeCycle;

    public MultipleChannelsConsumer(String threadName, long consumeCycle) {
        super(threadName);
        this.consumeTargets = new ArrayList<Group>();
        this.consumeCycle = consumeCycle;
    }

    @Override
    public void run() {
        running = true;

        final List consumeList = new ArrayList(2000);
        while (running) {
            boolean hasData = false;
            // 批量消费
            for (Group target : consumeTargets) {
                boolean consume = consume(target, consumeList);
                hasData = hasData || consume;
            }

            if (!hasData) {
                try {
                    Thread.sleep(consumeCycle);
                } catch (InterruptedException e) {
                }
            }
        }

        // consumer thread is going to stop
        // consume the last time
        // 消费者线程将停止上次消费
        for (Group target : consumeTargets) {
            consume(target, consumeList);

            target.consumer.onExit();
        }
    }

    private boolean consume(Group target, List consumeList) {
        for (int i = 0; i < target.channels.getChannelSize(); i++) {
            QueueBuffer buffer = target.channels.getBuffer(i);
            buffer.obtain(consumeList);
        }

        if (!consumeList.isEmpty()) {
            try {
                target.consumer.consume(consumeList);
            } catch (Throwable t) {
                target.consumer.onError(consumeList, t);
            } finally {
                consumeList.clear();
            }
            return true;
        }
        target.consumer.nothingToConsume();
        return false;
    }

    /**
     * Add a new target channels.
     */
    public void addNewTarget(Channels channels, IConsumer consumer) {
        Group group = new Group(channels, consumer);
        // Recreate the new list to avoid change list while the list is used in consuming.
        // 重新创建新列表以避免在使用列表时更改列表。
        ArrayList<Group> newList = new ArrayList<Group>();
        for (Group target : consumeTargets) {
            newList.add(target);
        }
        newList.add(group);
        consumeTargets = newList;
        size += channels.size();
    }

    public long size() {
        return size;
    }

    void shutdown() {
        running = false;
    }

    private static class Group {
        // 多个Buffer
        private Channels channels;
        // Consumer
        private IConsumer consumer;

        public Group(Channels channels, IConsumer consumer) {
            this.channels = channels;
            this.consumer = consumer;
        }
    }
}
