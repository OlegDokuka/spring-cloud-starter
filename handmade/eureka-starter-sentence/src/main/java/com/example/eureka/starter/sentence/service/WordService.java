package com.example.eureka.starter.sentence.service;


import rx.Observable;

public interface WordService {
    Observable<String> get();
}
