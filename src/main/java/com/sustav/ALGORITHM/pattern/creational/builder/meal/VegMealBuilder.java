package com.sustav.ALGORITHM.pattern.creational.builder.meal;

public class VegMealBuilder extends MealBuilder {
    private Meal meal;

    public VegMealBuilder() {
        this.meal = new Meal();
    }

    @Override
    public void addBread() {
        this.meal.setBread("Bread");
    }

    @Override
    public void addCurry() {
        this.meal.setCurry("Currt");
    }

    @Override
    public void addColdDrink() {
        this.meal.setColdDrink("Colla");
    }

    @Override
    public Meal build() {
        return meal;
    }
}
