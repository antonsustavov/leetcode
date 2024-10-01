package com.sustav.ALGORITHM.pattern.structural.composite.department;

public class SalesDepartment implements Department {
    private String name;
    private Integer id;

    public SalesDepartment(String name, Integer id) {
        this.name = name;
        this.id = id;
    }

    @Override
    public void printDepartmentName() {
        System.out.println(getClass().getName());
    }
}
