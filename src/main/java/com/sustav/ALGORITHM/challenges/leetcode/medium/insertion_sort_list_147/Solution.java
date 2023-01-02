package com.sustav.ALGORITHM.challenges.leetcode.medium.insertion_sort_list_147;

import java.util.ArrayList;

/**
 * @author Anton Sustavov
 * @since 2020/10/03
 */
public class Solution {
    public static void main(String[] args) {
        final Solution solution = new Solution();
//        solution.insertionSortList2(new ListNode(4, new ListNode(2, new ListNode(1, new ListNode(3)))));
        solution.insertionSortList2(new ListNode(-1, new ListNode(5, new ListNode(3, new ListNode(4, new ListNode(0))))));
    }

    public ListNode insertionSortList2(ListNode head) {
        ListNode current = head;
        if (current.next == null) return null;
        boolean isShift = true;
        while (current != null && current.next != null) {
            ListNode pointer = current;
            isShift = false;
            while (pointer != null && pointer.next != null && pointer.val > pointer.next.val) {
                int temp = pointer.next.val;
                pointer.next.val = pointer.val;
                pointer.val = temp;
                pointer = pointer.next;
                isShift = true;
            }
            current = isShift ? current : current.next;
        }
        return head;
    }

    public ListNode insertionSortList(ListNode head) {
        ListNode current = head;
        final ArrayList<Integer> result = new ArrayList<>();
        while (current != null) {
            result.add(current.val);
            current = current.next;
        }
        for (int i = 1; i < result.size(); i++) {
            int value = result.get(i);
            int pointer = i;
            while (pointer > 0 && result.get(pointer-1) > value) {
                result.set(pointer, result.get(pointer-1));
                pointer--;
            }
            result.set(pointer, value);
        }

        if (result.isEmpty()) {
            return null;
        }

        current = new ListNode();
        head = current;
        for (int i = 0; i < result.size(); i++) {
            current.val = result.get(i);
            if (i != result.size()-1) {
                current.next = new ListNode();
                current = current.next;
            }
        }

        return head;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
