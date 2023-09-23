package com.bichotitas.application;

import java.util.ArrayList;
import java.util.List;

public class MoveWord {
    public List<String>moveWordToEnd(List<String> words) {
        if (words.size() == 1 || words ==null) {
            return words;
        }

        List<String> newWords = new ArrayList<>(words);
        String firtsWord = newWords.remove(0);
        newWords.add(firtsWord);

        return newWords;
    }
}
