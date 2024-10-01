package com.sustav.ALGORITHM.pattern.creational.builder.meal;

public class Main {
    public static void main(String[] args) {
        Meal meal = new MealDirector(new NonVegMealBuilder()).prepareMeal();
    }
}
