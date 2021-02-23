package com.sustav.leetcode.structure.stack;

import java.util.EmptyStackException;

/**
 * @author Anton Sustavov
 * @since 2020/09/14
 */
public class Stack<E> {
    private final Object[] data;
    private int size;
    private int top = -1;

    public Stack(int size) {
        this.size = size;
        data = new Object[size];
    }

    public void push(E element) {
        if (isFull()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        data[++top] = element;
    }

    public E pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return (E) data[top--];
    }

    public E peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return (E) data[top];
    }

    public int size() {
        return top + 1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == size - 1;
    }

}
