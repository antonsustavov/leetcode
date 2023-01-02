package com.sustav.fuctional_interface.split_string_count;

import com.sustav.JAVA.fuctional_interface.split_string_count.Solution;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {
    private Solution solution;

    @BeforeEach
    void setUp() {
        solution = new Solution();
    }

    @Test
    void uniqueStringCounter() {
        var str = "java scala ruby kafka kafka ruby";
        var required = Map.of("java", 1, "scala", 1, "ruby", 2, "kafka", 2);
        Map<String, Integer> actual = solution.uniqueStringCounter(str);

        assertThat(actual).isEqualTo(required);
    }

    @Test
    void uniqueStringCounter2() {
        var str = "java scala ruby kafka kafka ruby";
        var required = Map.of("java", 1L, "scala", 1L, "ruby", 2L, "kafka", 2L);
        Map<String, Long> actual = solution.uniqueStringCounter2(str);

        assertThat(actual).isEqualTo(required);
    }
}