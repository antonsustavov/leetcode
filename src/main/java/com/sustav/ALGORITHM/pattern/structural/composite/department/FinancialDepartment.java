package com.sustav.ALGORITHM.pattern.structural.composite.department;

public class FinancialDepartment implements Department {
    private String name;
    private Integer id;

    public FinancialDepartment(String name, Integer id) {
        this.name = name;
        this.id = id;
    }

    @Override
    public void printDepartmentName() {
        System.out.println(getClass().getName());
    }
}
