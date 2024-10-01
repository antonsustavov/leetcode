package com.sustav.ALGORITHM.challenges.algoexpert.medium.reverse_word_in_string;

import java.util.ArrayList;
import java.util.List;

public class ReverseWordInString {
    // O(n) - time, O(n) - space
    public String reverseWordsInString(String string) {
        List<String> words = new ArrayList<>();
        var startOfWord = 0;
        char[] chars = string.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            var character = string.charAt(i);
            if (character == ' ') {
                words.add(string.subSequence(startOfWord, i).toString());
                startOfWord = i;
            } else if (string.charAt(startOfWord) == ' ') {
                words.add(" ");
                startOfWord = i;
            }
        }

        words.add(string.subSequence(startOfWord, string.length()).toString());
        reverseList(words);

        return String.join("", words);
    }

    private void reverseList(List<String> words) {
//        Collections.reverse(words);
        var start = 0;
        var end = words.size() - 1;
        while (start < end) {
            var temp = words.get(start);
            words.set(start, words.get(end));
            words.set(end, temp);
            start++;
            end--;
        }
    }

    public String reverseWordsInString2(String string) {
        char[] characters = string.toCharArray();
        reverseListRange(characters, 0, characters.length - 1);

        return "";
    }

    private void reverseListRange(char[] words, int start, int end) {
        while (start < end) {
            var temp = words[start];
            words[start] = words[end];
            words[end] = temp;
            start++;
            end--;
        }
    }
}
