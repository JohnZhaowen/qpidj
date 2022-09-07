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
package org.apache.qpid.server.protocol.v0_8.transport;

import org.apache.qpid.server.protocol.ProtocolVersion;
import org.apache.qpid.server.protocol.v0_8.AMQShortString;

public interface MethodProcessor<T extends ChannelMethodProcessor>
{
    ProtocolVersion getProtocolVersion();

    T getChannelMethodProcessor(int channelId);

    void receiveConnectionClose(int replyCode, AMQShortString replyText, int classId, int methodId);

    void receiveConnectionCloseOk();

    void receiveHeartbeat();

    void receiveProtocolHeader(ProtocolInitiation protocolInitiation);

    void setCurrentMethod(int classId, int methodId);

    boolean ignoreAllButCloseOk();
}
