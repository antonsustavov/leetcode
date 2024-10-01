package com.sustav.ALGORITHM.structures.arrays;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.stream.IntStream;

public class DynamicArrayDemo<T> implements Iterable<T> {
    private T[] array;
    private int length;
    private int capacity;

    public DynamicArrayDemo() {
        this(16);
    }

    public DynamicArrayDemo(Integer capacity) {
        if (capacity < 0) throw new IllegalArgumentException(String.format("Capacity %s couldn't be negative", capacity));
        this.capacity = capacity;
        this.array = (T[]) new Object[capacity];
    }

    public int size() {
        return length;
    }

    public void clear() {
        IntStream.range(0, size()).forEach(idx -> array[idx] = null);
    }

    public boolean add(T element) {
        if (length == capacity) {
            array = arrayCopy(array);
        }
        array[length++] = element;
        return true;
    }

    public void add(int index, T element) {
        if (length == capacity) {
            array = arrayCopy(array);
        }
        array[length++] = element;
    }

    public T get(int index) {
        return null;
    }

    public T set(int index, T element) {
        return null;
    }

    public boolean contains(T element) {
        return false;
    }

    public int indexOf(T element) {
        return 0;
    }

    public void remove(T element) {

    }

    public void insert(int index, T element) {

    }

    public void remove(int index, T element) {

    }

    private T[] arrayCopy(T[] array) {
        capacity = capacity * 2;
        T[] newArray = (T[]) new Object[capacity];
        System.arraycopy(array, 0, newArray, 0, array.length);
        return newArray;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public void forEach(Consumer<? super T> action) {
        Iterable.super.forEach(action);
    }

    @Override
    public Spliterator<T> spliterator() {
        return Iterable.super.spliterator();
    }
}
