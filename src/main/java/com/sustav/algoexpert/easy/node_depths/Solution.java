package com.sustav.algoexpert.easy.node_depths;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Solution {

    public static void main(String[] args) {
        BinaryTreeRoot binaryTreeRoot = new BinaryTreeRoot();
        binaryTreeRoot.insert(binaryTreeRoot.root, 1);
        binaryTreeRoot.insert(binaryTreeRoot.root, 2);
        binaryTreeRoot.insert(binaryTreeRoot.root, 3);
        binaryTreeRoot.insert(binaryTreeRoot.root, 4);
        binaryTreeRoot.insert(binaryTreeRoot.root, 5);
        binaryTreeRoot.insert(binaryTreeRoot.root, 6);
        binaryTreeRoot.insert(binaryTreeRoot.root, 7);
        binaryTreeRoot.insert(binaryTreeRoot.root, 8);
        binaryTreeRoot.insert(binaryTreeRoot.root, 9);
//        binaryTreeRoot.insert(binaryTreeRoot.root, 10);

        System.out.println(nodeDepths(binaryTreeRoot.root));
        System.out.println(nodeDepths2(binaryTreeRoot.root));
        System.out.println(nodeDepths3(binaryTreeRoot.root));

    }

    public static int nodeDepths(BinaryTree root) {
        int sumOfDepths = 0;
        Stack<NodeInfo> stack = new Stack<>();
        stack.push(new NodeInfo(root, 0));

        while (!stack.isEmpty()) {
            NodeInfo currentNodeInfo = stack.pop();
            BinaryTree currentNode = currentNodeInfo.node;
            int currentDepth = currentNodeInfo.depth;
            if (currentNode == null) {
                continue;
            }
            sumOfDepths += currentDepth;
            stack.push(new NodeInfo(currentNode.left, currentDepth + 1));
            stack.push(new NodeInfo(currentNode.right, currentDepth + 1));
        }

        return sumOfDepths;
    }

    public static int nodeDepths2(BinaryTree root) {
        return nodeDepthsRec(root, 0);
    }

    private static int nodeDepthsRec(BinaryTree root, int depthSum) {
        if (root == null) {
            return 0;
        }
        return depthSum + nodeDepthsRec(root.left, depthSum + 1) + nodeDepthsRec(root.right, depthSum + 1);
    }

    public static int nodeDepths3(BinaryTree root) {
        return nodeDepthsRec2(root, 0);
    }

    private static int nodeDepthsRec2(BinaryTree root, int depthSum) {
        if (root == null) {
            return 0;
        }
        if (root.left != null) {
            return depthSum + nodeDepthsRec2(root.left, depthSum + 1);
        }
        if (root.right != null) {
            return depthSum + nodeDepthsRec2(root.right, depthSum + 1);
        }

        return 0;
    }

    static class BinaryTreeRoot {
        BinaryTree root;

        public void insert(BinaryTree temp, int value) {
            if (temp == null) {
                root = new BinaryTree(value);
                return;
            }
            Queue<BinaryTree> queue = new LinkedList<>();
            queue.add(temp);

            while (!queue.isEmpty()) {
                temp = queue.poll();
                if (temp.left == null) {
                    temp.left = new BinaryTree(value);
                    break;
                } else {
                    queue.add(temp.left);
                }

                if (temp.right == null) {
                    temp.right = new BinaryTree(value);
                    break;
                } else {
                    queue.add(temp.right);
                }
            }

        }
    }

    static class BinaryTree {
        int value;
        BinaryTree left;
        BinaryTree right;

        public BinaryTree(int value) {
            this.value = value;
            left = null;
            right = null;
        }
    }

    static class NodeInfo {
        BinaryTree node;
        int depth;

        public NodeInfo(BinaryTree node, int depth) {
            this.node = node;
            this.depth = depth;
        }
    }
}
