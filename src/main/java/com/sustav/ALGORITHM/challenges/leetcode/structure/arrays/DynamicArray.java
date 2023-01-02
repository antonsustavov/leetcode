package com.sustav.ALGORITHM.challenges.leetcode.structure.arrays;

import java.util.Arrays;
import java.util.Iterator;

@SuppressWarnings("unchecked")
public class DynamicArray<T> implements Iterable<T> {
    private T[] arr;
    private int len = 0;
    private int capacity = 0;

    public DynamicArray() {
        this(16);
    }

    public DynamicArray(int capacity) {
        if (capacity < 0) throw new IllegalArgumentException("Illegal capacity =" + capacity);
        this.capacity = capacity;
        arr = (T[]) new Object[capacity];
    }

    public int size() {
        return len;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public T get(int index) {
        return arr[index];
    }

    public void set(int index, T element) {
        arr[index] = element;
    }

    public void clear() {
        Arrays.fill(arr, null);
        len = 0;
    }

    public void add(T element) {
        if (size() == capacity) {
            increaseArray();
        }
        arr[len++] = element;
    }

    public T removeAt(int index) {
        if (index >= size() || index < 0) throw new IndexOutOfBoundsException("Index out of bound, index = " + index);
        T data = arr[index];
        T[] copyArr = (T[]) new Object[capacity];
        System.arraycopy(arr, 0, copyArr, 0, index);
        System.arraycopy(arr, index + 1, copyArr, index, arr.length - index - 1);
        arr = copyArr;
        len--;

        return data;
    }

    public boolean remove(T obj) {
        for (int i = 0; i < len; i++) {
            if (arr[i].equals(obj)) {
                removeAt(i);
                return true;
            }
        }
        return false;
    }

    public int indexOf(T obj) {
        for (int i = 0; i < len; i++) {
            if (arr[i].equals(obj)) return i;
        }
        return -1;
    }

    public boolean contains(T obj) {
        return indexOf(obj) != -1;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            int index = 0;
            @Override
            public boolean hasNext() {
                return index < len;
            }

            @Override
            public T next() {
                return arr[index++];
            }
        };
    }

    @Override
    public String toString() {
        if (len == 0) return "[]";
        StringBuilder sb = new StringBuilder(len).append("[");
        for (int i = 0; i < len - 1; i++) {
            sb.append(arr[i]).append(", ");
        }
        return sb.append(arr[len - 1]).append("]").toString();
    }

    private void increaseArray() {
        long sum = (long) 2 * (long) capacity;
        if (sum < Integer.MIN_VALUE || sum > Integer.MAX_VALUE) {
            throw new ArithmeticException("Overflow in additional");
        }
        capacity *= 2;
        arr = Arrays.copyOf(arr, capacity);
    }

    public static void main(String[] args) {
        DynamicArray<Integer> integers = new DynamicArray<>(4);
        integers.add(5);
        integers.add(6);
        integers.add(7);
        integers.add(8);
        integers.add(9);
        integers.add(10);
        System.out.println("Origin array: " + integers);
        integers.removeAt(2);
        System.out.println(integers);
    }
}
