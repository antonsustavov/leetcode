package com.sustav.ALGORITHM.challenges.algoexpert.medium.bst_diameter;

public class DiameterBSTRecursive {
    int diameter = 0;

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
        diameterHelper(tree);
        return diameter;
    }

    public int diameterHelper(BinaryTree tree) {
        var leftCount = 0;
        var rightCount = 0;
        if (tree == null) {
            return 0;
        }
        int left = diameterHelper(tree.left);
        int right = diameterHelper(tree.right);
        diameter = Math.max(diameter, left + right);

        return Math.max(left, right) + 1;
    }

}
