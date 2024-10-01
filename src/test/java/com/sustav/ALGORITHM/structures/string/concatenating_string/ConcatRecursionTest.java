package com.sustav.ALGORITHM.structures.string.concatenating_string;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ConcatRecursionTest {
    private ConcatRecursion concatRecursion;

    @BeforeEach
    void setUp() {
        concatRecursion = new ConcatRecursion();
    }

    @Test
    void concatTwoString() {
        String input = "Geeks";
        char[] chars = input.toCharArray();
        String input2 = "World";
        char[] chars2 = input2.toCharArray();
        char[] expected = new char[]{'G', 'e', 'e', 'k', 's', 'W', 'o', 'r', 'l', 'd'};

        char[] actual = concatRecursion.concatTwoString(chars, chars2);

        assertThat(actual).isEqualTo(expected);
    }
}