package com.sustav.ALGORITHM.challenges.algoexpert.medium.bst_min_height;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class MinHeightBstTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void minHeightBst() {
        List<Integer> list = List.of(1, 2, 5, 7, 10, 13, 14, 15, 22);
        MinHeightBst.BST bst = MinHeightBst.minHeightBst(list);
    }
}