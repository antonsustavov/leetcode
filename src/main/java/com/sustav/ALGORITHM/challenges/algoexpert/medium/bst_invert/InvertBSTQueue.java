package com.sustav.ALGORITHM.challenges.algoexpert.medium.bst_invert;

import java.util.LinkedList;
import java.util.Queue;

public class InvertBSTQueue {

    //O(n) - time, O(n) - space
    public static void invertBinaryTree(BinaryTree tree) {
        Queue<BinaryTree> queue = new LinkedList<>();
        queue.offer(tree);
        while (!queue.isEmpty()) {
            BinaryTree current = queue.poll();
            if (current == null) continue;
            swapLeftRight(current);
            queue.offer(current.left);
            queue.offer(current.right);
        }
    }

    private static void swapLeftRight(BinaryTree current) {
        var temp = current.left;
        current.left = current.right;
        current.right = temp;
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
