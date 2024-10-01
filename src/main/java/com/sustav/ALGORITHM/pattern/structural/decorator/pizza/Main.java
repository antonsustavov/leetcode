package com.sustav.ALGORITHM.pattern.structural.decorator.pizza;

public class Main {
    public static void main(String[] args) {
        JalepanoDecorator jalepanoDecorator = new JalepanoDecorator(new CheesePizzaDecorator(new BazePizza()));
        System.out.println(jalepanoDecorator.bake());
    }
}
