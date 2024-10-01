package com.sustav.ALGORITHM.challenges.algoexpert.easy.first_non_repeating_character;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class FirstNonRepeatingCharacter {

    //O(c * n) - time, O(c) - space; c - uniq chars, n - number of chars
    public int firstNonRepeatingCharacter(String string) {
        Set<Character> characterIntegerHashMap = new HashSet<>();
        var stringChars = string.toCharArray();
        var indexResult = -1;

        for (var i = 0; i < string.length(); i++) {
            if (characterIntegerHashMap.contains(stringChars[i])) {
                continue;
            }
            var charFrequency = countCharFrequency(stringChars[i], string);
            if (charFrequency > 1) {
                characterIntegerHashMap.add(stringChars[i]);
            } else {
                indexResult = i;
                break;
            }
        }

        return indexResult;
    }

    private int countCharFrequency(char ch, String string) {
        var frequency = 0;

        for (char curChar: string.toCharArray()) {
            if (curChar == ch) {
                frequency++;
            }
        }

        return frequency;
    }

    //O(n^2) - time, O(1) - space;
    public int firstNonRepeatingCharacterDuplicate(String string) {
        char[] idx = string.toCharArray();
        for (var i = 0; i < idx.length; i++) {
            var foundDuplicate = false;
            for (int j = 0; j < idx.length; j++) {
                if (idx[i] == idx[j] && i != j) {
                    foundDuplicate = true;
                }
            }
            if (!foundDuplicate) {
                return i;
            }
        }

        return -1;
    }

    //O(n) - time, O(1 (26)) - space; 26 characters
    public int firstNonRepeatingCharacterBitmap(String string) {
        HashMap<Character, Integer> counts = new HashMap<>();
        for (char ch: string.toCharArray()) {
            counts.put(ch, counts.getOrDefault(ch, 0) + 1);
        }

        char[] chars = string.toCharArray();
        for (var i = 0; i < string.length(); i++) {
            if (counts.get(chars[i]) == 1) {
                return i;
            }
        }

        return -1;
    }

}
