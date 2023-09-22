package com.bichotitas.infrastructure.repositories;

import com.bichotitas.domain.repositories.PhrasesRepository;

import java.util.ArrayList;
import java.util.List;

public class InMemoryPhrasesRepository implements PhrasesRepository {
    private final List<String> phrases = new ArrayList<>();

    @Override
    public List<String> findAll() {
        return this.phrases;
    }

    @Override
    public void save(String phrase) {
        this.phrases.add(phrase);
    }
}
