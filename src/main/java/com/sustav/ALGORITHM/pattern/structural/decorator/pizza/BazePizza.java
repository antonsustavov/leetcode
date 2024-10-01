package com.sustav.ALGORITHM.pattern.structural.decorator.pizza;

public class BazePizza implements Pizza {
    @Override
    public String bake() {
        return "Base Pizza";
    }
}
