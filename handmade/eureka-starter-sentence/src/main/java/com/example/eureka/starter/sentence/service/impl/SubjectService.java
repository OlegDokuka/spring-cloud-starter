package com.example.eureka.starter.sentence.service.impl;

import com.example.eureka.starter.sentence.repository.SubjectRepository;
import com.example.eureka.starter.sentence.service.FallbackService;
import com.example.eureka.starter.sentence.service.WordService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rx.Observable;

@Service
public class SubjectService implements FallbackService, WordService {
    @Autowired
    private SubjectRepository subjectRepository;

    @HystrixCommand(fallbackMethod = "fallback")
    public Observable<String> get() {
        return Observable.fromCallable(() -> subjectRepository.get());
    }

    public String fallback() {
        return "shit";
    }
}
