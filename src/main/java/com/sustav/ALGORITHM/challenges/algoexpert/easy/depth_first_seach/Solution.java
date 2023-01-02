package com.sustav.ALGORITHM.challenges.algoexpert.easy.depth_first_seach;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        Node a = new Node("A");
//        Node b = new Node("B");
//        Node c = new Node("C");
//        Node d = new Node("D");
//        a.addChild("B");
//        a.addChild("C");
//        a.addChild("D");

        a.addChild("B");
        a.addChild("C");
        a.addChild("D");

        List<Node> childrenA = a.children;
        Node b = childrenA.get(0);
        Node c = childrenA.get(1);
        Node d = childrenA.get(2);

        b.addChild("E");
        b.addChild("F");

        List<Node> childrenB = b.children;
        Node f = childrenB.get(1);

        f.addChild("I");
        f.addChild("J");

//        Node e = b.addChild("E");
//        Node f = b.addChild("F");
//
//        Node i = f.addChild("I");
//        Node j = f.addChild("J");
//
//        Node g = d.addChild("G");
//        Node h = d.addChild("H");
//
//        Node k = g.addChild("K");

        System.out.println(a.depthFirstSearch(new ArrayList<>()));
    }

    static class Node {
        String name;
        List<Node> children = new ArrayList<>();

        public Node(String name) {
            this.name = name;
        }

        public List<String> depthFirstSearch(List<String> array) {
            array.add(name);
            for (var child : children) {
                child.depthFirstSearch(array);
            }
            return array;
        }

//        public List<String> depthFirstSearch(List<String> array) {
//            depthFirstSearchRec(this, children, array);
//            return array;
//        }
//
//        private void depthFirstSearchRec(Node currentNode, List<Node> children, List<String> array) {
//            array.add(currentNode.name);
//            for (Node child : children) {
//                depthFirstSearchRec(child, child.children, array);
//            }
//        }

        public Node addChild(String name) {
            Node child = new Node(name);
            children.add(child);
            return this;
        }
    }
}
