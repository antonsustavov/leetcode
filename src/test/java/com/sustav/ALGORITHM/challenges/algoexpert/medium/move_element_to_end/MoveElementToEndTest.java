package com.sustav.ALGORITHM.challenges.algoexpert.medium.move_element_to_end;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class MoveElementToEndTest {
    private MoveElementToEnd moveElementToEnd;

    @BeforeEach
    void setUp() {
        moveElementToEnd = new MoveElementToEnd();
    }

    @Test
    void moveElementToEnd() {
        List<Integer> incoming = new ArrayList<>(Arrays.asList(2, 1, 2, 2, 2, 3, 4, 2));
        List<Integer> expected = new ArrayList<>(Arrays.asList(1, 3, 4, 2, 2, 2, 2, 2));

        List<Integer> actual = moveElementToEnd.moveElementToEndCopyOnWriteArrayList(incoming, 2);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void moveElementToEnd2() {
        List<Integer> incoming = new ArrayList<>(Arrays.asList(2, 1, 2, 2, 2, 3, 4, 2));
        List<Integer> expected = new ArrayList<>(Arrays.asList(1, 3, 4, 2, 2, 2, 2, 2));

        List<Integer> actual = moveElementToEnd.moveElementToEndCopyOnWriteArrayList2(incoming, 2);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void moveElementToEndSwap() {
        List<Integer> incoming = new ArrayList<>(Arrays.asList(2, 1, 2, 2, 2, 3, 4, 2));
        List<Integer> expected = new ArrayList<>(Arrays.asList(4, 1, 3, 2, 2, 2, 2, 2));

        List<Integer> actual = moveElementToEnd.moveElementToEndSwap2(incoming, 2);

        assertThat(actual).isEqualTo(expected);
    }
}