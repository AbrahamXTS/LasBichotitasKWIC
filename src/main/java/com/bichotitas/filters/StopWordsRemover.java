package com.bichotitas.filters;

import com.bichotitas.domain.Pipeline;

import java.util.List;

public class StopWordsRemover extends Filter {

    private final List<String> stopWords;

    public StopWordsRemover(List<String> stopWords, Pipeline nextPipeline) {
        super(nextPipeline);
        this.stopWords = stopWords;
    }

    @Override
    protected Object execute(Object input) {
        List<String> inputCasted = (List<String>) input;

        return inputCasted.stream()
                .filter(word -> !stopWords.contains(word))
                .toList();
    }
}
