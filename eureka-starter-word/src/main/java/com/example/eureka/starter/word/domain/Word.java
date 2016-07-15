package com.example.eureka.starter.word.domain;


public class Word {
    private String word;

    public Word() {
    }

    public Word(String word) {
        this.word = word;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Word) {
            Word that = (Word) obj;

            return that.word.equals(this.word);
        }

        return false;
    }

    @Override
    public int hashCode() {
        return word.hashCode();
    }
}
