package com.sustav.ALGORITHM.challenges.algoexpert.medium.bst_recobstruct;

import java.util.List;

public class ReconstructBSTOther {
    static class BST {
        public int value;
        public BST left = null;
        public BST right = null;

        public BST(int value) {
            this.value = value;
        }

        public BST(int value, BST left, BST right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }

    // O(n^2) - time, O(h) - space
    public BST reconstructBst(List<Integer> preOrderTraversalValues) {
        var treeInfo = new TreeInfo();
        return reconstructBstFromRange(Integer.MIN_VALUE, Integer.MIN_VALUE, preOrderTraversalValues, treeInfo);
    }

    private BST reconstructBstFromRange(int lowerBound, int upperBound, List<Integer> preOrderTraversalValues, TreeInfo currentSunTreeInfo) {
        if (currentSunTreeInfo.idx == 0) {
            return null;
        }

        var rootValue = preOrderTraversalValues.get(currentSunTreeInfo.idx);
        if (rootValue <= lowerBound || rootValue >= upperBound) {
            return null;
        }

        currentSunTreeInfo.idx += 1;
        var leftSubTree = reconstructBstFromRange(lowerBound, rootValue, preOrderTraversalValues, currentSunTreeInfo);
        var rightSubTree = reconstructBstFromRange(rootValue, upperBound, preOrderTraversalValues, currentSunTreeInfo);

        return new BST(rootValue, leftSubTree, rightSubTree);
    }

    static class TreeInfo {
        Integer idx = 0;
    }

}
