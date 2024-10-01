package com.sustav.ALGORITHM.challenges.algoexpert.medium.array_of_products;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ArrayOfProductsTest {
    private ArrayOfProducts arrayOfProducts;

    @BeforeEach
    void setUp() {
        arrayOfProducts = new ArrayOfProducts();
    }

    @Test
    void arrayOfProducts() {
        int[] given = {5, 1, 4, 2};
        int[] expected = {8, 40, 10, 20};

        int[] actual = arrayOfProducts.arrayOfProducts(given);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void arrayOfProductsN() {
        int[] given = {5, 1, 4, 2};
        int[] expected = {8, 40, 10, 20};

        int[] actual = arrayOfProducts.arrayOfProductsN(given);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void arrayOfProductsBest() {
        int[] given = {5, 1, 4, 2};
        int[] expected = {8, 40, 10, 20};

        int[] actual = arrayOfProducts.arrayOfProductsBest(given);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void arrayOfProductsBest2() {
        int[] given = {5, 1, 4, 2};
        int[] expected = {8, 40, 10, 20};

        int[] actual = arrayOfProducts.arrayOfProductsBest2(given);

        assertThat(actual).isEqualTo(expected);
    }
}