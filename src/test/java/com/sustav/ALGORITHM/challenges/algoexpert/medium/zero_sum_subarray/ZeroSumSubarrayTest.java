package com.sustav.ALGORITHM.challenges.algoexpert.medium.zero_sum_subarray;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ZeroSumSubarrayTest {
    private ZeroSumSubarray zeroSumSubarray;

    @BeforeEach
    void setUp() {
        zeroSumSubarray = new ZeroSumSubarray();
    }

    @Test
    void zeroSumSubarray() {
        int[] given = {-5, -5, 2, 3, -2};

        boolean actual = zeroSumSubarray.zeroSumSubarray(given);

        assertThat(actual).isTrue();
    }
}