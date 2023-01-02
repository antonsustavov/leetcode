package com.sustav.ALGORITHM.challenges.leetcode.structure.lists;

import java.util.Iterator;

public class DoubleLinkedList<T> implements Iterable<T> {

    private int size = 0;
    private Node<T> head = null;
    private Node<T> tail = null;

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Node<T> curr = head;
            @Override
            public boolean hasNext() {
                return curr != null;
            }

            @Override
            public T next() {
                T data = curr.data;
                curr = curr.next;
                return data;
            }
        };
    }

    public void clear() {
        Node<T> curr = head;
        while (curr != null) {
            Node<T> next = curr.next;
            curr.data = null;
            curr.prev = null;
            curr.next = null;
            curr = next;
        }
        head = tail = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public void addFirst(T element) {
        if (isEmpty()) {
            head = tail = new Node<>(element, null, null);
        } else {
            head.prev =  new Node<>(element, null, head);
            head = head.prev;
        }
        size++;
    }

    public void add(T element) {
        addLast(element);
    }

    public T peekFirst() {
        if (isEmpty()) throw new RuntimeException("Empty linked list");
        return head.data;
    }

    public T peekLast() {
        if (isEmpty()) throw new RuntimeException("Empty linked list");
        return tail.data;
    }

    public T removeFirst() {
        if (isEmpty()) throw new RuntimeException("Empty linked list");
        T data = head.data;
        head = head.next;
        --size;

        if (isEmpty()) {
            tail = null;
        } else {
            head.prev = null;
        }

        return data;
    }

    public T removeLast() {
        if (isEmpty()) throw new RuntimeException("Empty linked list");
        T data = tail.data;
        tail = tail.prev;
        --size;

        if (isEmpty()) {
            head = null;
        } else {
            tail.next = null;
        }

        return data;
    }

    private void addLast(T element) {
        if (isEmpty()) {
            head = tail = new Node<>(element, null, null);
        } else {
            tail.next = new Node<>(element, tail, null);
            tail = tail.next;
        }
        size++;
    }

    public T removeAt(int index) {
        if (index < 0 || index >= size()) throw new IllegalArgumentException();

        int i;
        Node<T> curr;

        if (index < size/2) {
            for (i = 0, curr = head; i != index; i++) {
                curr = head.next;
            }
        } else {
            for (i = size-1, curr = tail; i != index ; i--) {
                curr = tail.prev;
            }
        }

        return remove(curr);
    }

    public boolean remove(Object obj) {
        Node<T> curr = head;
        
        if (obj == null) {
            for (curr = head; curr != null; curr = curr.next) {
                if (curr.data == null) {
                    remove(curr);
                    return true;
                }
            }
        } else {
            for (curr = head; curr != null; curr = curr.next) {
                if (curr.data.equals(obj)) {
                    remove(curr);
                    return true;
                }
            }
        }

        return false;
    }

    public int indexOf(Object obj) {
        int index = 0;
        Node<T> curr = head;

        if (obj == null) {
            for (curr = head; curr != null; curr = curr.next, index++) {
                if (curr.data == null) {
                    return index;
                }
            }
        } else {
            for (curr = head; curr != null; curr = curr.next) {
                if (curr.data.equals(obj)) {
                    return index;
                }
            }
        }

        return -1;
    }

    public boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    private T remove(Node<T> node) {
        if (node.prev == null) removeFirst();
        if (node.next == null) removeLast();

        node.next.prev = node.prev;
        node.prev.next = node.next;

        T data = node.data;

        node.data = null;
        node.prev = node.next = null;

        size--;

        return data;
    }

    private class Node<T> {
        T data;
        Node<T> prev, next;

        public Node(T data, Node<T> prev, Node<T> next) {
            this.data = data;
            this.prev = prev;
            this.next = next;
        }

        @Override
        public String toString() {
            return data.toString();
        }
    }
}
