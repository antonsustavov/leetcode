package com.sustav.ALGORITHM.challenges.algoexpert.medium.bst_min_height;

import java.util.List;

public class MinHeightBstRecursive {
    // O(nlogn) - time, O(n) - space
    public static BST minHeightBst(List<Integer> array) {
        BST bst = null;
        return minHeightBstHelper(bst, array, 0, array.size() - 1);
    }

    private static BST minHeightBstHelper(BST bst, List<Integer> array, int startIdx, int endIdx) {

        if (endIdx < startIdx) {
            return null;
        }
        int mid = (startIdx + endIdx) / 2;
        if (bst == null) {
            bst = new BST(array.get(mid));
        } else {
            bst.insert(array.get(mid));
        }

        minHeightBstHelper(bst, array, startIdx, mid - 1);
        minHeightBstHelper(bst, array, mid + 1, endIdx);

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

        public BST() {
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
