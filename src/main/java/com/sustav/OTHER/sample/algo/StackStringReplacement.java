package com.sustav.OTHER.sample.algo;

import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

public class StackStringReplacement extends BaseStringReplacement implements StringReplacement {
    @Override
    public String replace(String text) {
        if(text == null || text.isBlank()) {
            return text;
        }

        Deque<Character> stack = new LinkedList<>();
        char prevCh = 0;

        for (var i = 0; i < text.length(); i++) {
            var ch = text.charAt(i);

            for (Rule rule : rules) {
                if (rule.match(ch, prevCh)) {
                    ch = 0;
                    stack.removeLast();
                    prevCh = stack.isEmpty() ? 0 : stack.getLast();
                    break;
                }
            }

            if (ch != 0) {
                stack.addLast(ch);
                prevCh = ch;
            }
        }

        if (stack.isEmpty()) {
            return "";
        } else {
            char[] arr = new char[stack.size()];
            Iterator<Character> iterator = stack.iterator();
            int i = 0;
            while (iterator.hasNext()) {
                arr[i++] = iterator.next();
            }
            return new String(arr);
        }

    }

    public static void main(String[] args) {
        StackStringReplacement stringReplacement = new StackStringReplacement();
        System.out.println(stringReplacement.replace("AACADC"));
    }
}
