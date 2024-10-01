package com.sustav.ALGORITHM.challenges.algoexpert.medium.bst_traversal;

import java.util.List;

public class TraversalBst {
    public static List<Integer> inOrderTraverse(BST tree, List<Integer> array) {
        // Write your code here.
        return inOrderTraversalHelper(tree, array);
    }

    private static List<Integer> inOrderTraversalHelper(BST tree, List<Integer> array) {
        if (tree != null) {
            inOrderTraversalHelper(tree.left, array);
            array.add(tree.value);
            inOrderTraversalHelper(tree.right, array);
        }

        return array;
    }

    public static List<Integer> preOrderTraverse(BST tree, List<Integer> array) {
        // Write your code here.
        return preOrderTraverseHelper(tree, array);
    }

    private static List<Integer> preOrderTraverseHelper(BST tree, List<Integer> array) {
        if (tree != null) {
            array.add(tree.value);
            preOrderTraverseHelper(tree.left, array);
            preOrderTraverseHelper(tree.right, array);
        }

        return array;
    }

    public static List<Integer> postOrderTraverse(BST tree, List<Integer> array) {
        // Write your code here.
        return postOrderTraverseHelper(tree, array);
    }

    private static List<Integer> postOrderTraverseHelper(BST tree, List<Integer> array) {
        if (tree != null) {
            postOrderTraverseHelper(tree.left, array);
            postOrderTraverseHelper(tree.right, array);
            array.add(tree.value);
        }

        return array;
    }

    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
        }
    }
}
