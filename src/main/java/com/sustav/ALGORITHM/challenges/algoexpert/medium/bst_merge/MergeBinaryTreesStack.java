package com.sustav.ALGORITHM.challenges.algoexpert.medium.bst_merge;

import java.util.LinkedList;
import java.util.Queue;

public class MergeBinaryTreesStack {
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
    public BinaryTree mergeBinaryTrees(BinaryTree tree1, BinaryTree tree2) {
        if (tree1 == null) return tree2;

        Queue<BinaryTree> tree1Stack = new LinkedList<>();
        Queue<BinaryTree> tree2Stack = new LinkedList<>();

        tree1Stack.offer(tree1);
        tree2Stack.offer(tree2);

        while (tree1Stack.size() > 0) {
            var tree1Node = tree1Stack.poll();
            var tree2Node = tree2Stack.poll();

            if (tree2Node == null) continue;

            tree1Node.value += tree2Node.value;

            if (tree1Node.left == null) {
                tree1Node.left = tree2Node.left;
            } else {
                tree1Stack.offer(tree1Node.left);
                tree2Stack.offer(tree2Node.left);
            }

            if (tree1Node.right == null) {
                tree1Node.right = tree2Node.right;
            } else {
                tree1Stack.offer(tree1Node.right);
                tree2Stack.offer(tree2Node.right);
            }
        }

        return tree1;
    }
}
