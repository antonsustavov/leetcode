package com.sustav.ALGORITHM.challenges.algoexpert.easy.semordnilap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Semordnilap {
    public ArrayList<ArrayList<String>> semordnilap(String[] words) {
        ArrayList<ArrayList<String>> result = new ArrayList<>(new ArrayList<>());
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                var leftPointer = 0;
                var rightPointer = words[j].length() - 1;
                var isSemordnilap = true;
                while (leftPointer < words[i].length() && rightPointer >= 0) {
                    if (words[i].charAt(leftPointer) != words[j].charAt(rightPointer) || words[i].length() != words[j].length()) {
                        isSemordnilap = false;
                        break;
                    }
                    leftPointer++;
                    rightPointer--;
                }
                if (isSemordnilap) {
                    ArrayList<String> buffer = new ArrayList<>();
                    buffer.add(words[i]);
                    buffer.add(words[j]);
                    result.add(buffer);
                }
            }
        }

        return result;
    }

    public ArrayList<ArrayList<String>> semordnilapRevers(String[] words) {
        ArrayList<ArrayList<String>> result = new ArrayList<>();
        Set<String> wordSet = new HashSet<>();
        for (String word : words) {
            String reversWord = new StringBuilder(word).reverse().toString();
            if (wordSet.contains(reversWord)) {
                ArrayList<String> strings = new ArrayList<>();
                strings.add(word);
                strings.add(reversWord);
                result.add(strings);
                wordSet.remove(word);
            } else {
                wordSet.add(word);
            }
        }

        return result;
    }

    // O(n * m) - time, O(n * m) - space
    public ArrayList<ArrayList<String>> semordnilapReversSet(String[] words) {
        ArrayList<ArrayList<String>> result = new ArrayList<>();
        Set<String> wordSet = new HashSet<>();
        for (String word : words) {
            String wordRevers = new StringBuilder(word).reverse().toString();
            if (wordSet.contains(wordRevers)) {
                result.add(new ArrayList<>(Arrays.asList(word, wordRevers)));
                wordSet.removeAll(List.of(word, wordRevers));
            } else {
                wordSet.add(word);
            }
        }

        return result;
    }
}
