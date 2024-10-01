package com.sustav.ALGORITHM.functions.split_string_count;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class SplitStringGroupingByWordsTest {
    private SplitStringGroupingByWords splitStringGroupingByWords;

    @BeforeEach
    void setUp() {
        splitStringGroupingByWords = new SplitStringGroupingByWords();
    }

    @Test
    void uniqueStringCounter() {
        var str = "java scala ruby kafka kafka ruby";
        var required = Map.of("java", 1, "scala", 1, "ruby", 2, "kafka", 2);
        Map<String, Integer> actual = splitStringGroupingByWords.uniqueStringCounter(str);

        assertThat(actual).isEqualTo(required);
    }

    @Test
    void uniqueStringCounter2() {
        var str = "java scala ruby kafka kafka ruby";
        var required = Map.of("java", 1L, "scala", 1L, "ruby", 2L, "kafka", 2L);
        Map<String, Long> actual = splitStringGroupingByWords.uniqueStringCounter2(str);

        assertThat(actual).isEqualTo(required);
    }
}