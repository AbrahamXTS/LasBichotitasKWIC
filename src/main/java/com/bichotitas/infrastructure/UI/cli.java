package com.bichotitas.infrastructure.UI;

import java.util.List;
import java.util.Scanner;
import com.bichotitas.application.KWICAlgorithm;


public class cli {

    private KWICAlgorithm kwicAlgorithm;

    public cli(KWICAlgorithm kwicAlgorithm) {
        this.kwicAlgorithm = kwicAlgorithm;
    }

    public void showUI() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Introduce una línea de texto:");
            String phrase = scanner.nextLine();
            List<String> result = kwicAlgorithm.execute(phrase);
            result.forEach(System.out::println);
        }

    }
}
