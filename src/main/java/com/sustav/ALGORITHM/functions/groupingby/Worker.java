package com.sustav.ALGORITHM.functions.groupingby;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class Worker {
    private String name;
    private int age;
    private int salary;
    private String position;
}
