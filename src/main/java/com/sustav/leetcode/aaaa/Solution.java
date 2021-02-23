package com.sustav.leetcode.aaaa;

import javax.swing.text.StyledEditorKit;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;


/**
 * @author Anton Sustavov
 * @since 2020/10/19
 */
public class Solution {
    static int count = 0;

    public static void main(String[] args) throws IOException {

        String hh = "Hello";
        for (int i = 0; i < hh.length(); i++) {
            System.out.println(hh.charAt(i+1));
        }
//        final ArrayList<Boolean> booleans = new ArrayList<>();
//        booleans.add(true);
//        booleans.add(Boolean.parseBoolean());
//        String gg = "Hello World!";
//        int x = 5;
//        x = 10;
//        System.out.println(x);
//        final String substring = gg.substring(6, 12);
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
//        int devicenamesCount = Integer.parseInt(bufferedReader.readLine().trim());
//
//        List<String> devicenames = IntStream.range(0, devicenamesCount).mapToObj(i -> {
//            try {
//                return bufferedReader.readLine();
//            } catch (IOException ex) {
//                throw new RuntimeException(ex);
//            }
//        })
//                .collect(toList());
//
//        List<String> result = Result.deviceNamesSystem(devicenames);
//
//        bufferedWriter.write(
//                result.stream()
//                        .collect(joining("\n"))
//                        + "\n"
//        );
//
//        bufferedReader.close();
//        bufferedWriter.close();
    }
}

class Result {

    /*
     * Complete the 'deviceNamesSystem' function below.
     *
     * The function is expected to return a STRING_ARRAY.
     * The function accepts STRING_ARRAY devicenames as parameter.
     */

    public static List<String> deviceNamesSystem(List<String> devicenames) {
        final HashMap<String, Integer> stringIntegerHashMap = new HashMap<>();
        final ArrayList<String> result = new ArrayList<>();
        if (devicenames.isEmpty()) return result;
        for (String dev : devicenames) {
            if(stringIntegerHashMap.containsKey(dev)){
                int x = stringIntegerHashMap.get(dev);
                result.add(dev+(++x));
                stringIntegerHashMap.put(dev, x);
            } else {
                result.add(dev);
                stringIntegerHashMap.put(dev, 0);
            }
//            if(stringIntegerHashMap.containsKey(dev)){
//                int x = stringIntegerHashMap.get(dev);
//                stringIntegerHashMap.put(dev, x + 1);
//            } else {
//                stringIntegerHashMap.put(dev, 0);
//            }
//            stringIntegerHashMap.merge(dev, 1, Integer::sum);
            stringIntegerHashMap.merge(dev, 1, new BiFunction<Integer, Integer, Integer>() {
                @Override
                public Integer apply(Integer integer, Integer integer2) {
                    return null;
                }
            });
        }
        return stringIntegerHashMap.entrySet().stream()
                .map(stringIntegerEntry -> {
                    Integer value = stringIntegerEntry.getValue();
                    if (--value == 0) {
                        return stringIntegerEntry.getKey();
                    }
                    return stringIntegerEntry.getKey()+value;
                }).collect(toList());

    }

}
