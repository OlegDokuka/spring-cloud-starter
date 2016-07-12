package com.example.eureka.starter.sentence.service.impl;

import com.example.eureka.starter.sentence.repository.VerbRepository;
import com.example.eureka.starter.sentence.service.FallbackService;
import com.example.eureka.starter.sentence.service.WordService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.ObservableExecutionMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rx.Observable;
import rx.Subscriber;

@Service
public class VerbService implements FallbackService, WordService {
    @Autowired
    private VerbRepository verbRepository;

    @HystrixCommand(fallbackMethod = "fallback2", observableExecutionMode = ObservableExecutionMode.LAZY)
    public Observable<String> get() {
        return Observable.create((Subscriber<? super String> observer) -> {
            try {
                if (!observer.isUnsubscribed()) {
                    observer.onNext(verbRepository.get());
                    observer.onCompleted();
                }
            } catch (Exception e) {
                observer.onError(e);
            }
        });
    }

    public String fallback() {
        return "shit";
    }

    public Observable<String> fallback2() {
        return Observable.just("shitO<>");
    }
}
