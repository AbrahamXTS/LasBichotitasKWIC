package com.bichotitas;

import com.bichotitas.domain.PhraseVariationsGenerator;
import com.bichotitas.domain.Pipeline;
import com.bichotitas.filters.*;
import com.bichotitas.utils.FileReader;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            // Entrada del programa
            System.out.print("$> ");
            String input = scanner.nextLine();

            if (input.startsWith("kwic")) {
                String in = input.replace("kwic", "").trim();
                String[] paths = in.split(" ");

                FileReader phrasesFileReader = new FileReader(paths[0]);
                List<String> phrases = phrasesFileReader.getFileContent();

                FileReader stopWordsFileReader = new FileReader(paths[1]);
                List<String> stopWords = stopWordsFileReader.getFileContent();

                // Tuberias y filtros
                Pipeline pipeline = new Pipeline(
                        new StringLowerCaser(new Pipeline(
                                new StringTokenizer(new Pipeline(
                                        new StopWordsRemover(stopWords, new Pipeline(
                                                new PhraseVariationsGenerator(new Pipeline(
                                                        new ListSorter(new Pipeline(
                                                                new Printer(null)
                                                        ))
                                                ))
                                        ))
                                ))
                        ))
                );
                
                // Salida del programa
                for (String phrase : phrases) {
                    pipeline.sendToNextFilter(phrase);
                }
            }
        } catch (Exception e) {
            System.out.println("Oh no! An error was occurred: " + e.getLocalizedMessage());
        }
    }
}