package com.bichotitas.application;

import java.util.Arrays;
import java.util.List;

import com.bichotitas.domain.commons.FileReader;

public class KWICAlgorithm {
    
    public String[] deleteStopWords(String[] words){
        List<String> fileContent = new FileReader("stop-words.txt").getFileContent();

        return Arrays.stream(words)
                .filter(word -> !fileContent.contains(word))
                .toArray(String[]::new);
    }
}
