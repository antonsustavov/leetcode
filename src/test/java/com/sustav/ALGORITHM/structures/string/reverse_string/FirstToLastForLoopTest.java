package com.sustav.ALGORITHM.structures.string.reverse_string;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class FirstToLastForLoopTest {
    private FirstToLastForLoop firstToLastForLoop;

    @BeforeEach
    void setUp() {
        firstToLastForLoop = new FirstToLastForLoop();
    }

    @Test
    void reverseStr() {
        String given = "geeksforgeeks";
        char[] givenChars = given.toCharArray();

        String expected = "skeegrofskeeg";
        char[] expectedChars = expected.toCharArray();

        char[] actual = firstToLastForLoop.reverseStr(given);

        assertThat(actual).isEqualTo(expectedChars);
    }
}