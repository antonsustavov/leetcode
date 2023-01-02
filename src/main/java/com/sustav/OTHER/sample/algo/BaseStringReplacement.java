package com.sustav.OTHER.sample.algo;

import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class BaseStringReplacement {
    protected final List<Rule> rules;

    public BaseStringReplacement() {
        this(List.of(new ABRule(), new CDRule()));
    }
}
