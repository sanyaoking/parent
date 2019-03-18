package com.study.springcloud;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.cloud.netflix.ribbon.ZonePreferenceServerListFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
//本配置累主要是为了控制Ribbon,消费者的
public class RibbonClientConfig {
    //    不能和默认的RestTemplate一起使用，否则会导致找不到
    @Bean
    public ZonePreferenceServerListFilter serverListFilter() {
        ZonePreferenceServerListFilter filter = new ZonePreferenceServerListFilter();
        filter.setZone("myTestZone");
        return filter;
    }
/*
    @Bean
    public IPing ribbonPing() {
        return new PingUrl();
    }*/
    @Bean
    public IRule ribbonRule() {
        return new RandomRule();
    }


}
