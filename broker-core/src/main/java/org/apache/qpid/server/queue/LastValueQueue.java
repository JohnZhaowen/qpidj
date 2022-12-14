/*
 *
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 *
 */
package org.apache.qpid.server.queue;

import org.apache.qpid.server.model.ManagedAttribute;
import org.apache.qpid.server.model.ManagedContextDefault;
import org.apache.qpid.server.model.ManagedObject;
import org.apache.qpid.server.model.Queue;

@ManagedObject(category = false, type = LastValueQueue.LAST_VALUE_QUEUE_TYPE,
        amqpName = "org.apache.qpid.LastValueQueue")
public interface LastValueQueue<X extends LastValueQueue<X>> extends Queue<X> {
    String LVQ_KEY = "lvqKey";

    @ManagedContextDefault(name = "queue.lvqKey")
    String DEFAULT_LVQ_KEY = "qpid.LVQ_key";
    String LAST_VALUE_QUEUE_TYPE = "lvq";

    @ManagedAttribute(defaultValue = "${queue.lvqKey}")
    String getLvqKey();
}
