package com.sustav.ALGORITHM.challenges.algoexpert.medium.reverse_word_in_string;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ReverseWordInStringTest {
    private ReverseWordInString reverseWordInString;

    @BeforeEach
    void setUp() {
        reverseWordInString = new ReverseWordInString();
    }

    @Test
    void reverseWordsInString() {
        var given = "AlgoExpert is the best!";
        var expected = "best! the is AlgoExpert";

        String actual = reverseWordInString.reverseWordsInString(given);

        assertThat(actual).isEqualTo(expected);
    }
}