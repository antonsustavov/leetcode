package com.sustav.ALGORITHM.challenges.algoexpert.easy.semordnilap;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class SemordnilapTest {
    private Semordnilap semordnilap;

    @BeforeEach
    void setUp() {
        semordnilap = new Semordnilap();
    }

    @Test
    void semordnilap() {
        String[] input = {"diaper", "abc", "test", "cba", "repaid"};
        var input2 = new String[]{"diaper", "abc", "test", "cba", "repaid"};
        var expected = List.of(List.of("diaper", "repaid"), List.of("abc", "cba"));

        ArrayList<ArrayList<String>> actual = semordnilap.semordnilap(input);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void semordnilap2() {
        String[] input = {"diaper", "abc", "test", "cba", "repaid"};
        var input2 = new String[]{"diaper", "abc", "test", "cba", "repaid"};
        var expected = new ArrayList<ArrayList<String>>() {
            {
                new ArrayList<String>() {
                    {
                        add("diaper");
                        add("repaid");
                    }
                };
                new ArrayList<String>() {
                    {
                        add("abc");
                        add("cba");
                    }
                };
            }
        };

        ArrayList<ArrayList<String>> actual = semordnilap.semordnilapRevers(input);

        assertThat(actual).isEqualTo(expected);
        assertThat(actual).hasSameElementsAs(expected);
    }
}