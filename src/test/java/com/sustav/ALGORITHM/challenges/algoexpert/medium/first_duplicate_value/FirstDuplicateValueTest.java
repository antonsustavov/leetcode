package com.sustav.ALGORITHM.challenges.algoexpert.medium.first_duplicate_value;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class FirstDuplicateValueTest {
    private FirstDuplicateValue firstDuplicateValue;

    @BeforeEach
    void setUp() {
        firstDuplicateValue = new FirstDuplicateValue();
    }

    @Test
    void firstDuplicateValue() {
        int[] given = {2, 1, 5, 2, 3, 3, 4};
        int expected = 2;

        int actual = firstDuplicateValue.firstDuplicateValue(given);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void firstDuplicateValueBitSet() {
        int[] given = {2, 1, 5, 2, 3, 3, 4};
        int expected = 2;

        int actual = firstDuplicateValue.firstDuplicateValueBitSet(given);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void firstDuplicateValueAbs() {
        int[] given = {2, 1, 5, 2, 3, 3, 4};
        int expected = 2;

        int actual = firstDuplicateValue.firstDuplicateValueAbs(given);

        assertThat(actual).isEqualTo(expected);
    }
}