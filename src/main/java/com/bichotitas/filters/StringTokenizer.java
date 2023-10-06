package com.bichotitas.filters;

import com.bichotitas.domain.Pipeline;

import java.util.List;

public class StringTokenizer extends Filter {
    public StringTokenizer(Pipeline pipeline) {
        super(pipeline);
    }

    @Override
    protected Object execute(Object input) {
        String inputCasted = (String) input;

        return List.of(inputCasted.split(" "));
    }
}
