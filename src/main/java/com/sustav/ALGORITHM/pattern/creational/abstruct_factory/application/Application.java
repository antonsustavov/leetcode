package com.sustav.ALGORITHM.pattern.creational.abstruct_factory.application;

public class Application {
    private Button button;
    private Checkbox checkbox;

    public Application(UIFactory factory) {
        this.button = factory.createButton();
        this.checkbox = factory.createCheckbox();;
    }

    public void paint() {
        button.paint();
        checkbox.paint();
    }
}
