package com.sustav.leetcode.structure.queue;

import java.util.EmptyStackException;
import java.util.NoSuchElementException;

/**
 * @author Anton Sustavov
 * @since 2020/09/17
 */
public class Queue<E> {
    private Object[] data;
    private int front;
    private int rear;
    private int capacity;
    private int count;

    public Queue(int size) {
       data = new Object[size];
       capacity = size;
       rear = -1;
       front = 0;
       count = 0;
    }

    public E dequeue() {
        if (isEmpty()) throw new EmptyStackException();
        E item = (E) data[front];
//        front = (front + 1) % capacity;
        front++;
        count--;
        return item;
    }

    public void enqueue(E item) {
        if (isFull()) throw new StringIndexOutOfBoundsException();
//        rear = (rear + 1) % capacity;
        rear++;
        data[rear] = item;
        count++;
    }

    public E peek() {
        if (isEmpty()) throw new NoSuchElementException();
        return (E) data[front];
    }

    public int size() {
        return count;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public boolean isFull() {
        return size() == capacity;
    }
}
