package com.example.eureka.starter.sentence;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class EurekaStarterSentenceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaStarterSentenceApplication.class, args);
	}
}
