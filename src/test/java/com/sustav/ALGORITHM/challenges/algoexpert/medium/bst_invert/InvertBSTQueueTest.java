package com.sustav.ALGORITHM.challenges.algoexpert.medium.bst_invert;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InvertBSTQueueTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void invertBinaryTree() {
        InvertBSTQueue.BinaryTree binaryTree = new InvertBSTQueue.BinaryTree(1);
        binaryTree.left = new InvertBSTQueue.BinaryTree(2);
        binaryTree.right = new InvertBSTQueue.BinaryTree(3);

        InvertBSTQueue.invertBinaryTree(binaryTree);
    }
}