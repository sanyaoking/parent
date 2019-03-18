package com.study.springcloud.euraka;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

import static org.springframework.boot.SpringApplication.run;

@EnableEurekaServer
@SpringBootApplication
public class EurakaApplication {

	public static void main(String[] args) {

		run(EurakaApplication.class, args);
	}

}
