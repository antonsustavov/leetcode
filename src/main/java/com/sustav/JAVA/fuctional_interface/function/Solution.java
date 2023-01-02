package com.sustav.JAVA.fuctional_interface.function;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

public class Solution {
    public static void main(String[] args) {
        Map<String, Integer> nameMap = new HashMap<>();
        Integer value = nameMap.computeIfAbsent("John", s -> s.length());
        Integer value3 = nameMap.computeIfAbsent("John", s -> s.length());
        Integer value4 = nameMap.computeIfPresent("John", new BiFunction<String, Integer, Integer>() {
            @Override
            public Integer apply(String s, Integer integer) {
//                System.out.println(s);
//                System.out.println(integer);
                return s.length();
            }
        });
//        System.out.println(value2);
        System.out.println(nameMap);
    }
}
