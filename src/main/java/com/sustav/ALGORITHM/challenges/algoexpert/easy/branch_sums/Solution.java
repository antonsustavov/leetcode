package com.sustav.ALGORITHM.challenges.algoexpert.easy.branch_sums;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {

    public static void main(String[] args) {
//        var bt = new BinaryTreeRoot(1);
//        bt.root.left = new BinaryTree(2);
//        bt.root.right = new BinaryTree(3);
//        bt.root.left.left = new BinaryTree(4);
//        bt.root.left.right = new BinaryTree(5);
//        bt.root.right.left = new BinaryTree(6);
//        bt.root.right.right = new BinaryTree(7);
//        bt.root.left.left.left = new BinaryTree(8);
//        bt.root.left.left.right = new BinaryTree(9);
//        bt.root.left.right.left = new BinaryTree(10);

        var bt = new BinaryTreeRoot();
        bt.insert(bt.root, 1);
        bt.insert(bt.root, 2);
        bt.insert(bt.root, 3);
        bt.insert(bt.root, 4);
        bt.insert(bt.root, 5);
        bt.insert(bt.root, 6);
        bt.insert(bt.root, 7);
        bt.insert(bt.root, 8);
        bt.insert(bt.root, 9);
        bt.insert(bt.root, 10);

        System.out.println(branchSums(bt.root));
//        System.out.println(branchSums2(bt.root));
    }

    public static List<Integer> branchSums(BinaryTree root) {
        ArrayList<Integer> results = new ArrayList<>();
        branchSumsRec(root, 0, results);
        return results;
    }

    private static void branchSumsRec(BinaryTree root, int sum, ArrayList<Integer> integers) {
        if (root == null) {
            return;
        }
        int currentSums = sum + root.value;
        if (root.left == null && root.right == null) {
            integers.add(currentSums);
            return;
        }

        branchSumsRec(root.left, currentSums, integers);
        branchSumsRec(root.right, currentSums, integers);
    }

    public static class BinaryTree {
        int value;
        BinaryTree left;
        BinaryTree right;

        BinaryTree(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    static class BinaryTreeRoot {
        BinaryTree root;

        public void insert(BinaryTree temp, int key) {
            if (temp == null) {
                root = new BinaryTree(key);
                return;
            }
            Queue<BinaryTree> q = new LinkedList<>();
            q.add(temp);

            // Do level order traversal until we find
            // an empty place.
            while (!q.isEmpty()) {
                temp = q.peek();
                q.remove();

                if (temp.left == null) {
                    temp.left = new BinaryTree(key);
                    break;
                } else
                    q.add(temp.left);

                if (temp.right == null) {
                    temp.right = new BinaryTree(key);
                    break;
                } else
                    q.add(temp.right);
            }
        }
    }

}
