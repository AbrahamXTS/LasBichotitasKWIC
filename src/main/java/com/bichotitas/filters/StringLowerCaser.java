package com.bichotitas.filters;

import com.bichotitas.domain.Pipeline;

public class StringLowerCaser extends Filter {
    public StringLowerCaser(Pipeline nextPipeline) {
        super(nextPipeline);
    }

    @Override
    protected Object execute(Object input) {
        String inputCasted = (String) input;

        return inputCasted
                .toLowerCase()
                .trim();
    }
}
