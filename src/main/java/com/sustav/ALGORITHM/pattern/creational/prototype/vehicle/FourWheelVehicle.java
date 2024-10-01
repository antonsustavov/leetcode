package com.sustav.ALGORITHM.pattern.creational.prototype.vehicle;

import java.math.BigDecimal;

public class FourWheelVehicle extends Vehicle {

    private Boolean isDiesel;
    private Boolean automatic;

    public FourWheelVehicle(String engine, String model, BigDecimal price, Boolean isDiesel, Boolean automatic) {
        super(engine, model, price);
        this.isDiesel = isDiesel;
        this.automatic = automatic;
    }

    public FourWheelVehicle clone() throws CloneNotSupportedException {
        return (FourWheelVehicle) super.clone();
    }
}
