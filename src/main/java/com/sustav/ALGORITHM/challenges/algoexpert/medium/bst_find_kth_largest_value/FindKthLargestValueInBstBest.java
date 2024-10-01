package com.sustav.ALGORITHM.challenges.algoexpert.medium.bst_find_kth_largest_value;

public class FindKthLargestValueInBstBest {
    // This is an input class. Do not edit.
    static class BST {
        public int value;
        public BST left = null;
        public BST right = null;

        public BST(int value) {
            this.value = value;
        }
    }

    //O(h + k) - time, O(h) - space
    public int findKthLargestValueInBst(BST tree, int k) {
        TreeInfo treeInfo = new TreeInfo();
        findKthLargestValueInBstHelper(tree, treeInfo, k);
        
        return treeInfo.latestValue;
    }

    private void findKthLargestValueInBstHelper(BST tree, TreeInfo treeInfo, Integer k) {
        if (tree == null || treeInfo.latestNode >= k) {
            return;
        }
        findKthLargestValueInBstHelper(tree.right, treeInfo, k);
        if (treeInfo.latestNode < k) {
            treeInfo.latestValue = tree.value;
            treeInfo.latestNode++;
            findKthLargestValueInBstHelper(tree.left, treeInfo, k);
        }

    }

    static class TreeInfo {
        Integer latestNode = 0;
        Integer latestValue = 0;
    }
}
