package com.sustav.ALGORITHM.pattern.creational.builder.meal;

public class MealDirector {
    private MealBuilder mealBuilder;

    public MealDirector(MealBuilder mealBuilder) {
        this.mealBuilder = mealBuilder;
    }

    public Meal prepareMeal() {
        this.mealBuilder.addCurry();
        this.mealBuilder.addBread();
        this.mealBuilder.addColdDrink();

        return mealBuilder.build();
    }
}
