package com.bichotitas.filters;

import com.bichotitas.domain.Pipeline;

public abstract class Filter {
    private final Pipeline nextPipeline;

    protected Filter(Pipeline nextPipeline) {
        this.nextPipeline = nextPipeline;
    }

    protected abstract Object execute(Object input);

    public void filter(Object input) {
        Object output = execute(input);

        if (nextPipeline != null) {
            nextPipeline.sendToNextFilter(output);
        }
    }
}
