package com.example.eureka.starter.sentence.repository;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("eureka-starter-adjective")
public interface AdjectiveRepository {
    @RequestMapping("/")
    String get();
}
