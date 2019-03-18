package com.study.springcloud.ribbonClientCustom;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.ConfigurationBasedServerList;
import com.study.springcloud.RibbonClientsConfigSelf;
import org.springframework.cloud.netflix.ribbon.RibbonClients;

@RibbonClients(defaultConfiguration = RibbonClientsConfigSelf.class)
//通过@RibbonClients注解可以为所有的Ribbon客户端提供一个默认的配置。例如
public class RibbonClientDefaultConfigurationTestsConfig {
/*    public static class BazServiceList extends ConfigurationBasedServerList {
        public BazServiceList(IClientConfig config) {
            super.initWithNiwsConfig(config);
        }
    }*/
}
