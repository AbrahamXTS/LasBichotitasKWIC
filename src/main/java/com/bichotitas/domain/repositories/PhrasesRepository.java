package com.bichotitas.domain.repositories;

import java.util.List;

public interface PhrasesRepository {
    public List<String> findAll();

    public void save(String phrase);
}
