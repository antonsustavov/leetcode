package com.sustav.ALGORITHM.pattern.behavioral.command;

@FunctionalInterface
public interface TextFileOperation {
    String execute();

    default void doing() {
        System.out.println("Default method");
    }
}
