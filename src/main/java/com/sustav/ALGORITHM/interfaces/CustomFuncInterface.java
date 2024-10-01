package com.sustav.ALGORITHM.interfaces;

@FunctionalInterface
public interface CustomFuncInterface {
    void process(Integer num);

    default Integer calculate(Integer num) {
        return num * 8;
    }

    static Integer calculateStatic(Integer num) {
        return num * 9;
    }

    public final String STR_NUM = "5";
}
