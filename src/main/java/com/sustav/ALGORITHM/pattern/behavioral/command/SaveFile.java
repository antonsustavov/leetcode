package com.sustav.ALGORITHM.pattern.behavioral.command;

public class SaveFile implements TextFileOperation {

    private TextFile textFile;

    public SaveFile(TextFile textFile) {
        this.textFile = textFile;
    }

    @Override
    public String execute() {
        return textFile.save();
    }
}
