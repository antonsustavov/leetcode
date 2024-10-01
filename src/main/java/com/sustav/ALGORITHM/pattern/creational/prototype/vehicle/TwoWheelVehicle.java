package com.sustav.ALGORITHM.pattern.creational.prototype.vehicle;

import java.math.BigDecimal;

public class TwoWheelVehicle extends Vehicle {

    private Boolean isElectric;

    public TwoWheelVehicle(String engine, String model, BigDecimal price, Boolean isElectric) {
        super(engine, model, price);
        this.isElectric = isElectric;
    }
}
