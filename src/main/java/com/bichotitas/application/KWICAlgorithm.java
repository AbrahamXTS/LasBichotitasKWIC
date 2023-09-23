package com.bichotitas.application;

import java.util.List;

public class KWICAlgorithm {

    private List<String> stopWords;

    public KWICAlgorithm(List<String> stopWords){
        this.stopWords = stopWords;
    }

    public String toLowerCase(String sentence){

        return sentence.toLowerCase();
    }

    public List<String> deleteStopWords(List<String> words){

        return words.stream()
                .filter(word -> !stopWords.contains(word))
                .toList();
        
    }
}
