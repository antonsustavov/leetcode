package com.sustav.ALGORITHM.challenges.algoexpert.medium.array_of_products;

public class ArrayOfProducts {
    // O(n) - time, O(n) - space
    public int[] arrayOfProductsBest(int[] array) {
        int[] products = new int[array.length];
        int[] leftProducts = new int[array.length];
        int[] rightProducts = new int[array.length];

        int leftProduct = 1;
        for (int i = 0; i < array.length; i++) {
            leftProducts[i] = leftProduct;
            leftProduct *= array[i];
        }

        int rightProduct = 1;
        for (int i = array.length - 1; i >= 0; i--) {
            rightProducts[i] = rightProduct;
            rightProduct *= array[i];
        }

        for (int i = 0; i < array.length; i++) {
            products[i] = leftProducts[i] * rightProducts[i];
        }

        return products;
    }

    // O(n) - time, O(n) - space
    public int[] arrayOfProductsBest2(int[] array) {
        int[] products = new int[array.length];

        int leftProduct = 1;
        for (int i = 0; i < array.length; i++) {
            products[i] = leftProduct;
            leftProduct *= array[i];
        }

        int rightProduct = 1;
        for (int i = array.length - 1; i >= 0; i--) {
            products[i] *= rightProduct;
            rightProduct *= array[i];
        }

        return products;
    }

    // O(n^2) - time, O(n) - space
    public int[] arrayOfProducts(int[] array) {
        int[] result = new int[array.length];
        int product = 1;
        int step = 0;
        int multiplier = 0;

        while (step < array.length) {
            if (step != multiplier) product *= array[multiplier];
            multiplier++;
            if (multiplier == array.length) {
                result[step] = product;
                multiplier = 0;
                product = 1;
                step++;
            }
        }

        return result;
    }

    // O(n^2) - time, O(n) - space
    public int[] arrayOfProductsN(int[] array) {
        int[] result = new int[array.length];
        int pointer = 0;
        int product = 1;

        while (pointer < array.length) {
            int leftIndex = pointer - 1;
            while (leftIndex >= 0) {
                product *= array[leftIndex];
                leftIndex--;
            }

            int rightIndex = pointer + 1;
            while (rightIndex < array.length) {
                product *= array[rightIndex];
                rightIndex++;
            }

            result[pointer] = product;
            product = 1;
            pointer++;
        }

        return result;
    }
}
