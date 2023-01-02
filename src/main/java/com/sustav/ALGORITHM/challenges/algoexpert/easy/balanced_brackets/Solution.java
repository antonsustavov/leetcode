package com.sustav.ALGORITHM.challenges.algoexpert.easy.balanced_brackets;

import java.util.Deque;
import java.util.LinkedList;

public class Solution {

    public static void main(String[] args) {
        String strB = "([{{[(())]}}])";
        String strNB = "{{[]()}}}}";

        System.out.println(isBalanced(strB));
        System.out.println(isBalanced(strNB));

        System.out.println(isBalanced2(strB));
        System.out.println(isBalanced2(strNB));

    }

    public static boolean isBalanced(String str) {
        if (!validSequence(str)) return false;

        while (str.contains("()") || str.contains("[]") || str.contains("{}")) {
            str = str.replaceAll("\\(\\)", "")
                    .replaceAll("\\[\\]", "")
                    .replaceAll("\\{\\}", "");
        }
//        return (str.length() == 0);
        return str.isEmpty();
    }

    public static boolean isBalanced2(String str) {
        if (!validSequence(str)) return false;
        Deque<Character> deque = new LinkedList<>();

        for (char ch: str.toCharArray()) {
            if (ch == '{' || ch == '[' || ch == '(') {
                deque.addFirst(ch);
            } else {
                if (!deque.isEmpty()
                        && ((deque.peekFirst() == '{' && ch == '}')
                        || (deque.peekFirst() == '[' && ch == ']')
                        || (deque.peekFirst() == '(' && ch == ')'))) {
                    deque.removeFirst();
                } else {
                    return false;
                }
            }
        }
        return deque.isEmpty();
    }

    private static boolean validSequence(String str) {
        if (null == str || ((str.length() % 2) != 0)) {
            return false;
        } else {
            char[] ch = str.toCharArray();
            for (char c : ch) {
                if (!(c == '{' || c == '[' || c == '(' || c == '}' || c == ']' || c == ')')) {
                    return false;
                }
            }
        }
        return true;
    }
}
