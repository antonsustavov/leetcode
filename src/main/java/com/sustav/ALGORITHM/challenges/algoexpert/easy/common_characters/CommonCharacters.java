package com.sustav.ALGORITHM.challenges.algoexpert.easy.common_characters;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CommonCharacters {

    // O(n * m) time, O(c) space; n - number of strings, m - length of the longest string, c - unique characters
    public static String[] commonCharacters(String[] strings) {
        var result = new HashMap<Character, Integer>();
        for (String str : strings) {
            char[] e1 = str.toCharArray();
            Set<Character> uniqueCharacters = new HashSet<>();
            for (int i = 0; i < e1.length; i++) {
                uniqueCharacters.add(e1[i]);
            }
            for (Character ch : uniqueCharacters) {
                result.computeIfAbsent(ch, character -> 0);
                result.computeIfPresent(ch, (character, integer) -> integer + 1);
            }
        }

//        List<Character> collect = result.entrySet().stream()
//                .filter(entry -> entry.getValue() == strings.length)
//                .map(Map.Entry::getKey)
//                .toList();

        return result.entrySet().stream()
                .filter(entry -> entry.getValue() == strings.length)
                .map(Map.Entry::getKey)
                .map(Object::toString)
                .toArray(String[]::new);

//        return collect.stream().map(Object::toString).toArray(String[]::new);
    }

    public static void main(String[] args) {
        String[] str = {"abc", "bcd", "cbaccd"};
        System.out.println(Arrays.toString(commonCharacters(str)));
        System.out.println(sumOfList(List.of(1, 2.2, 3, 6.81)));
    }

    public static float sumOfList(List<? extends Number> list) {
        float sum = 0;
        for (Number num : list) {
            sum += num.doubleValue();
        }

        return sum;
    }
}
