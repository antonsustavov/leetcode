package com.sustav.ALGORITHM.challenges.algoexpert.medium.bst_invert;

public class InvertBST {

    public static void invertBinaryTree(BinaryTree tree) {
        if (tree == null) return;

        var temp = tree.left;
        tree.left = tree.right;
        tree.right = temp;

        invertBinaryTree(tree.left);
        invertBinaryTree(tree.right);
    }

    static class BinaryTree {
        public int value;
        public BinaryTree left;
        public BinaryTree right;

        public BinaryTree(int value) {
            this.value = value;
        }
    }
}
