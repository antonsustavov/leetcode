package com.sustav.ALGORITHM.challenges.algoexpert.medium.bst_recobstruct;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class ReconstructBSTStack {
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
        Deque<BST> stack = new LinkedList<>();
        int idx = 0;
        BST root = new BST(preOrderTraversalValues.get(0));
        BST current = root;
        stack.addFirst(current);
        idx++;
        while (idx < preOrderTraversalValues.size()) {
            if (current.value > preOrderTraversalValues.get(idx)) {
                BST currentNode = new BST(preOrderTraversalValues.get(idx));
                stack.addFirst(currentNode);
                current.left = currentNode;
                current = current.left;
                idx++;
            } else {
                while (!stack.isEmpty() && preOrderTraversalValues.get(idx) >= stack.peekFirst().value) {
                    current = stack.getFirst();
                }
                BST currentNode = new BST(preOrderTraversalValues.get(idx));
                stack.addFirst(currentNode);
                current.right = currentNode;
                current = current.right;
                idx++;
            }
        }

        return root;
    }

    public static void main(String[] args) {
        Deque<Integer> stack = new LinkedList<>();
        stack.addFirst(0);
        stack.addFirst(1);
        stack.addFirst(2);

        System.out.println(stack.peekFirst());
        System.out.println(stack.getFirst());
    }

}
