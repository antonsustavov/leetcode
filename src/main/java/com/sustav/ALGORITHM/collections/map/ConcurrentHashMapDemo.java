package com.sustav.ALGORITHM.collections.map;

import lombok.Value;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ConcurrentHashMapDemo {
//    getOrDefault
//    forEach
//    replaceAll
//    computeIfAbsent
//    computeIfPresent
//    compute
//    merge
//    putIfAbsent
//    remove
//    replace(key, oldValue, newValue)
//    replace(key, value)
    public static void main(String[] args) {
        ConcurrentHashMap<String, Integer> stringIntegerConcurrentHashMap = new ConcurrentHashMap<>(10, 0.75f, 10);

        System.out.println("Before: " + stringIntegerConcurrentHashMap);
//        stringIntegerConcurrentHashMap.computeIfAbsent("2", Maps::getValue);
//        stringIntegerConcurrentHashMap.computeIfAbsent("2", Maps::getValue);
        System.out.println("After: " + stringIntegerConcurrentHashMap);

        stringIntegerConcurrentHashMap.computeIfPresent("2", (k, v) -> v + 2);
        System.out.println("After: " + stringIntegerConcurrentHashMap);

        String str = "1 2 1 3 4 5 5 6";
        Arrays.stream(str.split(" ")).forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                stringIntegerConcurrentHashMap.putIfAbsent(s, 0);
//                stringIntegerConcurrentHashMap.computeIfAbsent(s, key -> 0);
                stringIntegerConcurrentHashMap.computeIfPresent(s, (k, v) -> v + 1);
            }
        });
        stringIntegerConcurrentHashMap.getOrDefault("20", 0);
        System.out.println(stringIntegerConcurrentHashMap);


        /// MERGE

        Map<String, Employee> map1 = new HashMap<>();
        Map<String, Employee> map2 = new HashMap<>();

        Employee employee1 = new Employee(1L, "Henry");
        map1.put(employee1.getName(), employee1);
        Employee employee2 = new Employee(22L, "Annie");
        map1.put(employee2.getName(), employee2);
        Employee employee3 = new Employee(8L, "John");
        map1.put(employee3.getName(), employee3);

        Employee employee4 = new Employee(2L, "George");
        map2.put(employee4.getName(), employee4);
        Employee employee5 = new Employee(3L, "Henry");
        map2.put(employee5.getName(), employee5);

        Map<String, Employee> map3 = new HashMap<>(map2);
        map1.forEach(
                (key, value) -> map3.merge(key, value, (v1, v2) -> new Employee(v1.getId(), v2.getName())));
        System.out.println(map3);

        Map<String, Employee> collect = Stream.concat(map1.entrySet().stream(), map2.entrySet().stream())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (v1, v2) -> new Employee(v1.getId(), v2.getName())));
        System.out.println(collect);

//        Map<Object, Object> collect1 = Stream.concat(map1.entrySet().stream(), map2.entrySet().stream())
//                .collect(Collectors.toMap((Function<Map.Entry<String, Employee>, Object>) stringEmployeeEntry -> stringEmployeeEntry.getKey(),
//                        (Function<Map.Entry<String, Employee>, Object>) stringEmployeeEntry -> stringEmployeeEntry.getValue()));
//        System.out.println(collect1);

        Map<String, Employee> map33 = Stream.of(map1, map2)
                .flatMap(map -> map.entrySet().stream())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (v1, v2) -> new Employee(v1.getId(), v2.getName())));

//        Simple Streaming
        Map<String, Employee> map333 = map2.entrySet()
                .stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (v1, v2) -> new Employee(v1.getId(), v2.getName()),
                        () -> new HashMap<>(map1)));

    }

    private static Integer getValue(String s) {
        return Integer.valueOf(s);
    }
}

@Value
class Employee {

    Long id;
    String name;

}
