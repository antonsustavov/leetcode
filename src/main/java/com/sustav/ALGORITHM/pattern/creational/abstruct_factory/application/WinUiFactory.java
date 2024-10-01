package com.sustav.ALGORITHM.pattern.creational.abstruct_factory.application;

import com.sustav.ALGORITHM.pattern.creational.abstruct_factory.application.os.WinButton;
import com.sustav.ALGORITHM.pattern.creational.abstruct_factory.application.os.WinCheckbox;

public class WinUiFactory implements UIFactory {
    @Override
    public Button createButton() {
        return new WinButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new WinCheckbox();
    }
}
