package com.sustav.ALGORITHM.challenges.leetcode.structure.queue;

import java.util.Iterator;
import java.util.LinkedList;

public class QueueLinkedListBased<T> implements Iterable<T> {
    private LinkedList<T> list = new LinkedList<>();

    public QueueLinkedListBased() {
    }

    public QueueLinkedListBased(T element) {
        offer(element);
    }

    public int size() {
        return list.size();
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public T peek() {
        if (isEmpty()) throw new RuntimeException("Empty queue");
        return list.peekFirst();
    }

    public T poll() {
        if (isEmpty()) throw new RuntimeException("Empty queue");
        return list.removeFirst();
    }

    @Override
    public Iterator<T> iterator() {
        return list.iterator();
    }

    public void offer(T element) {
        list.addLast(element);
    }
}
