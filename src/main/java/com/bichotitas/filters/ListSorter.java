package com.bichotitas.filters;

import com.bichotitas.domain.Pipeline;

import java.util.List;

public class ListSorter extends Filter {
    public ListSorter(Pipeline nextPipeline) {
        super(nextPipeline);
    }

    @Override
    protected Object execute(Object input) {
        List<String> inputCasted = (List<String>) input;

        return inputCasted.stream()
                .sorted()
                .toList();
    }
}