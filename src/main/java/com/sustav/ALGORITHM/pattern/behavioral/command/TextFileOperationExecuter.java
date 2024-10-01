package com.sustav.ALGORITHM.pattern.behavioral.command;

import java.util.ArrayList;
import java.util.List;

public class TextFileOperationExecuter {
    private final List<TextFileOperation> operations = new ArrayList<>();

    public String executeOperation(TextFileOperation operation) {
        operations.add(operation);
        return operation.execute();
    }
}
