package com.sustav.ALGORITHM.pattern.creational.prototype.car;

public class Car implements Prototype {
    private String brand;
    private Integer speed;

    public Car(Car car) {
        this.brand = car.brand;
        this.speed = car.speed;
    }

    public Car() {

    }

    @Override
    public Car clone() {
        return new Car(this);
    }
}
