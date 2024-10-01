package com.sustav.ALGORITHM.pattern.structural.adapter.restaurant;

public class Main {
    public static void main(String[] args) {
        SwiggyStore swiggyStore = new SwiggyStore();
        swiggyStore.addItems(new FoodItem());
        swiggyStore.addItems(new FoodItem());

        swiggyStore.addItems(new GroseryItemAdapter(new GroseryProduct()));
    }
}
