package com.study.springcloud;

import com.google.common.collect.Lists;
import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.*;
import com.netflix.niws.loadbalancer.DiscoveryEnabledNIWSServerList;
import com.study.springcloud.ribbonClientCustom.RibbonClientDefaultConfigurationTestsConfig;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.cloud.netflix.ribbon.StaticServerList;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Configuration
//如果在springboot包扫描的路径下会导致启动失败，找不到IClientConfig
public class RibbonClientsConfigSelf {

    @Bean
    public DynamicServerListLoadBalancer dynamicServerListLoadBalancer(IClientConfig config,IPing ping, IRule rule,ServerList<Server> ribbonServerList,  ServerListSubsetFilter srverListSubsetFilter) {
        DynamicServerListLoadBalancer rr = new DynamicServerListLoadBalancer(config,rule,ping,ribbonServerList,srverListSubsetFilter);
        return rr;
    }

    @Bean
    public IRule ribbonRule() {
        RandomRule rr = new RandomRule();
        return rr;
    }

    @Bean
    public IPing ribbonPing() {
        return new PingUrl(false,"/hi/meng");
    }
//    @Value("${stores.ribbon.listOfServers}")//在配置文件中获取
    String listOfServers = "http://localhost:8762,http://localhost:8763";

   /* @Bean//本例用户静态服务器列表
    public ServerList<Server> ribbonServerList() {
        List<Server> list = Lists.newArrayList();
        if (Strings.isNotEmpty(listOfServers)) {
            for (String s: listOfServers.split(",")) {
                list.add(new Server(s.trim()));
            }
        }
        return new StaticServerList<Server>(list.get(0),list.get(1));
    }*/

/*    @Bean//本例用户静态服务器列表并且采用的系统默认的配置类ConfigurationBasedServerList或者他的子类
    public ServerList<Server> ribbonServerList(IClientConfig config) {
        BazServiceList bl = new BazServiceList(config);
        return bl;
    }*/
/*    @Bean
    public ServerListUpdater ribbonServerListUpdater(IClientConfig config) {
        return new PollingServerListUpdater(config);
    }*/
    @Bean//从远程服务器获取服务器列表，默认是采用DiscoveryEnabledNIWSServerList类
    public DiscoveryEnabledNIWSServerList discoveryEnabledNIWSServerList(IClientConfig config) {
        DiyDiscoveryEnaledServerList bl = new DiyDiscoveryEnaledServerList();
        return bl;
    }
    @Bean
    public ServerListSubsetFilter serverListFilter() {
        ServerListSubsetFilter filter = new ServerListSubsetFilter();
        return filter;
    }
}
