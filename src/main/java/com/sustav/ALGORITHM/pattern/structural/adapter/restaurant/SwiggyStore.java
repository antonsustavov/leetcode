package com.sustav.ALGORITHM.pattern.structural.adapter.restaurant;

import java.util.ArrayList;
import java.util.List;

public class SwiggyStore {

    List<Item> items = new ArrayList<>();

    public void addItems(Item item) {
        items.add(item);
    }
}
