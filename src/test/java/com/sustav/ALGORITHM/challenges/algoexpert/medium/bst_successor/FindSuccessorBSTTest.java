package com.sustav.ALGORITHM.challenges.algoexpert.medium.bst_successor;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FindSuccessorBSTTest {
    private FindSuccessorBST findSuccessorBST;

    @BeforeEach
    void setUp() {
        findSuccessorBST = new FindSuccessorBST();
    }

    @Test
    void findSuccessor() {
        List<Integer> given = List.of(1, 2, 6, 4, 2, 5);
        FindSuccessorBST.BinaryTree binaryTree = new FindSuccessorBST.BinaryTree(1);
        binaryTree.left = new FindSuccessorBST.BinaryTree(2);
        binaryTree.right = new FindSuccessorBST.BinaryTree(3);

        binaryTree.left.left = new FindSuccessorBST.BinaryTree(4);
        binaryTree.left.right = new FindSuccessorBST.BinaryTree(5);

        binaryTree.left.left.left = new FindSuccessorBST.BinaryTree(6);

        findSuccessorBST.findSuccessor(binaryTree, new FindSuccessorBST.BinaryTree(5));
    }
}