package com.sustav.ALGORITHM.pattern.creational.abstruct_factory.application;

import com.sustav.ALGORITHM.pattern.creational.abstruct_factory.application.os.MacButton;
import com.sustav.ALGORITHM.pattern.creational.abstruct_factory.application.os.MacCheckbox;

public class MacUiFactory implements UIFactory {
    @Override
    public Button createButton() {
        return new MacButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new MacCheckbox();
    }
}
