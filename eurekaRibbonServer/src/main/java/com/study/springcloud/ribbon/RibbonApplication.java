package com.study.springcloud.ribbon;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

import static org.springframework.boot.SpringApplication.run;

@EnableEurekaServer
@SpringBootApplication
public class RibbonApplication {

	public static void main(String[] args) {
		run(RibbonApplication.class, args);
	}

}
