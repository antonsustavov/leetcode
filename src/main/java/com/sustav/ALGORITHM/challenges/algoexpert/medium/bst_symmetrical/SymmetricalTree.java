package com.sustav.ALGORITHM.challenges.algoexpert.medium.bst_symmetrical;

import java.util.LinkedList;
import java.util.Queue;

public class SymmetricalTree {
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
        Queue<BinaryTree> stackLeft = new LinkedList<>();
        Queue<BinaryTree> stackRight = new LinkedList<>();
        stackLeft.offer(tree.left);
        stackRight.offer(tree.right);

        while (stackLeft.size() > 0) {
            var left = stackLeft.poll();
            var right = stackRight.poll();

            if (left == null && right == null) continue;

            if (left == null || right == null || left.value != right.value) return false;

            stackLeft.offer(left.left);
            stackLeft.offer(left.right);

            stackRight.offer(right.right);
            stackRight.offer(right.left);
        }

        return true;
    }
}
