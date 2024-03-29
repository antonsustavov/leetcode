package com.sustav.JAVA.multithreading.reactive;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class ReactiveProgramming {
    public static void main(String[] args) {
        // 1. long running asynchronous task
        final CompletableFuture<ArrayList<String>> users = CompletableFuture.supplyAsync(() -> {
            // lookup all students ... this can run for a long time
            sleep(5);
            return new ArrayList<String>(Arrays.asList("John", "Peter", "Sam"));
        });
        // 2. long running asynchronous task
        final CompletableFuture<ArrayList<String>> subjects = CompletableFuture.supplyAsync(() -> {
            // lookup all subjects ... this can run for a long time
            sleep(5);
            return new ArrayList<String>(Arrays.asList("English, Maths, Science"));
        });
        //3 combine //1 & //2 to produce a report synchronously
        final CompletableFuture<String> report = users.thenCombine(subjects, (u, s) -> {
            System.out.println("Thread " + Thread.currentThread().getName() + " is producing a report'" + "");
            return u.toString() + s.toString();
        });
        System.out.println("Before");
        System.out.println(report.join()); // returns a result value when complete
        System.out.println("After");
    }

    private static void sleep(long seconds) {
        try {
            System.out.println("Thread " + Thread.currentThread().getName() + " is processing");
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
