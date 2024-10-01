package com.sustav.ALGORITHM.pattern.structural.composite.department;

import java.util.ArrayList;
import java.util.List;

public class HeadDepartment implements Department {
    private String name;
    private Integer id;
    private List<Department> departments;

    public HeadDepartment(String name, Integer id) {
        this.name = name;
        this.id = id;
        this.departments = new ArrayList<>();
    }

    public void addDepartment(Department department) {
        departments.add(department);
    }

    public void removeDepartment(Department department) {
        departments.remove(department);
    }

    @Override
    public void printDepartmentName() {
        departments.forEach(Department::printDepartmentName);
    }
}
