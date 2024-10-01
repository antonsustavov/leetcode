package com.sustav.ALGORITHM.challenges.algoexpert.medium.bst_recobstruct;

import java.util.List;

public class ReconstructBST {
    static class BST {
        public int value;
        public BST left = null;
        public BST right = null;

        public BST(int value) {
            this.value = value;
        }

        public BST(int value, BST left, BST right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }

    // O(n^2) - time, O(h) - space
    public BST reconstructBst(List<Integer> preOrderTraversalValues) {
        if (preOrderTraversalValues.size() == 0) {
            return null;
        }

        var current = preOrderTraversalValues.get(0);
        var rightSubTreeIdx = preOrderTraversalValues.size();

        for (int i = 0; i < preOrderTraversalValues.size(); i++) {
            if (preOrderTraversalValues.get(i) > current) {
                rightSubTreeIdx = i;
                break;
            }
        }

        var leftSubTree = reconstructBst(preOrderTraversalValues.subList(1, rightSubTreeIdx));
        var rightSubTree = reconstructBst(preOrderTraversalValues.subList(rightSubTreeIdx, preOrderTraversalValues.size()));

        return new BST(current, leftSubTree, rightSubTree);
    }

}
