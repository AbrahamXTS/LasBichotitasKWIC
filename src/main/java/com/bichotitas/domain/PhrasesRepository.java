package com.bichotitas.domain;

import java.util.ArrayList;
import java.util.List;

public class PhrasesRepository {
    private final List<String> phrases = new ArrayList<>();

    public List<String> findAll() {
        return this.phrases;
    }

    public void save(String phrase) {
        this.phrases.add(phrase);
    }
}
