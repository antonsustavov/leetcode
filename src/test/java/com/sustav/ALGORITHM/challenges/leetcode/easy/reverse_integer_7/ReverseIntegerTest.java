package com.sustav.ALGORITHM.challenges.leetcode.easy.reverse_integer_7;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ReverseIntegerTest {
    private ReverseInteger reverseInteger;

    @BeforeEach
    void setUp() {
        reverseInteger = new ReverseInteger();
    }

    @Test
    void reverse() {
        int given = 345678;
        int expected = 876543;

        int actual = reverseInteger.reverse2(given);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void reverse2() {
        int given = 345678;
        int expected = 876543;

        int actual = reverseInteger.reverse2(given);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void reverse3() {
        int given = 345678;
        int expected = 876543;

        int actual = reverseInteger.reverse3(given);

        assertThat(actual).isEqualTo(expected);
    }
}