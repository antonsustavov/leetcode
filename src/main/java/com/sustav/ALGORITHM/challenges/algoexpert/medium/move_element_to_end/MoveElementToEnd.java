package com.sustav.ALGORITHM.challenges.algoexpert.medium.move_element_to_end;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import static java.util.Collections.swap;

public class MoveElementToEnd {
    // O(n) - time, O(1) - space
    public List<Integer> moveElementToEndSwap(List<Integer> array, int toMove) {
        int leftPointer = 0;
        int rightPointer = array.size() - 1;
        while (leftPointer < rightPointer) {
            if (array.get(rightPointer) == toMove) {
                rightPointer--;
            } else if (array.get(leftPointer) == toMove) {
                swap(array, leftPointer, rightPointer);
                rightPointer--;
                leftPointer++;
            } else {
                leftPointer++;
            }
        }
        return array;
    }

    public List<Integer> moveElementToEndSwap2(List<Integer> array, int toMove) {
        int leftPointer = 0;
        int rightPointer = array.size() - 1;
        while (leftPointer < rightPointer) {
            while (leftPointer < rightPointer && array.get(rightPointer) == toMove) {
                rightPointer--;
            }
            if (array.get(leftPointer) == toMove) {
                swap(array, leftPointer, rightPointer);
            }
            leftPointer++;

        }
        return array;
    }

    public List<Integer> moveElementToEndCopyOnWriteArrayList(List<Integer> array, int toMove) {
        int lastIdx = array.size() - 1;
        CopyOnWriteArrayList<Integer> cp = new CopyOnWriteArrayList<>(array);
        for (Integer element : cp) {
            int currentIdx = cp.indexOf(element);
            if (currentIdx == lastIdx) {
                break;
            }
            if (element.equals(toMove)) {
                cp.add(element);
                cp.remove(currentIdx);
            }
        }
        return cp;
    }

    public List<Integer> moveElementToEndCopyOnWriteArrayList2(List<Integer> array, int toMove) {
        CopyOnWriteArrayList<Integer> cp = new CopyOnWriteArrayList<>(array);
        for (Integer element : cp) {
            int currentIdx = cp.indexOf(element);
            if (element.equals(toMove)) {
                cp.add(element);
                cp.remove(currentIdx);
            }
        }
        return cp;
    }
}
