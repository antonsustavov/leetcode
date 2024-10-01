package com.sustav.ALGORITHM.challenges.algoexpert.medium.bst_height_balanced;

public class HeightBalancedBinaryTree {
    // This is an input class. Do not edit.
    static class BinaryTree {
        public int value;
        public BinaryTree left = null;
        public BinaryTree right = null;

        public BinaryTree(int value) {
            this.value = value;
        }
    }

    // O(n) - time, O(h) - space, h - stack space
    public boolean heightBalancedBinaryTree(BinaryTree tree) {
        return heightBalancedBinaryTreeHelper(tree) >= 0;
    }

    private int heightBalancedBinaryTreeHelper(BinaryTree tree) {
        if (tree == null) return 0;

        var left = heightBalancedBinaryTreeHelper(tree.left);
        var right = heightBalancedBinaryTreeHelper(tree.right);
        if (left < 0 || right < 0 || Math.abs(left - right) > 1) return -1;

        return 1 + Math.max(left, right);
    }
}
