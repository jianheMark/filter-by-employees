package dev.danvega;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Application {

    public static void main(String[] args) {

        List<Employee> employees = new ArrayList<>();

        // Employee 1
        Employee jasmine = new Employee(1,
                "Jasmine",
                "jasmine@gmail.com",
                Department.ENGINEERING,
                List.of(new Asset("MacBook Pro 13 inch",Type.LAPTOP),new Asset("24 Asus Monitor",Type.MONITOR)));
        employees.add(jasmine);

        // Employee 2
        Employee marcus = new Employee(1,
                "Marcus",
                "marcus@gmail.com",
                Department.SALES,
                List.of(new Asset("Surface Book 3",Type.LAPTOP),new Asset("Herman Miller Aeron Chair",Type.CHAIR)));
        employees.add(marcus);

        // Employee 3
        Employee marcus_b = new Employee(1,
                "Marcus B",
                "marcus@gmail.com",
                Department.ENGINEERING,
                List.of(new Asset("MacBookPro 16",Type.LAPTOP),new Asset("34 Widescren Monitor",Type.MONITOR)));
        employees.add(marcus_b);

        System.out.println("All Employees");
        System.out.println(employees);
        System.out.println();

        System.out.println("Filtered Employees");

        // any time you find yourself iterating over a list to create a new list there is a better way
        List<Employee> filteredEmployees = new ArrayList<>();
        for(Employee employee : employees) {
            if( employee.getName().toLowerCase().equals("marcus") && employee.getDepartment().equals(Department.ENGINEERING)) {
                filteredEmployees.add(employee);
            }
        }

        employees.stream()
                .filter(employee -> employee.getName().toLowerCase().equals("marcus"))
                .filter(employee -> employee.getDepartment().equals(Department.ENGINEERING))
                .forEach(System.out::println);

        employees.stream()
                .filter(employee -> employee.getName().toLowerCase().startsWith("marcus"))
                .filter(employee -> employee.getAssets().stream().filter(asset -> asset.getType().equals(Type.MONITOR)).count() > 0)
                .forEach(System.out::println);

        // source
        // intermediate operations
        // terminal operations
        List<Employee> engineering = employees.stream()
                .filter(employee -> employee.getDepartment().equals(Department.ENGINEERING))
                .collect(Collectors.toList());
    }
}
