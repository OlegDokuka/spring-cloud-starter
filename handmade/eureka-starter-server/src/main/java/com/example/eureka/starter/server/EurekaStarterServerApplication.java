package com.example.eureka.starter.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaStarterServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaStarterServerApplication.class, args);
    }
}
