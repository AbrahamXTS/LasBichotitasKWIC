package com.bichotitas.application;

import java.util.List;
import java.util.stream.Collectors;


public class KWICAlgorithm {

    private List<String> stopWords;

    public KWICAlgorithm(List<String> stopWords){
        this.stopWords = stopWords;
    }

    public List<String> deleteStopWords(List<String> words){

        List<String> filteredWords = words.stream()
                .filter(word -> !stopWords.contains(word))
                .collect(Collectors.toList());
        
        return filteredWords;
    }
}
