package com.sustav.ALGORITHM.challenges.algoexpert.easy.swap_letter_string;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SwapLetterStringInPlaceTest {
    private SwapLetterStringInPlace swapLetterStringInPlace;

    @BeforeEach
    void setUp() {
        swapLetterStringInPlace = new SwapLetterStringInPlace();
    }

    @Test
    void swapString() {
        char[] income = new char[]{'a', 'b', 'c', '1', '2', '3', '4'};
        var incomeIdx = 3;

        var expected = new char[]{'1', '2', '3', '4', 'a', 'b', 'c'};

        char[] actual = swapLetterStringInPlace.swapString(income, incomeIdx);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void swapString2() {
        char[] income = new char[]{'a', 'b', '1'};
        var incomeIdx = 2;

        var expected = new char[]{'1', 'a', 'b'};

        char[] actual = swapLetterStringInPlace.swapString(income, incomeIdx);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void swapString3() {
        char[] income = new char[]{'a', 'b', '1'};
        var incomeIdx = 3;

        var expected = new char[]{'a', 'b', '1'};

        char[] actual = swapLetterStringInPlace.swapString(income, incomeIdx);

        assertThat(actual).isEqualTo(expected);
    }
}