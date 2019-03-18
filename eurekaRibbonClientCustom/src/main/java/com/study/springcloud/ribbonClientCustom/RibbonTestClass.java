package com.study.springcloud.ribbonClientCustom;

import com.netflix.loadbalancer.BaseLoadBalancer;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.cloud.netflix.ribbon.RibbonLoadBalancerClient;
import org.springframework.cloud.netflix.ribbon.SpringClientFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;

@Service
public class RibbonTestClass implements RibbonTestI{
    @Autowired
    //RestTemplate的@LoadBalanced注解不能同LoadBalancerClient一起使用，否则会失效或者产生负载均衡冲突
    //当时LoadBalanced注解，RestTemplate会自动采用服务名转化ip的流程，所以会产生问题
    private LoadBalancerClient loadBalancer;

//    @Autowired
//    private SpringClientFactory factory;
    @Autowired
    private RestTemplate restTemplate;
    public String doStuff(String path) {
//        ILoadBalancer lb =  factory.getLoadBalancer("eureka-client-producer"); //指定服务名
//        List<Server> allServers = lb.getAllServers();
        //本地缓存负载列表start
//        ServiceInstance instance = loadBalancer.choose("stores");
        //本地缓存负载列表end
        //获取消费者内负载均衡的列表专用start
        ServiceInstance instance = loadBalancer.choose("eureka-client-producer");
        //获取消费者内负载均衡的列表专用end
        URI storesUri = URI.create(String.format("http://%s:%s", instance.getHost(), instance.getPort()));
        System.out.println(storesUri.toString());
        String service_id = instance.getServiceId();
        String result  = restTemplate.getForObject(storesUri.toString()+"/"+path, String.class);
//        String result  = restTemplate.getForObject("http://eureka-client-producer/"+path, String.class);

        return result;
    }

}


