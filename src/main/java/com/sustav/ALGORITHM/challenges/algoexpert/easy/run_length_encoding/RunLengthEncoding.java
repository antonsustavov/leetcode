package com.sustav.ALGORITHM.challenges.algoexpert.easy.run_length_encoding;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class RunLengthEncoding {

    //O(n) - time, O(n) - space; n - length of input string
    public String runLengthEncoding(String string) {
        var result = new StringBuilder();
        var sequenceOfChars = string.toCharArray();
        var currentChar = sequenceOfChars[0];
        var theSameCharSequenceCount = 0;

        for (char sequenceOfChar : sequenceOfChars) {
            if (sequenceOfChar == currentChar && theSameCharSequenceCount < 9) {
                theSameCharSequenceCount++;
            } else {
                result.append(theSameCharSequenceCount).append(currentChar);
                currentChar = sequenceOfChar;
                theSameCharSequenceCount = 1;
            }
        }
        result.append(theSameCharSequenceCount).append(currentChar);

        return result.toString();
    }

    //O(n) - time, O(n) - space; n - length of input string
    public String runLengthEncoding2(String string) {
        var encodingString = new StringBuilder();
        var theSameCharSequenceCount = 1;
        char[] chars = string.toCharArray();

        for (var i = 1; i < chars.length; i++) {
            var currentChar = chars[i];
            var previousChar = chars[i - 1];

            if (currentChar != previousChar || theSameCharSequenceCount == 9) {
                encodingString.append(theSameCharSequenceCount).append(previousChar);
                theSameCharSequenceCount = 0;
            }

            theSameCharSequenceCount++;
        }

        encodingString.append(theSameCharSequenceCount).append(chars[chars.length - 1]);

        return encodingString.toString();
    }

    public String runLengthEncoding3(String string) {
        Map<Character, Long> collect = string.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        String collect1 = collect.entrySet()
                .stream().map(entry -> "" + entry.getValue() + entry.getKey())
                .collect(Collectors.joining());
        return collect1;
    }

}
