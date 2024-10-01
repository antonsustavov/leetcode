package com.sustav.ALGORITHM.challenges.algoexpert.medium.bst_construction;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BSTConstructionTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    public void testBst() {
        BSTConstruction.BST bst = new BSTConstruction.BST(10);
        bst.insert(7);
        bst.insert(5);
        bst.insert(6);
        bst.insert(15);
        bst.insert(3);
        bst.insert(1);

        bst.remove(5);
    }
}