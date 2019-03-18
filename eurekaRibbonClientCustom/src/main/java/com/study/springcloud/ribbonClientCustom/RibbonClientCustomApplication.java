package com.study.springcloud.ribbonClientCustom;

import com.study.springcloud.RibbonClientConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.boot.SpringApplication.run;

@EnableEurekaClient
@SpringBootApplication
@RestController
//@RibbonClient(name="eureka-client-producer",configuration=RibbonClientConfig.class)
//@RibbonClient在注解类中，只能在以下几个配置中选择一个，不能同时存在于同一个类中IRule，7Ping，ServerList<Server>，ServerListSubsetFilter，
//且被RibbonClient注解引用的类必须有@Configuration注解，并且如果这类出现在springboot扫描的路径下，那么将会导致所有的消费者都会采用这个配置，
//因此这个类最好单独放在一个不被springboot扫描的路径下，以免引起bug
public class RibbonClientCustomApplication {
	@Autowired
	RibbonTestI ribbonTestI;
	@RequestMapping("/hi/{name}")
	public String getTest(@PathVariable("name")String name){
		return "你好："+ name+",您访问的地址地址信息如下"+ribbonTestI.doStuff("/hi/"+name);
	}

	public static void main(String[] args) {
		run(RibbonClientCustomApplication.class, args);
	}

}
