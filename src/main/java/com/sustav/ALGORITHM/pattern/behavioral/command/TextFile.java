package com.sustav.ALGORITHM.pattern.behavioral.command;

public class TextFile {

    private String name;

    public TextFile(String name) {
        this.name = name;
    }

    public String open() {
        return "Openig" + name;
    }

    public String save() {
        return "Saving" + name;
    }
}
