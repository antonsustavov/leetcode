package com.sustav.ALGORITHM.challenges.algoexpert.medium.bst_successor;

import java.util.ArrayList;
import java.util.List;

public class FindSuccessorBST {
    static class BinaryTree {
        public int value;
        public BinaryTree left = null;
        public BinaryTree right = null;
        public BinaryTree parent = null;

        public BinaryTree(int value) {
            this.value = value;
        }
    }

    public BinaryTree reconstructBst(List<Integer> preOrderTraversalValues) {
        BinaryTree root = new BinaryTree(preOrderTraversalValues.get(0));
        for (int i = 1; i < preOrderTraversalValues.size(); i++) {
            insertNode(preOrderTraversalValues.get(i), root);
        }

        return root;
    }

    private void insertNode(Integer value, BinaryTree root) {
        if (value >= root.value) {
            if (root.right == null) {
                root.right = new BinaryTree(value);
                root.right.parent = root;
            } else {
                insertNode(value, root.right);
            }
        } else {
            if (root.left == null) {
                root.left = new BinaryTree(value);
                root.left.parent = root;
            } else {
                insertNode(value, root.left);
            }
        }

    }

    // O(n) - time, O(n) - space
    public BinaryTree findSuccessor(BinaryTree tree, BinaryTree node) {
        List<BinaryTree> inOrderNodes = new ArrayList<>();
        inOrderHelper(tree, inOrderNodes);

        for (int i = 0; i < inOrderNodes.size(); i++) {
            if (!inOrderNodes.get(i).equals(node)) continue;

            if (i == inOrderNodes.size() - 1) return null;

            return inOrderNodes.get(i + 1);
        }

        return null;
    }

    private List<BinaryTree> inOrderHelper(BinaryTree node, List<BinaryTree> order) {
        if (node == null) {
            return order;
        }

        inOrderHelper(node.left, order);
        order.add(node);
        inOrderHelper(node.right, order);

        return order;
    }

}
