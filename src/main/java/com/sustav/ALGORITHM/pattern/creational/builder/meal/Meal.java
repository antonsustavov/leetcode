package com.sustav.ALGORITHM.pattern.creational.builder.meal;

public class Meal {
    private String curry;
    private String bread;
    private String coldDrink;

    public void setCurry(String curry) {
        this.curry = curry;
    }

    public void setBread(String bread) {
        this.bread = bread;
    }

    public void setColdDrink(String coldDrink) {
        this.coldDrink = coldDrink;
    }

    public String getCurry() {
        return curry;
    }

    public String getBread() {
        return bread;
    }

    public String getColdDrink() {
        return coldDrink;
    }
}
