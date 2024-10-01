package com.sustav.ALGORITHM.challenges.algoexpert.easy.first_non_repeating_character;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class FirstNonRepeatingCharacterTest {
    private FirstNonRepeatingCharacter firstNonRepeatingCharacter;

    @BeforeEach
    void setUp() {
        firstNonRepeatingCharacter = new FirstNonRepeatingCharacter();
    }

    @Test
    void firstNonRepeatingCharacter() {
        var str = "abcdcaf";
        var expected = 1;

        int actual = firstNonRepeatingCharacter.firstNonRepeatingCharacter(str);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void firstNonRepeatingCharacter2() {
        var str = "faadabcbbebdf";
        var expected = 6;

        int actual = firstNonRepeatingCharacter.firstNonRepeatingCharacter(str);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void firstNonRepeatingCharacter3() {
        var str = "abcdcaf";
        var expected = 1;

        int actual = firstNonRepeatingCharacter.firstNonRepeatingCharacterBitmap(str);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void firstNonRepeatingCharacter4() {
        var str = "faadabcbbebdf";
        var expected = 6;

        int actual = firstNonRepeatingCharacter.firstNonRepeatingCharacterBitmap(str);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void firstNonRepeatingCharacter5() {
        var str = "abcdcaf";
        var expected = 1;

        int actual = firstNonRepeatingCharacter.firstNonRepeatingCharacterDuplicate(str);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void firstNonRepeatingCharacter6() {
        var str = "faadabcbbebdf";
        var expected = 6;

        int actual = firstNonRepeatingCharacter.firstNonRepeatingCharacterDuplicate(str);

        assertThat(actual).isEqualTo(expected);
    }
}