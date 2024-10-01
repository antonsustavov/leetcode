package com.sustav.ALGORITHM.pattern.creational.abstruct_method;

public class AbstractMethod {
    public static void main(String[] args) {
        Restaurant beefBurgerRestaurant = new BeefBurgerRestaurant();
        Burger burger = beefBurgerRestaurant.orderBurger();

        Restaurant veggieBurgerRestaurant = new VeggieBurgerRestaurant();
        Burger burger2 = veggieBurgerRestaurant.orderBurger();
    }
}
