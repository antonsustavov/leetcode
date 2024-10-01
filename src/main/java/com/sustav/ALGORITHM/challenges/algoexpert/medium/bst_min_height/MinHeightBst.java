package com.sustav.ALGORITHM.challenges.algoexpert.medium.bst_min_height;

import java.util.List;

public class MinHeightBst {
    // O(n) - time, O(n) - space
    public static BST minHeightBst(List<Integer> array) {
        int currentSize = array.size();
        if (currentSize == 0) {
            return null;
        }
        int mid = currentSize / 2;
        BST bst = new BST(array.get(mid));
        bst.left = minHeightBst(array.subList(0, mid));
        bst.right = minHeightBst(array.subList(mid + 1, array.size()));

        return bst;
    }

    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
            left = null;
            right = null;
        }

        public void insert(int value) {
            if (value < this.value) {
                if (left == null) {
                    left = new BST(value);
                } else {
                    left.insert(value);
                }
            } else {
                if (right == null) {
                    right = new BST(value);
                } else {
                    right.insert(value);
                }
            }
        }
    }
}
