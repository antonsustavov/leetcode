package com.sustav.leetcode.structure.priority_queue;

import java.util.Comparator;
import java.util.NoSuchElementException;

/**
 * @author Anton Sustavov
 * @since 2020/09/17
 */
public class PriorityQueue<E> {
    private Object[] innerArray;
    private int size;
    private int capacity;
    private transient Comparator<? super E> comparator;

    public PriorityQueue(int capacity) {
        this(capacity, null);
    }

    public PriorityQueue(int capacity, Comparator<? super E> comparator) {
        this.innerArray = new Object[capacity];
        this.comparator = comparator;
        this.capacity = capacity;
        size = 0;
    }

    public void enqueue(E item) {
        if (size == 0) {
            innerArray[0] = item;
            size++;
            return;
        }

        if (isFull()) {
            throw new ArrayIndexOutOfBoundsException();
        }

        Comparator<? super E> cmp;
        E temp = item;
        if ((cmp = comparator) == null) {
            Comparable<? super E> key = (Comparable<? super E>) temp;
            for (int i = 0; i < size; i++) {
                E next;
                if (key.compareTo((E) innerArray[i]) <= 0) {
                    temp = (E) innerArray[i];
                    innerArray[i] = item;
                    while (i < size - 1) {
                        next = (E) innerArray[i + 1];
                        innerArray[i + 1] = temp;
                        temp = next;
                        i++;
                    }
                    break;
                }
            }
        }else {
            for (int i = 0; i < size; i++) {
                E next;
                if (cmp.compare(item, (E) innerArray[i]) <= 0) {
                    temp = (E) innerArray[i];
                    innerArray[i] = item;
                    while (i < size - 1) {
                        next = (E) innerArray[i + 1];
                        innerArray[i + 1] = temp;
                        temp = next;
                        i++;
                    }
                    break;
                }
            }
            
        }
        innerArray[size] = temp;
        size++;
    }

    public E dequeue() {
        if (isEmpty())
            throw new NoSuchElementException("The queue is empty");

        // Storing first int for return
        E retValue = (E) innerArray[0];
        // Shifting all values downwards
        for (int i = 1; i < size; i++) {
            innerArray[i - 1] = innerArray[i];
        }

        innerArray[size - 1] = null;
        size--;

        return retValue;
    }

    public E peek() {
        if (isEmpty())
            throw new NoSuchElementException("The queue is empty");
        return (E) innerArray[0];
    }

    public boolean contains(E item) {
        // Check for empty.
        if (isEmpty())
            return false;
        // Looping through the positions which contains inserted values,
        // ignoring trailing default 0 values.
        Comparator<? super E> cmp;
        if ((cmp = comparator) == null) {
            Comparable<? super E> key = (Comparable<? super E>) item;
            for (int i = 0; i < size; i++) {
                // Comparing
                if (key.compareTo((E) innerArray[i]) == 0) {
                    return true;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (cmp.compare(item, (E) innerArray[i]) == 0) {
                    return true;
                }
            }
        }

        // None found
        return false;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }

    public int size() {
        return size;
    }

    private void doubleArray() {
    }
}
