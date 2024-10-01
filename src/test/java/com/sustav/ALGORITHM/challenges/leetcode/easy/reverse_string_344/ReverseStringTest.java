package com.sustav.ALGORITHM.challenges.leetcode.easy.reverse_string_344;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReverseStringTest {
    private ReverseString reverseString;

    @BeforeEach
    void setUp() {
        reverseString = new ReverseString();
    }

    @Test
    void reverseString() {
        var givenCharArray = new char[]{'h','e','l','l','o'};
        var expected = new char[]{'o','l','l','e','h'};

        reverseString.reverseString(givenCharArray);
    }
}