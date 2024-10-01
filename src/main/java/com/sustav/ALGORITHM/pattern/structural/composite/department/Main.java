package com.sustav.ALGORITHM.pattern.structural.composite.department;

public class Main {
    public static void main(String[] args) {
        Department moner = new FinancialDepartment("moner", 1 );
        Department sales = new SalesDepartment("sales", 1 );

        HeadDepartment head = new HeadDepartment("head", 3);
        head.addDepartment(moner);
        head.addDepartment(sales);

        head.printDepartmentName();
    }
}
