/*
 * Copyright 2016-2018 shardingsphere.io.
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

package io.shardingsphere.jdbc.orchestration.internal;

import io.shardingsphere.core.rule.DataSourceParameter;
import io.shardingsphere.core.rule.ProxyAuthority;
import io.shardingsphere.core.yaml.masterslave.YamlMasterSlaveRuleConfiguration;
import io.shardingsphere.core.yaml.sharding.YamlShardingRuleConfiguration;
import io.shardingsphere.jdbc.orchestration.yaml.YamlOrchestrationConfiguration;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

/**
 * Orchestration proxy configuration.
 *
 * @author panjuan
 */
@Getter
@Setter
public class OrchestrationProxyConfiguration {
    
    private Map<String, DataSourceParameter> dataSources = new HashMap<>();
    
    private YamlMasterSlaveRuleConfiguration masterSlaveRule = new YamlMasterSlaveRuleConfiguration();
    
    private YamlShardingRuleConfiguration shardingRule = new YamlShardingRuleConfiguration();
    
    private ProxyAuthority proxyAuthority = new ProxyAuthority();
    
    private boolean withoutJdbc;
    
    private String transactionMode;
    
    private int maxWorkingThreads;
    
    private YamlOrchestrationConfiguration orchestration;
}
