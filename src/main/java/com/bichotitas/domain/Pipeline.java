package com.bichotitas.domain;

import com.bichotitas.filters.Filter;

public class Pipeline {
    private final Filter nextFilter;

    public Pipeline(Filter nextFilter) {
        this.nextFilter = nextFilter;
    }

    public void sendToNextFilter(Object input) {
        nextFilter.filter(input);
    }
}
