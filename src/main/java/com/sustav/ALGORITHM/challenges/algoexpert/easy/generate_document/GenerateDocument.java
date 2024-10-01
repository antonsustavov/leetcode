package com.sustav.ALGORITHM.challenges.algoexpert.easy.generate_document;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class GenerateDocument {
    public boolean generateDocument(String characters, String document) {
        char[] givenCharacters = characters.toCharArray();
        char[] givenDocuments = document.toCharArray();

        System.out.println(characters.length());
        System.out.println(document.length());

        Arrays.sort(givenCharacters);
        Arrays.sort(givenDocuments);

        var characterPointer = 0;
        var documentPointer = 0;

        if (givenDocuments.length == 0) {
            return true;
        } else if (givenCharacters.length < 2) {
            return givenCharacters[0] == givenDocuments[0];
        } else {
            while (characterPointer < givenCharacters.length && documentPointer < givenDocuments.length) {
                if (givenDocuments[documentPointer] == givenCharacters[characterPointer]) {
                    characterPointer++;
                    documentPointer++;
                } else {
                    characterPointer++;
                }
            }
        }

        return documentPointer == givenDocuments.length;
    }

    //O(n + m) - time, O(c) - space; m,n - characters, document; c - uniq char
    public boolean generateDocument2(String characters, String document) {
        Map<Character, Integer> buffer = new HashMap<>();

        for (char c: characters.toCharArray()) {
            buffer.put(c, buffer.getOrDefault(c, 0) + 1);
        }

        for (char c: document.toCharArray()) {
            if (!buffer.containsKey(c) || buffer.get(c) == 0) return false;
            buffer.put(c, buffer.get(c) - 1);
        }

        return true;
    }

    //O(m * (n + m)) - time, O(1) - space; m,n - characters, document
    public boolean generateDocument3(String characters, String document) {
        for (char currentChar: document.toCharArray()) {
            var documentFrequency = countCharFrequency(currentChar, document);
            var characterFrequency = countCharFrequency(currentChar, characters);
            if (documentFrequency > characterFrequency) {
                return false;
            }
        }

        return true;
    }

    //O(c * (n + m)) - time, O(c) - space; m,n - characters, document; c - uniq char
    public boolean generateDocument4(String characters, String document) {
        Set<Character> buffer = new HashSet<>();
        for (char currentChar: document.toCharArray()) {
            if (buffer.contains(currentChar)) {
                continue;
            }
            var documentFrequency = countCharFrequency(currentChar, document);
            var characterFrequency = countCharFrequency(currentChar, characters);
            if (documentFrequency > characterFrequency) {
                return false;
            }

            buffer.add(currentChar);
        }

        return true;
    }

    private int countCharFrequency(char currentChar, String document) {
        var frequency = 0;
        for (char character: document.toCharArray()) {
            if (character == currentChar) frequency++;
        }

        return frequency;
    }
}
