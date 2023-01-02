package com.sustav.ALGORITHM.challenges.leetcode.easy.merge_two_sorted_lists_21;

/**
 * @author Anton Sustavov
 * @since 2020/09/17
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
public class Solution {
    public static void main(String[] args) {
//        final PriorityQueue<Integer> integerPriorityQueue = new PriorityQueue<Integer>(10);
//        integerPriorityQueue.enqueue(5);
//        integerPriorityQueue.enqueue(6);
//        integerPriorityQueue.enqueue(7);
//        integerPriorityQueue.enqueue(0);
//        integerPriorityQueue.enqueue(1);
//        System.out.println(integerPriorityQueue.dequeue());
//        ListNode l1 = new ListNode(1, new ListNode(2, new ListNode(4)));
//        ListNode l2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode l1 = new ListNode();
        ListNode l2 = new ListNode();
        final Solution solution = new Solution();
        ListNode returnded = solution.mergeTwoLists2(l1, l2);
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode result = new ListNode();
        if (l1 == null && l2 == null) return result;
//        if (l1.val == 0 && l2.val == 0) return result;
        ListNode currentL1 = l1.val <= l2.val ? l1 : l2;
        ListNode currentL2 = l2.val <= l1.val ? l2 : l1;
        ListNode currentResult = result;
        while (currentL1 != null || currentL2 != null) {
            int valL1 = currentL1 == null ? 0 : currentL1.val;
            int valL2 = currentL2 == null ? 0 : currentL2.val;
            if (valL1 <= valL2) {
                currentResult.val = valL1;
                currentResult.next = new ListNode(valL2);
            } else {
                currentResult.val = valL2;
                currentResult.next = new ListNode(valL1);
            }
            if (currentL1.next != null || currentL2.next != null) {
                currentResult = currentResult.next.next = new ListNode();
            }
            currentL1 = currentL1.next == null ? null : currentL1.next;
            currentL2 = currentL2.next == null ? null : currentL2.next;
        }
        return result;
    }

    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        ListNode merged = new ListNode(0);
        ListNode ptr = merged;
        while(l1 != null || l2 != null){
            int val1;
            int val2;
            if(l1 == null){
                ptr.next = l2;
                break;
            }
            if(l2 == null){
                ptr.next = l1;
                break;
            }
            else{
                val1 = l1.val;
                val2 = l2.val;
            }
            if(l1.val > l2.val){
                ptr.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            else{
                ptr.next = new ListNode(l1.val);
                l1 = l1.next;
            }
            ptr = ptr.next;
        }
        return merged.next;
    }
}

class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
