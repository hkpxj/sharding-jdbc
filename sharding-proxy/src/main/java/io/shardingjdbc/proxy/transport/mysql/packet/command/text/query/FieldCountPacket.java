/*
 * Copyright 1999-2015 dangdang.com.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * </p>
 */

package io.shardingjdbc.proxy.transport.mysql.packet.command.text.query;

import io.shardingjdbc.proxy.transport.mysql.packet.MySQLPacket;
import io.shardingjdbc.proxy.transport.mysql.packet.MySQLPacketPayload;
import lombok.Getter;

/**
 * COM_QUERY response field count packet.
 * @see <a href="https://dev.mysql.com/doc/internals/en/com-query-response.html">COM_QUERY field count</a>
 *
 * @author zhangliang
 */
@Getter
public final class FieldCountPacket extends MySQLPacket {
    
    private final int columnCount;
    
    public FieldCountPacket(final int sequenceId, final int columnCount) {
        super(sequenceId);
        this.columnCount = columnCount;
    }
    
    @Override
    public void write(final MySQLPacketPayload mysqlPacketPayload) {
        mysqlPacketPayload.writeIntLenenc(columnCount);
    }
}
