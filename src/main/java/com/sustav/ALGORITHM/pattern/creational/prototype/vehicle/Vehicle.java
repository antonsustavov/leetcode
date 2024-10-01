package com.sustav.ALGORITHM.pattern.creational.prototype.vehicle;

import java.math.BigDecimal;

public abstract class Vehicle implements Cloneable {
    private String engine;
    private String model;
    private BigDecimal price;

    public Vehicle(String engine, String model, BigDecimal price) {
        this.engine = engine;
        this.model = model;
        this.price = price;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Vehicle clone() throws CloneNotSupportedException {
        return (Vehicle) super.clone();
    }
}
