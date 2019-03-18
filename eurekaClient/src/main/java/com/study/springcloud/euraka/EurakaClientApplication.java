package com.study.springcloud.euraka;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

import static org.springframework.boot.SpringApplication.run;

@EnableEurekaClient
@SpringBootApplication
public class EurakaClientApplication {

	public static void main(String[] args) {
		run(EurakaClientApplication.class, args);
	}

}
