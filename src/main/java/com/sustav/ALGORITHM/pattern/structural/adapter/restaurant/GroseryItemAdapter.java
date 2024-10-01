package com.sustav.ALGORITHM.pattern.structural.adapter.restaurant;

public class GroseryItemAdapter implements Item {
    private GroseryItem item;

    public GroseryItemAdapter(GroseryItem item) {
        this.item = item;
    }

    @Override
    public String getItemName() {
        return item.getItemName();
    }

    @Override
    public String getPrice() {
        return item.getPrice();
    }

    @Override
    public String getRestaurantName() {
        return item.getStoreName();
    }
}
