package com.mycompany.myapp.repository.impl;


import com.mycompany.myapp.repository.WordRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

@Component
public class RandomWordRepository implements WordRepository {
    private String[] words;

    @Value("${words}")
    private void init( String words) {
        this.words = words.split(",");
    }


    @Override
    public String get() {
        int i = (int) Math.round(Math.random() * (words.length - 1));

        return words[i];
    }
}
