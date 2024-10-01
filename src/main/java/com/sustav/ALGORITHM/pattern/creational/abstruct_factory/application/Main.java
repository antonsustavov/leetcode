package com.sustav.ALGORITHM.pattern.creational.abstruct_factory.application;

public class Main {
    public static void main(String[] args) {
        Application application = new Application(new MacUiFactory());
        application.paint();
    }
}
