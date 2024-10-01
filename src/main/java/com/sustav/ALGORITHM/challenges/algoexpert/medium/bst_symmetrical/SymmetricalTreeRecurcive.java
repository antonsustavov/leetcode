package com.sustav.ALGORITHM.challenges.algoexpert.medium.bst_symmetrical;

public class SymmetricalTreeRecurcive {
    // This is an input class. Do not edit.
    static class BinaryTree {
        public int value;
        public BinaryTree left = null;
        public BinaryTree right = null;

        public BinaryTree(int value) {
            this.value = value;
        }
    }

    // O(n) - time, O(h) - space
    public boolean symmetricalTree(BinaryTree tree) {
        return symmetricalTreeHelper(tree.left, tree.right);
    }

    private boolean symmetricalTreeHelper(BinaryTree left, BinaryTree right) {
        if (left != null && right != null && left.value == right.value) {
            return symmetricalTreeHelper(left.left, right.right) && symmetricalTreeHelper(left.right, right.left);
        }

        return left == right;
    }
}
