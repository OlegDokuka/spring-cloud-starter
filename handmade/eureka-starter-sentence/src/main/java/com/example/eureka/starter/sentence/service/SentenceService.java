package com.example.eureka.starter.sentence.service;

import com.example.eureka.starter.sentence.service.impl.*;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rx.Observable;

@Service
public class SentenceService {
    @Autowired
    private AdjectiveService adjectiveService;
    @Autowired
    private ArticleService articleService;
    @Autowired
    private NounService nounService;
    @Autowired
    private SubjectService subjectService;
    @Autowired
    private VerbService verbService;

    @HystrixCommand(fallbackMethod = "getTheShit")
    public Observable<String> get() {
        return subjectService.get()
                .concatWith(verbService.get())
                .concatWith(articleService.get())
                .concatWith(adjectiveService.get())
                .concatWith(nounService.get())
                .map(w -> w + " ");
    }

    public String getTheShit() {
        return "The shit has happened";
    }
}
