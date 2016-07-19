package com.example.eureka.starter.word;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class EurekaStarterWordApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaStarterWordApplication.class, args);
	}
}
