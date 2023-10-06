package com.bichotitas.filters;

import com.bichotitas.domain.Pipeline;

public class ListJoiner extends Filter {
    public ListJoiner(Pipeline pipeline) {
        super(pipeline);
    }

    @Override
    protected Object execute(Object input) {
        StringBuilder result = new StringBuilder();

        for (String token : (String[]) input) {
            result.append(token).append(" ");
        }

        return result.toString();
    }
}
