package com.sustav.ALGORITHM.challenges.algoexpert.medium.bst_diameter;

public class DiameterBST {
    static class BinaryTree {
        public int value;
        public BinaryTree left = null;
        public BinaryTree right = null;

        public BinaryTree(int value) {
            this.value = value;
        }
    }

    // O(n) - time, O(h) - space
    public int binaryTreeDiameter(BinaryTree tree) {
        // Write your code here.
        return getTreeInfo(tree).diameter;
    }

    public TreeInfo getTreeInfo(BinaryTree tree) {
        if (tree == null) return new TreeInfo(0, 0);

        var leftTreeInfo = getTreeInfo(tree.left);
        var rightTreeInfo = getTreeInfo(tree.right);

        var longestPathThroughRoot = leftTreeInfo.height + rightTreeInfo.height;
        var maxDiameter = Math.max(leftTreeInfo.diameter, rightTreeInfo.diameter);
        var currentDiameter = Math.max(longestPathThroughRoot, maxDiameter);
        var currentHeight = 1 + Math.max(leftTreeInfo.height, rightTreeInfo.height);

        return new TreeInfo(currentDiameter, currentHeight);
    }

    class TreeInfo {
        int diameter = 0;
        int height = 0;

        public TreeInfo(int diameter, int height) {
            this.diameter = diameter;
            this.height = height;
        }
    }
}
