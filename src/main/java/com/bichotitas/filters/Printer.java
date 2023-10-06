package com.bichotitas.filters;

import com.bichotitas.domain.Pipeline;

import java.util.List;

public class Printer extends Filter {
    public Printer(Pipeline pipeline) {
        super(pipeline);
    }

    @Override
    protected Object execute(Object input) {
        for (String element : (List<String>) input) {
            System.out.println(element);
        }

        return null;
    }
}