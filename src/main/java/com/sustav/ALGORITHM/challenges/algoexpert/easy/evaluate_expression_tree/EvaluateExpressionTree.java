package com.sustav.ALGORITHM.challenges.algoexpert.easy.evaluate_expression_tree;

public class EvaluateExpressionTree {

    static class BinaryTree {
        public int value;
        public BinaryTree left = null;
        public BinaryTree right = null;

        public BinaryTree(int value) {
            this.value = value;
        }
    }

    // O(n) time, O(h) space
    public int evaluateExpressionTree(BinaryTree tree) {
        if (tree.value >= 0)
            return tree.value;

        var leftValue = evaluateExpressionTree(tree.left);
        var rightValue = evaluateExpressionTree(tree.right);

        if (tree.value == -1) {
            return leftValue + rightValue;
        } else if (tree.value == -2) {
            return leftValue - rightValue;
        } else if (tree.value == -3) {
            return leftValue / rightValue;
        }

        return leftValue * rightValue;
    }
}
