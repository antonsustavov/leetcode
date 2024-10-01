package com.sustav.ALGORITHM.functions.groupingby;

import com.github.javafaker.Faker;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class GroupingByExamples {
    public static void main(String[] args) {
        Faker faker = new Faker();
        List<Worker> workers = IntStream.rangeClosed(1, 30)
                .mapToObj(num -> toWorker(faker))
                .toList();

//        1. Группировка списка рабочих по их должности (деление на списки)
        var groupByPosition = workers.stream()
                .collect(Collectors.groupingBy(Worker::getPosition));
        System.out.println(groupByPosition);

//        2. Группировка списка рабочих по их должности (деление на множества)
        var groupByPositionSet = workers.stream()
                .collect(Collectors.groupingBy(Worker::getPosition, Collectors.toSet()));
        System.out.println(groupByPositionSet);

//        3. Подсчет количества рабочих, занимаемых конкретную должность
        var groupByPositionCounting = workers.stream()
                .collect(Collectors.groupingBy(Worker::getPosition, Collectors.counting()));
        var groupByPositionCountingIdentity = workers.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(groupByPositionSet);

//        4. Группировка списка рабочих по их должности, при этом нас интересуют только имена
        Map<String, Set<String>> map4 = workers.stream()
                .collect(Collectors.groupingBy(Worker::getPosition,
                        Collectors.mapping(Worker::getName, Collectors.toSet())));

//        5. Расчет средней зарплаты для данной должности
        var groupByPositionSalary = workers.stream()
                .collect(Collectors.groupingBy(Worker::getPosition,
                        Collectors.averagingInt(Worker::getSalary)));
        System.out.println(groupByPositionSalary);


//        6. Группировка списка рабочих по их должности, рабочие представлены только именами единой строкой
        var groupingMapByName = workers.stream()
                .collect(Collectors.groupingBy(Worker::getPosition,
                        Collectors.mapping(Worker::getName,
                                Collectors.joining(", ", "{","}")))
                );
        System.out.println(groupingMapByName);

//        7. Группировка списка рабочих по их должности и по возрасту.
        var groupingByPositionAge = workers.stream()
                .collect(Collectors.groupingBy(Worker::getPosition,
                        Collectors.groupingBy(Worker::getAge)));
        System.out.println(groupingByPositionAge);

        LinkedList<Integer> integers = new LinkedList<>();
        integers.addLast(23);

        process(workers.stream());

        TreeMap<String, Integer> stringIntegerTreeMap = new TreeMap<>();
        TreeSet<String> strings = new TreeSet<>();
        strings.add("ddd");
    }

    private static void process(Stream<Worker> stream) {

        Map<String, Map<Integer, List<Worker>>> collect = stream.collect(Collectors.groupingBy(Worker::getPosition,
                Collectors.groupingBy(Worker::getAge)));

//        var groupByPosition = stream
//                .collect(Collectors.groupingBy(Worker::getPosition));
//        System.out.println(groupByPosition);

    }

    private static Worker toWorker(Faker faker) {
        return Worker.builder()
                .name(faker.name().name())
                .age(faker.address().buildingNumber().length())
                .position(faker.book().title())
                .salary(faker.book().title().length())
                .build();
    }
}
