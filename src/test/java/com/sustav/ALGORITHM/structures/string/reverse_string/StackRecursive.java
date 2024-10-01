package com.sustav.ALGORITHM.structures.string.reverse_string;

import java.util.Deque;
import java.util.LinkedList;

public class StackRecursive {
    public static void main(String[] args) {
        StackRecursive stackRecursive = new StackRecursive();
        stackRecursive.recursiveStack("geeksforgeeks".toCharArray());
    }

    public void recursiveStack(char[] input) {
        Deque<Character> characters = new LinkedList<>();

        for (char ch: input) {
            characters.addFirst(ch);
        }

        StringBuilder stringBuilder = new StringBuilder();
        characters.forEach(stringBuilder::append);

        System.out.println(stringBuilder);
    }
}
