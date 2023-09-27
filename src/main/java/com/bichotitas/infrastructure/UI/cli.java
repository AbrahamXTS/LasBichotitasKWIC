package com.bichotitas.infrastructure.UI;

import java.util.List;
import java.util.Scanner;
import com.bichotitas.application.KWICAlgorithm;

public class CLI {

    private KWICAlgorithm kwicAlgorithm;

    public CLI(KWICAlgorithm kwicAlgorithm) {
        this.kwicAlgorithm = kwicAlgorithm;
    }

    public void showUI() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Introduce una línea de texto:");
            String phraseComando = scanner.nextLine();

            if (phraseComando.startsWith("kwic")) {
                
                String wordToRemove = "kwic";
                String phrase = phraseComando.replace(wordToRemove, "");

                List<String> result = kwicAlgorithm.execute(phrase);
                result.forEach(System.out::println);

            } else {
                System.out.println("No inicia con el comando Kwic");
            }
        } catch (Exception e) {
            System.out.println("Por favor, ingrese un dato valido");
        }

    }
}
