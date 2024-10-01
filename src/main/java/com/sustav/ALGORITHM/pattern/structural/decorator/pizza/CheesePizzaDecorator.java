package com.sustav.ALGORITHM.pattern.structural.decorator.pizza;

public class CheesePizzaDecorator extends PizzaDecorator{

    public CheesePizzaDecorator(Pizza pizza) {
        super(pizza);
    }

    @Override
    public String bake() {
        return super.bake() + addCheese();
    }

    private String addCheese() {
        return "Cheese";
    }
}
