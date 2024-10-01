package com.sustav.ALGORITHM.challenges.algoexpert.medium.bst_height_balanced;

public class HeightBalancedBinaryTreeInfo {
    // This is an input class. Do not edit.
    static class BinaryTree {
        public int value;
        public BinaryTree left = null;
        public BinaryTree right = null;

        public BinaryTree(int value) {
            this.value = value;
        }
    }

    static class TreeInfo {
        boolean isBalanced = false;
        int height = 0;

        public TreeInfo(boolean isBalanced, int height) {
            this.isBalanced = isBalanced;
            this.height = height;
        }
    }

    // O(n) - time, O(h) - space, h - stack space
    public boolean heightBalancedBinaryTree(BinaryTree tree) {
        var treeInfo = heightBalancedBinaryTreeHelper(tree);
        return treeInfo.isBalanced;
    }

    private TreeInfo heightBalancedBinaryTreeHelper(BinaryTree tree) {
        if (tree == null) return new TreeInfo(true, -1);

        var left = heightBalancedBinaryTreeHelper(tree.left);
        var right = heightBalancedBinaryTreeHelper(tree.right);

        var isBalanced = left.isBalanced && right.isBalanced && Math.abs(left.height - right.height)  <= 1;
        var height = Math.max(left.height, right.height) + 1;

        return new TreeInfo(isBalanced, height);
    }
}
