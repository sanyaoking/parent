package com.study.springcloud.ribbonClientCustom;

import com.netflix.loadbalancer.*;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
@Configuration
public class DefaultRibbonConfig {
    @Bean
//    @LoadBalanced
    public RestTemplate restTemplate(){
       /* loadBalance这个注解加上之后，这个注解有3件事情要处理。

    第一件就是从负载均衡器中选一个对应的服务实例，那有的人就会问为什么从负载均衡器中挑选，原因很明显就是，所有的服务名实例都放在负载均衡器中的serverlist。

    第二件事情就是从第一件事情挑选的实例中去请求内容。

    第三件事情就是由服务名转为真正使用的ip地址*/
        return new RestTemplate();
    }

}
