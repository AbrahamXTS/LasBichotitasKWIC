package com.bichotitas.infrastructure;

import com.bichotitas.application.KWICAlgorithm;
import com.bichotitas.application.SimpleKWICAlgorithmImpl;
import com.bichotitas.domain.commons.FileReader;
import com.bichotitas.domain.repositories.PhrasesRepository;
import com.bichotitas.infrastructure.UI.cli;
import com.bichotitas.infrastructure.repositories.InMemoryPhrasesRepository;

import java.util.List;


public class Main {
    public static void main(String[] args) {
        FileReader fileReader = new FileReader("src/main/resources/stop-words.txt");
        List<String> stopWords = fileReader.getFileContent();

        PhrasesRepository phrasesRepository = new InMemoryPhrasesRepository();
        KWICAlgorithm kwicAlgorithm = new SimpleKWICAlgorithmImpl(stopWords, phrasesRepository);

        cli cli = new cli(kwicAlgorithm);

        cli.showUI();
        
    }
}