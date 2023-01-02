package com.sustav.ALGORITHM.challenges.leetcode.medium.add_two_numbers_2;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author Anton Sustavov
 * @since 2020/09/13
 */
public class Solution {
    public static void main(String[] args) {
        final Solution solution = new Solution();
        final ListNode l1 = new ListNode(9);
        final ListNode l2 = new ListNode(1, new ListNode(9, new ListNode(9)));
        final ListNode listNode = solution.addTwoNumbers4(l1, l2);
        int s=0;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> l1Stack = new Stack<>();
        Stack<Integer> l2Stack = new Stack<>();
        ListNode currl1 =l1;
        ListNode currl2 = l2;
         while (currl1 != null) {
             l1Stack.push(currl1.val);
             currl1 = currl1.next;
         }
        while (currl2 != null ) {
            l2Stack.push(currl2.val);
            currl2 = currl2.next;
        }
        StringBuilder s1 = new StringBuilder();
        StringBuilder s2 = new StringBuilder();
        while (!l1Stack.empty()) {
            s1.append(l1Stack.pop());
        }
        while (!l2Stack.empty()) {
            s2.append(l2Stack.pop());
        }
        BigInteger result = new BigInteger(s1.toString()).add(new BigInteger(s2.toString()));
        String number = String.valueOf(result);
        ListNode rs = new ListNode();
        ListNode current = rs;
        int i = number.length();
        do {
            i = i -1;
            int j = Character.digit(number.charAt(i), 10);
            current.val = j;
            current.next = i > 0 ? new ListNode(): null;
            current = current.next;
        }while (i > 0);

        return rs;
    }

    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        Stack<Integer> l1Stack = new Stack<>();
        ListNode currl1 = l1;
        ListNode currl2 = l2;
        int i1 = 0;
        int i2 = 0;
        while (currl1 != null) {
            l1Stack.push(currl1.val);
            currl1 = currl1.next;
            i1++;
        }
        while (currl2 != null ) {
            l1Stack.push(currl2.val);
            currl2 = currl2.next;
            i2++;
        }
        StringBuilder s1 = new StringBuilder();
        StringBuilder s2 = new StringBuilder();
        while (!l1Stack.empty()) {
            if (i2 > 0) {
                s2.append(l1Stack.pop());
                i2--;
            } else {
                s1.append(l1Stack.pop());
            }
        }
        BigInteger result = new BigInteger(s1.toString()).add(new BigInteger(s2.toString()));
        String number = String.valueOf(result);
        ListNode rs = new ListNode();
        ListNode current = rs;
        int i = number.length();
        do {
            i = i -1;
            int j = Character.digit(number.charAt(i), 10);
            current.val = j;
            current.next = i > 0 ? new ListNode(): null;
            current = current.next;
        }while (i > 0);

        return rs;
    }

    public ListNode addTwoNumbers3(ListNode l1, ListNode l2) {
        List<Integer> l1Stack = new ArrayList<>();
        ListNode currl1 = l1;
        ListNode currl2 = l2;
//        int i1 = 0;
        int i2 = 0;
        while (currl1 != null) {
            l1Stack.add(currl1.val);
            currl1 = currl1.next;
//            i1++;
        }
        while (currl2 != null ) {
            l1Stack.add(currl2.val);
            currl2 = currl2.next;
            i2++;
        }
        StringBuilder s1 = new StringBuilder();
        StringBuilder s2 = new StringBuilder();
        for (int i = l1Stack.size()-1; i > 0; i--) {
            if (i2 > 0) {
                s2.append(l1Stack.get(i));
                i2--;
            } else {
                s1.append(l1Stack.get(i));
            }
        }
        BigInteger result = new BigInteger(s1.toString()).add(new BigInteger(s2.toString()));
        String number = String.valueOf(result);
        ListNode rs = new ListNode();
        ListNode current = rs;
        int i = number.length();
        do {
            i = i -1;
            int j = Character.digit(number.charAt(i), 10);
            current.val = j;
            current.next = i > 0 ? new ListNode(): null;
            current = current.next;
        }while (i > 0);

        return rs;
    }

    public ListNode addTwoNumbers4(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }
}

class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
