package com.bichotitas.domain;

import com.bichotitas.filters.Filter;
import com.bichotitas.utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class PhraseVariationsGenerator extends Filter {

    private final PhrasesRepository phrasesRepository;

    public PhraseVariationsGenerator(Pipeline pipeline) {
        super(pipeline);
        this.phrasesRepository = new PhrasesRepository();
    }

    @Override
    public Object execute(Object input) {
        List<String> inputCasted = (List<String>) input;

        return generatePhraseVariations(inputCasted);
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

    private List<String> moveWordToEnd(List<String> input) {
        if (input.size() == 1) {
            return input;
        }

        List<String> newWords = new ArrayList<>(input);
        String firstWord = newWords.remove(0);
        newWords.add(firstWord);

        return newWords;
    }
}
