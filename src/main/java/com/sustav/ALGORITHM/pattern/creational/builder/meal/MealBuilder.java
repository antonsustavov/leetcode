package com.sustav.ALGORITHM.pattern.creational.builder.meal;

public abstract class MealBuilder {

    public abstract void addBread();
    public abstract void addCurry();
    public abstract void addColdDrink();
    public abstract Meal build();

}
