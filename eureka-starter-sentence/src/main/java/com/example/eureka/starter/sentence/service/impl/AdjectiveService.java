package com.example.eureka.starter.sentence.service.impl;

import com.example.eureka.starter.sentence.repository.AdjectiveRepository;
import com.example.eureka.starter.sentence.service.FallbackService;
import com.example.eureka.starter.sentence.service.WordService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import rx.Observable;

@Service
public class AdjectiveService implements FallbackService, WordService {
    @Autowired
    private AdjectiveRepository adjectiveRepository;

    @HystrixCommand(fallbackMethod = "fallback")
    public Observable<String> get() {
        return Observable.fromCallable(() -> adjectiveRepository.get());
    }

    public String fallback() {
        return "shit";
    }
}
