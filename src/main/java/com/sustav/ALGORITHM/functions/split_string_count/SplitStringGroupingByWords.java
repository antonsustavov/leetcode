package com.sustav.ALGORITHM.functions.split_string_count;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SplitStringGroupingByWords {

    public Map<String, Integer> uniqueStringCounter(String str) {
        return Arrays.stream(str.split(" ")).
                collect(Collectors.toConcurrentMap(
                        w -> w, w -> 1, Integer::sum));
    }

    public Map<String, Long> uniqueStringCounter2(String str) {
        return Arrays.stream(str.split(" "))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }
}
