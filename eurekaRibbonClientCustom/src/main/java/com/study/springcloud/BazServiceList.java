package com.study.springcloud;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.ConfigurationBasedServerList;

public class BazServiceList extends ConfigurationBasedServerList {
    public BazServiceList() {
    }
    public BazServiceList(IClientConfig config) {
        super.initWithNiwsConfig(config);
    }
}
