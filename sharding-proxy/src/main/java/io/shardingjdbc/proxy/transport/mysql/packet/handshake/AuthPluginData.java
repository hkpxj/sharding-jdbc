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

package io.shardingjdbc.proxy.transport.mysql.packet.handshake;

import com.google.common.primitives.Bytes;
import lombok.Getter;

/**
 * Auth plugin data.
 * 
 * <p>
 *     The auth-plugin-data is the concatenation of strings auth-plugin-data-part-1 and auth-plugin-data-part-2.
 *     The auth-plugin-data-part-1's length is 8; The auth-plugin-data-part-2's length is 12.
 * </p>
 *
 * @author zhangliang
 */
@Getter
public final class AuthPluginData {
    
    private final byte[] authPluginDataPart1;
    
    private final byte[] authPluginDataPart2;
    
    private final byte[] authPluginData;
    
    public AuthPluginData() {
        authPluginDataPart1 = RandomGenerator.getInstance().generateRandomBytes(8);
        authPluginDataPart2 = RandomGenerator.getInstance().generateRandomBytes(12);
        authPluginData = Bytes.concat(authPluginDataPart1, authPluginDataPart2);
    }
}
