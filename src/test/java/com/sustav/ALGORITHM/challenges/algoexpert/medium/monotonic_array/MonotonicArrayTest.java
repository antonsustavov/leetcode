package com.sustav.ALGORITHM.challenges.algoexpert.medium.monotonic_array;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MonotonicArrayTest {
    private MonotonicArray monotonicArray;

    @BeforeEach
    void setUp() {
        monotonicArray = new MonotonicArray();
    }

    @Test
    void isMonotonic() {
        var given = new int[]{-1, -5, -10, -1100, -1100, -1101, -1102, -9001};

        boolean actual = monotonicArray.isMonotonic(given);

        assertThat(actual).isTrue();
    }

    @Test
    void isMonotonic2() {
        var given = new int[]{1, 1, 2, 3, 4, 5, 5, 5, 6, 7, 8, 8, 9, 10, 11};

        boolean actual = monotonicArray.isMonotonic(given);

        assertThat(actual).isTrue();
    }

    @Test
    void isMonotonic3() {
        var given = new int[]{-1, -5, -10, -1100, -1100, -1101, -1102, -9001};

        boolean actual = monotonicArray.isMonotonic2(given);

        assertThat(actual).isTrue();
    }

    @Test
    void isMonotonic4() {
        var given = new int[]{1, 1, 2, 3, 4, 5, 5, 5, 6, 7, 8, 8, 9, 10, 11};

        boolean actual = monotonicArray.isMonotonic2(given);

        assertThat(actual).isTrue();
    }
}