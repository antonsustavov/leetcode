package com.sustav.ALGORITHM.pattern.creational.abstruct_method;

public class BeefBurgerRestaurant extends Restaurant {
    @Override
    public Burger createBurger() {
        return new BeefBurger();
    }
}
