package com.sustav.ALGORITHM.challenges.algoexpert.medium.longest_peak;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LongestPeakTest {
    private LongestPeak longestPeak;

    @BeforeEach
    void setUp() {
        longestPeak = new LongestPeak();
    }

    @Test
    void longestPeak() {
        int[] given = {1, 2, 3, 3, 4, 0, 10, 6, 5, -1, -3, 2, 3};
        int expected = 6;

        int actual = longestPeak.longestPeak(given);

        assertThat(expected).isEqualTo(actual);
    }
}