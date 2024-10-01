package com.sustav.ALGORITHM.challenges.algoexpert.medium.bst_validate;

public class ValidateBst {
    // O(n) - time, O(d) - depth tree
    public static boolean validateBst(BST tree) {
       return validateBstHelper(tree, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static boolean validateBstHelper(BST tree, int minValue, int maxValue) {
        if (tree == null) return true;
        if (tree.value < minValue || tree.value >= maxValue) return false;
        var isLeftValid = validateBstHelper(tree.left, minValue, tree.value);

        return isLeftValid && validateBstHelper(tree.right, tree.value, maxValue);
    }

    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
        }

        public BST getRoot() {
            return this;
        }
    }
}
