package com.sustav.ALGORITHM.challenges.algoexpert.easy.sort_alphabet;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.concurrent.atomic.LongAccumulator;
import java.util.concurrent.atomic.LongAdder;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class SortWithAlphabet {

    public static String sort(String alphabet, String inputString) {
        if (inputString == null || inputString.isEmpty()) {
            return "";
        }

        Map<Character, Long> dataCardinality = inputString.chars()
                .mapToObj(character -> (char) character)
//                .map(String::valueOf)
                .collect(groupingBy(identity(), counting()));

        StringBuilder resultString = new StringBuilder();

        for (char character : alphabet.toCharArray()) {
            long characterCardinality = dataCardinality.getOrDefault(character, 0L);

            for (int i = 0; i < characterCardinality; i++) {
                resultString.append(character);
            }
        }

        for (char character : inputString.toCharArray()) {
            if (!alphabet.contains(String.valueOf(character))) {
                resultString.append(character);
            }
        }

        return resultString.toString();
    }

    public static void main(String[] args) {
//        "aaacbfxtrtr
//        SortWithAlphabet.sort("acbfx", "abftxrcatra");
//
//        String str1 = "abc1";
//        String str2 = "abc1";
//        System.out.println(str1 == str2);
//        System.out.println(str1.equals(str2));
//
//        System.out.println("second -----");
//        String str3 = new String("abc1");
//        System.out.println(str1 == str3);
//        System.out.println(str1.equals(str3));
//        System.out.println("Hash code");
//        System.out.println(str3.hashCode());
//        System.out.println(str2.hashCode());
//        System.out.println(str1.hashCode());
//
//        System.out.println("Identity hash code");
//        System.out.println(System.identityHashCode(str3));
//        System.out.println(System.identityHashCode(str2));
//        System.out.println(System.identityHashCode(str1));
//
//        System.out.println(Objects.hashCode(str3));
//        System.out.println(Objects.hashCode(str2));
//        System.out.println(Objects.hashCode(str1));

        Integer int1 = 1359;
        Integer int2 = 1359;
        System.out.println(int1 == int2);
        System.out.println(int1.equals(int2));
//
//        int int12 = 1359;
//        int int22 = 1359;
//        System.out.println(int12 == int22);
//
//        Integer int3 = Integer.valueOf(1359);
//        System.out.println(int1 == int3);
//        System.out.println(int1.equals(int3));

        Integer int11 = -127;
        Integer int22 = -127;

        System.out.println(int11 == int22);
        System.out.println(int11.equals(int22));

        Map<String, Integer> stringIntegerHashMap = new HashMap<>();
        Set<String> hhsss = new HashSet<>();
        SortedMap<String, Integer> stringIntegerSortedMap = new TreeMap<>();

        LongAdder longAdder = new LongAdder();
        LongAccumulator longAccumulator = new LongAccumulator(Long::sum, 0);

        Integer vvv = Integer.valueOf(10);
        vvv++;
        System.out.println(vvv);

        PriorityQueue<Integer> prqueue = new PriorityQueue<>();
        prqueue.add(1);
        prqueue.add(3);
        prqueue.add(5);
        prqueue.add(2);
        prqueue.add(4);
        prqueue.add(6);

        while (!prqueue.isEmpty()) {
            System.out.println(prqueue.remove());
        }
    }

}
