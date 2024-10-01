package com.sustav.ALGORITHM.challenges.algoexpert.medium.bst_recobstruct;

import java.util.List;

public class ReconstructBSTWorking {
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
        BST root = new BST(preOrderTraversalValues.get(0));
        for (int i = 1; i < preOrderTraversalValues.size(); i++) {
            insertNode(preOrderTraversalValues.get(i), root);
        }

        return root;
    }

    private void insertNode(Integer value, BST root) {
        if (value >= root.value) {
            if (root.right == null) {
                root.right = new BST(value);
            } else {
                insertNode(value, root.right);
            }
        } else {
            if (root.left == null) {
                root.left = new BST(value);
            } else {
                insertNode(value, root.left);
            }
        }

    }
}
