package com.sustav.ALGORITHM.challenges.algoexpert.easy.run_length_encoding;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RunLengthEncodingTest {
    private RunLengthEncoding runLengthEncoding;

    @BeforeEach
    void setUp() {
        runLengthEncoding = new RunLengthEncoding();
    }

    @Test
    void runLengthEncoding() {
        var str = "AAAAAAAAAAAAABBCCCCDD";
        var expected = "9A4A2B4C2D";
        String actual = runLengthEncoding.runLengthEncoding(str);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void runLengthEncoding2() {
        var str = "AAAAAAAAAAAAABBCCCCDD";
        var expected = "9A4A2B4C2D";
        String actual = runLengthEncoding.runLengthEncoding2(str);

        assertThat(actual).isEqualTo(expected);
    }
}