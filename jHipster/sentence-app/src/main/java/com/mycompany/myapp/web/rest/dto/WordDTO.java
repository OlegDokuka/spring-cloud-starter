package com.mycompany.myapp.web.rest.dto;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class WordDTO {
    private String word;

    @JsonCreator
    public WordDTO() {

    }

    public WordDTO(String word) {
        this.word = word;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }
}
