package com.sustav.ALGORITHM.structures.arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class DynamicArrayDemoTest {
    private DynamicArrayDemo<Integer> dynamicArrayDemo;

    @BeforeEach
    void setUp() {
        dynamicArrayDemo = new DynamicArrayDemo<>();
    }

    @Test
    void add() {
        dynamicArrayDemo.add(1);
        dynamicArrayDemo.add(1);
        dynamicArrayDemo.add(1);
        dynamicArrayDemo.add(1);
        dynamicArrayDemo.add(1);
        dynamicArrayDemo.add(1);
        dynamicArrayDemo.add(1);
        dynamicArrayDemo.add(1);
        dynamicArrayDemo.add(1);
        dynamicArrayDemo.add(1);
        dynamicArrayDemo.add(1);
        dynamicArrayDemo.add(1);
        dynamicArrayDemo.add(1);
        dynamicArrayDemo.add(1);
        dynamicArrayDemo.add(1);
        dynamicArrayDemo.add(1);
        dynamicArrayDemo.add(1);

        assertThat(dynamicArrayDemo.size()).isEqualTo(17);
    }
}