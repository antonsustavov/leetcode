package com.sustav.ALGORITHM.challenges.algoexpert.medium.bst_find_kth_largest_value;

import java.util.ArrayList;
import java.util.List;

public class FindKthLargestValueInBst {
    // This is an input class. Do not edit.
    static class BST {
        public int value;
        public BST left = null;
        public BST right = null;

        public BST(int value) {
            this.value = value;
        }
    }

    //O(n) - time, O(n) - space
    public int findKthLargestValueInBst(BST tree, int k) {
        List<Integer> nodes = new ArrayList<>();
        findKthLargestValueInBstHelper(tree, nodes);

        return nodes.get(nodes.size() - k);
    }

    private void findKthLargestValueInBstHelper(BST tree, List<Integer> nodes) {
        if (tree == null) {
            return;
        }
        findKthLargestValueInBstHelper(tree.left, nodes);
        nodes.add(tree.value);
        findKthLargestValueInBstHelper(tree.right, nodes);
    }
}
