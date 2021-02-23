package com.sustav.leetcode.easy.valid_parentheses_20;

import com.sustav.leetcode.structure.stack.Stack;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Queue;

/**
 * @author Anton Sustavov
 * @since 2020/09/17
 */
public class Solution {
    public static void main(String[] args) {
        final Solution solution = new Solution();
        System.out.println(solution.isValid2("()[]{}"));
        System.out.println(solution.isValid2("(]"));
        System.out.println(solution.isValid2("([)]"));
        System.out.println(solution.isValid2("{[]}"));
    }

    public boolean isValid(String s) {
        final Stack<Character> characterStack = new Stack<>(s.length());
        final HashMap<Character, Character> characterCharacterHashMap = new HashMap<>();
        characterCharacterHashMap.put(')', '(');
        characterCharacterHashMap.put('}', '{');
        characterCharacterHashMap.put(']', '[');
        for (int i = 0; i < s.length(); i++) {
            final char c = s.charAt(i);
            if (!characterCharacterHashMap.containsKey(c)) {
                characterStack.push(c);
            } else {
                if (characterStack.isEmpty() || characterStack.pop() != characterCharacterHashMap.get(c)) {
                    return false;
                }
            }
        }

        return characterStack.isEmpty();
    }

    public boolean isValid2(String s) {
        char[] characterStack = new char[s.length()];
        char bracket = ')';
        char brace = '}';
        char squareBracket = ']';
        final HashMap<Character, Character> characterCharacterHashMap = new HashMap<>();
        characterCharacterHashMap.put(bracket, '(');
        characterCharacterHashMap.put(brace, '{');
        characterCharacterHashMap.put(squareBracket, '[');
        int pointer = 0;
        for (int i = 0; i < s.length(); i++) {
            final char c = s.charAt(i);
            if (c != bracket && c != brace && c != squareBracket) {
                characterStack[i] = c;
            } else {
                if (pointer == 0 || characterStack[pointer-1] != characterCharacterHashMap.get(c)) {
                    return false;
                }else {
                    pointer--;
                    continue;
                }
            }
            pointer++;
        }

        return true;
    }
}
