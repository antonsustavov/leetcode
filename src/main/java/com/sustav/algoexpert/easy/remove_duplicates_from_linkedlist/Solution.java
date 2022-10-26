package com.sustav.algoexpert.easy.remove_duplicates_from_linkedlist;

public class Solution {

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList(1);
        linkedList.next = new LinkedList(1);
        linkedList.next.next = new LinkedList(3);
        linkedList.next.next.next = new LinkedList(4);
        linkedList.next.next.next.next = new LinkedList(4);
        linkedList.next.next.next.next.next = new LinkedList(4);
        linkedList.next.next.next.next.next.next = new LinkedList(5);
        linkedList.next.next.next.next.next.next.next = new LinkedList(6);
        linkedList.next.next.next.next.next.next.next.next = new LinkedList(6);
        System.out.println(removeDuplicatesFromLinkedList2(linkedList));
    }

    public static class LinkedList {
        public int value;
        public LinkedList next;

        public LinkedList(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public static LinkedList removeDuplicatesFromLinkedList2(LinkedList linkedList) {
        var head = linkedList;
        var previous = linkedList;
        var next = linkedList.next;
        while (next != null) {
            if (next.value == previous.value) {
                previous.next = next.next;
                next = next.next;
            } else {
                previous = next;
                next = next.next;
            }
        }

        return head;
    }

    public static LinkedList removeDuplicatesFromLinkedList3(LinkedList linkedList) {
        var currentNode = linkedList;
        var nextNode = linkedList.next;
        while (nextNode != null) {
            if (nextNode.value == currentNode.value) {
                currentNode.next = nextNode.next;
                nextNode = nextNode.next;
            } else {
                currentNode = nextNode;
                nextNode = nextNode.next;
            }
        }

        return linkedList;
    }

    public static LinkedList removeDuplicatesFromLinkedList4(LinkedList linkedList) {
        var currentNode = linkedList;
        while (currentNode != null) {
            var nextNode = currentNode.next;
            while (nextNode != null && nextNode.value == currentNode.value) {
                nextNode = nextNode.next;
            }
            currentNode.next = nextNode;
            currentNode = nextNode;
        }

        return linkedList;
    }

    public static LinkedList removeDuplicatesFromLinkedList(LinkedList linkedList) {
        var head = linkedList;
        removeDuplicateRecursion(head);

        return head;
    }

    private static void removeDuplicateRecursion(LinkedList head) {
        var currentValue = head.value;
        if (head == null) {
            return;
        }

    }
}
