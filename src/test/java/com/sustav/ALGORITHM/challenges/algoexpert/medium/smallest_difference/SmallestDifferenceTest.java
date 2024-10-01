package com.sustav.ALGORITHM.challenges.algoexpert.medium.smallest_difference;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class SmallestDifferenceTest {
    private SmallestDifference smallestDifference;
    private int[] incomeArrayOne, incomeArrayTwo;

    @BeforeEach
    void setUp() {
        smallestDifference = new SmallestDifference();
        incomeArrayOne = new int[]{-1, 5, 10, 20, 28, 3};
        incomeArrayTwo = new int[]{26, 134, 135, 15, 17};
    }

    @Test
    void smallestDifference() {
        int[] expected = new int[]{28, 26};
        int[] actual = smallestDifference.smallestDifference(incomeArrayOne, incomeArrayTwo);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void smallestDifference2() {
        int[] expected = new int[]{28, 26};
        int[] actual = smallestDifference.smallestDifference2(incomeArrayOne, incomeArrayTwo);

        assertThat(actual).isEqualTo(expected);
    }
}