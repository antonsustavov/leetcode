package com.sustav.algoexpert.easy.find_closest_value_BST;

public class Solution {

    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        bt.add(10);
        bt.add(15);
        bt.add(22);
        bt.add(13);
        bt.add(14);
        bt.add(5);
        bt.add(5);
        bt.add(2);
        bt.add(1);

        BinaryTree bt2 = new BinaryTree();
        bt2.add(100);
        bt2.add(502);
        bt2.add(55000);
        bt2.add(1001);
        bt2.add(4500);
        bt2.add(204);
        bt2.add(205);
        bt2.add(207);
        bt2.add(208);
        bt2.add(206);
        bt2.add(203);
        bt2.add(5);
        bt2.add(15);
        bt2.add(22);
        bt2.add(57);
        bt2.add(60);
        bt2.add(5);
        bt2.add(2);
        bt2.add(3);
        bt2.add(1);
        bt2.add(1);
        bt2.add(1);
        bt2.add(1);
        bt2.add(1);
        bt2.add(-51);
        bt2.add(-403);

        System.out.println(findClosestValueInBst(bt.root, 12));
        System.out.println(findClosestValueInBst2(bt2.root, -500));
        System.out.println(findClosestValueInBst3(bt.root, 12));
    }

    public static int findClosestValueInBst(BST tree, int target) {
        if (target == tree.value) {
            return tree.value;
        } else if (target < tree.value && tree.left != null) {
            tree = tree.left;
        } else if (target > tree.value && tree.right != null) {
            tree = tree.right;
        } else {
            return tree.value;
        }

        return findClosestValueInBst(tree, target);
    }

    public static int findClosestValueInBst2(BST tree, int target) {
        int closestValue = Integer.MAX_VALUE;
        System.out.println(closestValue);
        int gggg = 2147483647;
        BST currentNode = tree;
        while (currentNode != null) {
            // closestValue = Math.abs(target - closestValue) > Math.abs(target - currentNode.value) ? currentNode.value : closestValue;
            if (Math.abs(target - closestValue) > Math.abs(target - currentNode.value)) {
                closestValue = currentNode.value;
            }

            if (target < currentNode.value) {
                currentNode = currentNode.left;
            } else if(target > currentNode.value) {
                currentNode = currentNode.right;
            } else {
                break;
            }
        }

        return closestValue;
    }

    public static int findClosestValueInBst3(BST tree, int target) {
        int closestValue = 0;
        BST currentNode = tree;
        int diff = Integer.MAX_VALUE;

        while (currentNode != null) {
            int currentDiff = Math.abs(currentNode.value - target);
            if (currentDiff < diff) {
                diff = currentDiff;
                closestValue = currentNode.value;
            }
            if (target == currentNode.value) {
                return currentNode.value;
            } else if (target < currentNode.value) {
                currentNode = currentNode.left;
            } else {
                currentNode = currentNode.right;
            }
        }

        return closestValue;
    }

    static class BinaryTree {
        BST root;

        public void add(int value) {
            root = addRecursive(root, value);
        }
    }

    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
        }

    }

    private static BST addRecursive(BST current, int value) {
        if (current == null) {
            return new BST(value);
        }

        if (value < current.value) {
            current.left = addRecursive(current.left, value);
        } else if (value >= current.value) {
            current.right = addRecursive(current.right, value);
        } else {
            // value already exists
            return current;
        }

        return current;
    }

}
