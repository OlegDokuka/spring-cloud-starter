package com.example.eureka.starter.sentence.service.impl;

import com.example.eureka.starter.sentence.repository.NounRepository;
import com.example.eureka.starter.sentence.service.FallbackService;
import com.example.eureka.starter.sentence.service.WordService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rx.Observable;

@Service
public class NounService implements FallbackService, WordService {
    @Autowired
    private NounRepository nounRepository;

    @HystrixCommand(fallbackMethod = "fallback")
    public Observable<String> get() {
        return Observable.fromCallable(() -> nounRepository.get());
    }

    public String fallback() {
        return "shit";
    }
}
