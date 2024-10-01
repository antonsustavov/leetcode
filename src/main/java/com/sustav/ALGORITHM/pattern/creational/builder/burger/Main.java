package com.sustav.ALGORITHM.pattern.creational.builder.burger;

public class Main {
    public static void main(String[] args) {
        Burger large = new Burger.BurgerBuilder()
                .size("LARGE")
                .egg(true)
                .lettuce(true)
                .build();
    }
}
