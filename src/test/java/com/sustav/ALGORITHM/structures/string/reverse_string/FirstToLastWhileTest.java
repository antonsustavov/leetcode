package com.sustav.ALGORITHM.structures.string.reverse_string;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class FirstToLastWhileTest {
    private FirstToLastWhile firstToLastWhile;

    @BeforeEach
    void setUp() {
        firstToLastWhile = new FirstToLastWhile();
    }

    @Test
    void reverseStr() {
        String given = "geeksforgeeks";
        char[] givenChars = given.toCharArray();

        String expected = "skeegrofskeeg";
        char[] expectedChars = expected.toCharArray();

        char[] actual = firstToLastWhile.reverseStr(given);

        assertThat(actual).isEqualTo(expectedChars);
    }
}