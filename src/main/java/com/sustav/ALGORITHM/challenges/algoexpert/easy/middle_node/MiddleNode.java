package com.sustav.ALGORITHM.challenges.algoexpert.easy.middle_node;

import lombok.Getter;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

public class MiddleNode {

    // This is an input class. Do not edit.
    public static class LinkedList {
        public int value;
        public LinkedList next;

        public LinkedList(int value) {
            this.value = value;
            this.next = null;
        }
    }

    // O(n) time, O(1) space
    public LinkedList middleNode(LinkedList linkedList) {
        var currentNode = linkedList;
        var countOfNodes = 0;
        while (currentNode != null) {
            countOfNodes++;
            currentNode = currentNode.next;
        }

        currentNode = linkedList;
        countOfNodes = countOfNodes / 2;

        while (countOfNodes != 0) {
            currentNode = currentNode.next;
            countOfNodes--;
        }

        return currentNode;
    }

    // O(n) time, O(1) space
    public LinkedList middleNode2(LinkedList linkedList) {
        var slowNode = linkedList;
        var fastNode = linkedList;

        while (fastNode != null && fastNode.next != null) {
            slowNode = slowNode.next;
            fastNode = fastNode.next.next;
        }

        return slowNode;
    }

    public enum Day implements Iterable<String> { MON,
        TUE,
        WED,
        THU,
        FRI,
        SAT,
        SUN;

        @Override
        public Iterator<String> iterator() {
            return null;
        }

        @Override
        public void forEach(Consumer<? super String> action) {
            Iterable.super.forEach(action);
        }

        @Override
        public Spliterator<String> spliterator() {
            return Iterable.super.spliterator();
        }
    }

    public enum Month {
        JAN("jan"),
        FEB("feb"),
        MAR("mar"),
        APR("apr"),
        MAY("may"),
        JUN("jun"),
        JULY("july");

        @Getter
        private final String name;

        Month(String name) {
            this.name = name;
        }

        public static void pr(String sss) {
            System.out.println(sss);
        }
    }

    public static void main(String[] args) {

        Day d = null;
        Month ddd = Month.valueOf("FEB");
        Month feb = Month.valueOf(Month.class, "FEB");

        System.out.println(d == Day.MON);
        System.out.println(Day.MON.equals(d));

//        System.out.println(Month.JAN == Day.MON);

        System.out.println(Month.JAN.equals(Day.MON));

    }
}
