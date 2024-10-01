package com.sustav.ALGORITHM.challenges.algoexpert.medium.bst_construction;

public class BSTConstructionRecursive {
    public static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
        }

        // Average: O(logn) - time, O(logn) - space
        // Worst: O(n) - time, O(n) - space
        public BST insert(int value) {
            insertHelper(this, value);

            return this;
        }

        private BST insertHelper(BST bst, int value) {
            if (bst == null) {
                return new BST(value);
            }
            if (value < bst.value) {
                bst.left = insertHelper(bst.left, value);
            } else {
                bst.right = insertHelper(bst.right, value);
            }

            return bst;
        }

        // Average: O(logn) - time, O(n) - space
        // Worst: O(n) - time, O(n) - space
        public boolean contains(int value) {
            return containsHelper(this, value);
        }

        private boolean containsHelper(BST bst, int value) {
            if (bst == null) {
                return false;
            }
            if (bst.value == value) {
                return true;
            } else if (value < bst.value) {
                return containsHelper(bst.left, value);
            } else {
                return containsHelper(bst.right, value);
            }
        }

        // Average: O(logn) - time, O(n) - space
        // Worst: O(n) - time, O(n) - space
        public BST remove(int value) {
            removeHelper(this, value);

            return this;
        }

        private BST removeHelper(BST bst, int value) {
            if (bst == null) {
                return bst;
            }
            if (value < bst.value) {
                bst.left = removeHelper(bst.left, value);
            } else if (value > bst.value) {
                bst.right = removeHelper(bst.right, value);
            } else {
                if (bst.left == null && bst.right == null) {
                    return null;
                }
                if (bst.left != null && bst.right == null) {
                    bst.value = bst.left.value;
                    bst.right = bst.left.right;
                    bst.left = bst.left.left;
                    return bst;
                }
                if (bst.left == null && bst.right != null) {
                    bst.value = bst.right.value;
                    bst.left = bst.right.left;
                    bst.right = bst.right.right;
                    return bst;
                }
                if (bst.left != null && bst.right != null) {
                    int smallest = getSmallest(bst.right);
                    bst.value = smallest;
                    bst.right = removeHelper(bst.right, smallest);
                    return bst;
                }

            }

            return bst;
        }

        private int getSmallest(BST bst) {
            return bst.left == null ? bst.value : getSmallest(bst.left) ;
        }
    }
}
