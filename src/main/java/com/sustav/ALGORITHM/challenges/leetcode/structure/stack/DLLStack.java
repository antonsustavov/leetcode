package com.sustav.ALGORITHM.challenges.leetcode.structure.stack;

import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.LinkedList;

public class DLLStack<T> implements Iterable<T> {
    private LinkedList<T> list = new LinkedList<>();

    public DLLStack() {}

    public DLLStack(T element) {
        push(element);
    }

    public void push(T element) {
        list.addLast(element);
    }

    public T pop() {
        if (isEmpty()) throw new EmptyStackException();
        return list.removeLast();
    }

    public T peek() {
        if (isEmpty()) throw new EmptyStackException();
        return list.peekLast();
    }

    public int size() {
        return list.size();
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public Iterator<T> iterator() {
        return list.iterator();
    }
}
