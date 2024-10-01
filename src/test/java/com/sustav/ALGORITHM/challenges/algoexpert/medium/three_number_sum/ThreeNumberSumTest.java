package com.sustav.ALGORITHM.challenges.algoexpert.medium.three_number_sum;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ThreeNumberSumTest {
    private ThreeNumberSum threeNumberSum;
    private int[] incomingArray;

    @BeforeEach
    void setUp() {
        threeNumberSum = new ThreeNumberSum();
        incomingArray = new int[]{12, 3, 1, 2, -6, 5, -8, 6};
    }

    @Test
    void threeNumberSum() {
        List<int[]> expected = List.of(new int[]{-8, 2, 6}, new int[]{-8, 3, 5}, new int[]{-6, 1, 5});
        var target = 0;

        List<Integer[]> actual = threeNumberSum.threeNumberSum(incomingArray, target);

        assertThat(actual).isEqualTo(expected);
    }
}