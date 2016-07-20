package com.example.eureka.starter.word.web.rest;

import com.example.eureka.starter.word.domain.Word;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/words")
public class WordResource {
    @Value("${words}")
    private String words;

    @RequestMapping(method = RequestMethod.GET)
    public Word getWord() {
        String[] wordArray = words.split(",");
        int i = (int) Math.round(Math.random() * (wordArray.length - 1));
        return new Word(wordArray[i]);
    }
}
