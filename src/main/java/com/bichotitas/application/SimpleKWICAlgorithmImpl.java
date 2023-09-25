package com.bichotitas.application;

import com.bichotitas.domain.commons.Utils;
import com.bichotitas.domain.repositories.PhrasesRepository;

import java.util.ArrayList;
import java.util.List;

public class SimpleKWICAlgorithmImpl implements KWICAlgorithm {

    private final List<String> stopWords;
    private final PhrasesRepository phrasesRepository;

    public SimpleKWICAlgorithmImpl(List<String> stopWords, PhrasesRepository phrasesRepository) {
        this.stopWords = stopWords;
        this.phrasesRepository = phrasesRepository;
    }

    @Override
    public List<String> execute(String phrase) {
        String phraseInLowerCase = phrase
                .toLowerCase()
                .trim();

        List<String> tokens = Utils.tokenize(phraseInLowerCase);

        List<String> tokensWithoutStopWords = deleteStopWords(tokens);

        return generatePhraseVariations(tokensWithoutStopWords)
                .stream()
                .sorted()
                .toList();
    }

    public List<String> deleteStopWords(List<String> words) {
        return words.stream()
                .filter(word -> !stopWords.contains(word))
                .toList();
    }

    private List<String> moveWordToEnd(List<String> words) {
        if (words.size() == 1) {
            return words;
        }

        List<String> newWords = new ArrayList<>(words);
        String firstWord = newWords.remove(0);
        newWords.add(firstWord);

        return newWords;
    }

    private List<String> generatePhraseVariations(List<String> inputWords) {
        String firstGeneratedPhrase = Utils.joinList(inputWords);
        phrasesRepository.save(firstGeneratedPhrase);

        List<String> temporalMovedTokens = new ArrayList<>(inputWords);

        while (true) {
            List<String> movedTokens = this.moveWordToEnd(temporalMovedTokens);
            String generatedPhrase = Utils.joinList(movedTokens);

            if (firstGeneratedPhrase.equals(generatedPhrase)) {
                break;
            }

            phrasesRepository.save(generatedPhrase);
            temporalMovedTokens = movedTokens;
        }

        return phrasesRepository.findAll();
    }
}
