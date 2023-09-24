package com.bichotitas.application;

import java.util.ArrayList;
import java.util.List;

public class KWICAlgorithm {

    private List<String> stopWords;

    public KWICAlgorithm(List<String> stopWords){
        this.stopWords = stopWords;
    }

    public List<String> deleteStopWords(List<String> words){

        return words.stream()
                .filter(word -> !stopWords.contains(word))
                .toList();
        
    }

    private List<String>moveWordToEnd(List<String> words) {
        if (words.size() == 1 || words ==null) {
            return words;
        }

        List<String> newWords = new ArrayList<>(words);
        String firtsWord = newWords.remove(0);
        newWords.add(firtsWord);

        return newWords;
    }
}
