package com.sustav.ALGORITHM.challenges.leetcode.structure.queue;

import lombok.extern.slf4j.Slf4j;

import java.util.*;

@Slf4j
public class PQueue<T extends Comparable<T>> {
    // number of element currently inside heap
    private int heapSize = 0;
    //internal capacity of heap
    private int heapCapacity = 0;

    private List<T> heap;
    private Map<T, TreeSet<Integer>> map = new HashMap<>();

    public PQueue() {
        this(1);
    }

    public PQueue(int heapSize) {
        heap = new ArrayList<>(heapSize);
    }

    public PQueue(T[] elements) {
        heapSize = heapCapacity = elements.length;
        heap = new ArrayList<>(heapCapacity);

        // place elements in heap
        for (int i = 0; i < heapSize; i++) {
            mapAdd(elements[i], i);
            heap.add(elements[i]);
        }

        // heapify process O(n)
        for (int i = Math.max(0, heapSize / 2 - 1); i >= 0; i--) {
            sink(i);
        }

    }

    // priority queue constructor O(nlog(n))
    public PQueue(Collection<T> elements) {
        this(elements.size());
        for (T element : elements) {
            add(element);
        }
    }

    public boolean isEmpty() {
        return heapSize == 0;
    }

    public void clear() {
        for (int i = 0; i < heapCapacity; i++) {
            heap.set(i, null);
        }
        heapSize = 0;
        map.clear();
    }

    public int size() {
        return heapSize;
    }

    public T peek() {
        if (isEmpty()) return null;
        return heap.get(0);
    }

    public T poll() {
        return removeAt(0);
    }

    public boolean contains(T element) {
        if (element == null) return false;
        return map.containsKey(element);

//        for (int i = 0; i < heapSize; i++) {
//            if (heap.get(i).equals(element)) return true;
//            return false;
//        }
    }

    public void add(T element) {
        if (element == null) throw new IllegalArgumentException();

        if (heapSize < heapCapacity) {
            heap.set(heapSize, element);
        } else {
            heap.add(element);
            heapCapacity++;
        }

        mapAdd(element, heapSize);

        swim(heapSize);
        heapSize++;
    }

    public boolean remove(T element) {
        if (element == null) return false;

//        for (int i = 0; i < heapSize; i++) {
//            if (element.equals(heap.get(i))) {
//                removeAt(i);
//                return true;
//            }
//        }

        Integer index = mapGet(element);
        if (index != null) removeAt(index);

        return index != null;
    }

    @Override
    public String toString() {
        return heap.toString();
    }

    public boolean isMinHeap(int k) {
        if (k >= heapSize) return true;

        int left = 2 * k + 1;
        int right = 2 * k + 2;

        if (left < heapSize && !less(k, left)) return false;
        if (right < heapSize && !less(k, right)) return false;

        return isMinHeap(left) && isMinHeap(right);
    }

    private void mapAdd(T value, int index) {
        TreeSet<Integer> set = map.get(value);

        if (set == null) {
            set = new TreeSet<>();
            set.add(index);
            map.put(value, set);
        } else {
            set.add(index);
        }
    }

    private void mapRemove(T value, int index) {
        TreeSet<Integer> set = map.get(value);
        set.remove(index);
        if (set.size() == 0) map.remove(value);
    }

    private Integer mapGet(T value) {
        TreeSet<Integer> set = map.get(value);
        if (set != null) return set.last();
        return null;
    }

    private void mapSwap(T valFirst, T valSecond, int indexFirst, int indexSecond) {
        TreeSet<Integer> setFirst = map.get(valFirst);
        TreeSet<Integer> setSecond = map.get(valSecond);

        setFirst.remove(indexFirst);
        setSecond.remove(indexSecond);

        setFirst.add(indexSecond);
        setSecond.add(indexFirst);
    }

    private boolean less(int firstElem, int secondElem) {
        T firstNode = heap.get(firstElem);
        T secondNode = heap.get(secondElem);

        return firstNode.compareTo(secondNode) <= 0;
    }

    private T removeAt(int index) {
        if (isEmpty()) return null;

        heapSize--;
        T removedElement = heap.get(index);
        swap(index, heapSize);
        heap.set(heapSize, null);
        mapRemove(removedElement, heapSize);

        if (index == heapSize) return removedElement;

        T element = heap.get(index);

        sink(index);

        if (heap.get(index).equals(element)) {
            swim(index);
        }

        return removedElement;
    }

    private void swim(int k) {
        int parent = (k - 1) / 2;

        while (k > 0 && less(k, parent)) {
            swap(parent, k);
            k = parent;

            parent = (k - 1) / 2;
        }
    }

    private void sink(int k) {
        while (true) {
            int left = 2 * k + 1;
            int right = 2 * k + 2;
            int smallest = left;

            if (right < heapSize && less(right, left)) {
                smallest = right;
            }

            if (left > heapSize || less(k, smallest)) {
                break;
            }

            swap(smallest, k);
            k = smallest;
        }
    }

    private void swap(int firstElemIndex, int secondElemIndex) {
        T firstElement = heap.get(firstElemIndex);
        T secondElement = heap.get(secondElemIndex);

        heap.set(firstElemIndex, secondElement);
        heap.set(secondElemIndex, firstElement);

        mapSwap(firstElement, secondElement, firstElemIndex, secondElemIndex);
    }

    public static void main(String[] args) {
        var tpQueue = new PQueue<Integer>(2);
        log.info("heapcapacity: {}", tpQueue.heapCapacity);
        log.info("heapsize: {}", tpQueue.heapSize);
        log.info("size: {}", tpQueue.size());
        log.info("heap: {}", tpQueue.heap);
        log.info("poll: {}", tpQueue.poll());
        tpQueue.add(50);
        tpQueue.add(60);
        tpQueue.add(10);
        log.info("{}", tpQueue.peek());
        tpQueue.poll();
    }
}
