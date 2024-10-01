package com.sustav.ALGORITHM.pattern.creational.abstruct_method;

public class VeggieBurgerRestaurant extends Restaurant {
    @Override
    public Burger createBurger() {
        return new VeggieBurger();
    }
}
