package com.sustav.ALGORITHM.interfaces;

public class CustomInterfaceMain {
    public static void main(String[] args) {
        String strNum = CustomFuncInterface.STR_NUM;

        CustomFuncInterface inter = System.out::println;

        inter.process(5);
        System.out.println(inter.calculate(8));
    }
}
