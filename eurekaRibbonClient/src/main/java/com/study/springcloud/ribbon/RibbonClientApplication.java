package com.study.springcloud.ribbon;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.boot.SpringApplication.run;

@EnableEurekaClient
@SpringBootApplication
@RestController
public class RibbonClientApplication {
	@Value("${server.port}")
	private String port;
	@Value("${spring.application.name}")
	private String applicationName;
	@RequestMapping("/hi/{name}")
	public String getHiName(@PathVariable("name")String name){

		return "applicationName:"+applicationName+",port:"+port;
	}
	public static void main(String[] args) {

		run(RibbonClientApplication.class, args);
	}

}
