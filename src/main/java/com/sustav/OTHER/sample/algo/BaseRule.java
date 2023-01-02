package com.sustav.OTHER.sample.algo;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public abstract class BaseRule {
    private final int sum;

    public boolean match(char first, char second) {
        return first + second == sum;
    }
}
