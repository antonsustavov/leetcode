package com.sustav.ALGORITHM.challenges.algoexpert.medium.bst_successor;

public class FindSuccessorBSTOptimal {
    static class BinaryTree {
        public int value;
        public BinaryTree left = null;
        public BinaryTree right = null;
        public BinaryTree parent = null;

        public BinaryTree(int value) {
            this.value = value;
        }
    }

    // O(h) - time, O(1) - space
    public BinaryTree findSuccessor(BinaryTree tree, BinaryTree node) {
        if (node.right != null) {
            return getLeftMostChild(node.right);
        }

        return getRightMostChild(node);
    }

    private BinaryTree getRightMostChild(BinaryTree node) {
        var currentNode = node;
        while (currentNode.parent != null && currentNode.equals(currentNode.parent.right)) {
            currentNode = currentNode.parent;
        }

        return currentNode.parent;
    }

    private BinaryTree getLeftMostChild(BinaryTree node) {
        var currentNode = node;
        while (currentNode.left != null) {
            currentNode = currentNode.left;
        }

        return currentNode;
    }


}
