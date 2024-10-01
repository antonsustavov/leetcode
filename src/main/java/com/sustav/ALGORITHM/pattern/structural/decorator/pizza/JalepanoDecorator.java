package com.sustav.ALGORITHM.pattern.structural.decorator.pizza;

public class JalepanoDecorator extends PizzaDecorator{

    public JalepanoDecorator(Pizza pizza) {
        super(pizza);
    }

    @Override
    public String bake() {
        return super.bake() + jaleComponent();
    }

    private String jaleComponent() {
        return "Jalle {izza";
    }
}
