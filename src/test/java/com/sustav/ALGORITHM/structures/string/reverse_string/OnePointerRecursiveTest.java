package com.sustav.ALGORITHM.structures.string.reverse_string;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class OnePointerRecursiveTest {
    private OnePointerRecursive onePointerRecursive;

    @BeforeEach
    void setUp() {
        onePointerRecursive = new OnePointerRecursive();
    }

    @Test
    void reverseStr() {
        String given = "geeksforgeeks";
        char[] givenChars = given.toCharArray();

        String expected = "skeegrofskeeg";
        char[] expectedChars = expected.toCharArray();

        onePointerRecursive.reverseStr(givenChars);

        assertThat(givenChars).isEqualTo(expectedChars);
    }
}