package com.bichotitas.domain.commons;

import java.util.List;

public class Utils {

    private Utils() {
    }

    public static List<String> tokenize(String word) {
        return List.of(word.split(" "));
    }

    public static String joinList(List<String> list) {
        StringBuilder result = new StringBuilder();

        for (String token : list) {
            result.append(token).append(" ");
        }

        return result.toString();
    }
}
