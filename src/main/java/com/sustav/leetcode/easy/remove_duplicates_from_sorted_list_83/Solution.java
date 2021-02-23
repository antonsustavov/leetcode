package com.sustav.leetcode.easy.remove_duplicates_from_sorted_list_83;

import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Anton Sustavov
 * @since 2020/09/26
 */
public class Solution {
    public static void main(String[] args) {
        final Solution solution = new Solution();
        solution.deleteDuplicates2(new ListNode(1, new ListNode(1, new ListNode(2))));
        solution.deleteDuplicates2(new ListNode(1, new ListNode(1, new ListNode(1))));
    }

    public ListNode deleteDuplicates(ListNode head) {
        ListNode current = head;
        final BitSet bitSet = new BitSet(256);
        while (current != null) {
            int nextVal = current.next == null ? current.val : current.next.val;
            bitSet.set(current.val);
            if (bitSet.get(nextVal)) {
                current.next = current.next == null ? null : current.next.next;
                current = current.next == null ? null : current;
            } else {
                bitSet.set(current.val);
            }
            current = current == null ? null : current.next;
        }

        return head;
    }

    public ListNode deleteDuplicates2(ListNode head) {
        if (head == null || head.next == null) return head;
        final BitSet bitSet = new BitSet(256);
        ListNode current = head;
        ListNode previous = null;
        while (current != null) {
            if (previous == null) {
               previous = current;
               bitSet.set(current.val);
            } else {
                if (bitSet.get(current.val)) {
                    previous.next = current.next;
                }else {
                    bitSet.set(current.val);
                    previous = current;
                }
            }
            current = current.next;
        }

        return head;
    }

    public ListNode deleteDuplicates3(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode current = head;
        while (current != null && current.next != null) {
            if (current.val == current.next.val) {
                current.next = current.next.next;
            }else {
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
