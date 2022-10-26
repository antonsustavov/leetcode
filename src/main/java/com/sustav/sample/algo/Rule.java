package com.sustav.sample.algo;

import lombok.RequiredArgsConstructor;

@FunctionalInterface
public interface Rule {
    boolean match(char first, char second);

    static class ABIndexRule extends BaseIndexRule implements Rule {
        ABIndexRule() {
            super("AB");
        }
    }

    static class CDIndexRule extends BaseIndexRule implements Rule {
        CDIndexRule() {
            super("CD");
        }
    }

    @RequiredArgsConstructor
    static abstract class BaseIndexRule {
        private final String text;

        public boolean match(char first, char second) {
            if (first == second) {
                return false;
            }
            return text.indexOf(first) >= 0 && text.indexOf(second) >= 0;
        }
    }
}
