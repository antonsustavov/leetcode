package com.sustav.ALGORITHM.pattern.behavioral.command;

public class OpenFile implements TextFileOperation {

    private TextFile textFile;

    public OpenFile(TextFile textFile) {
        this.textFile = textFile;
    }

    @Override
    public String execute() {
        return textFile.open();
    }
}
