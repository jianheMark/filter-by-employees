package jian.he;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Application {

    public static void main(String[] args) {

        List<Employee> employees = new ArrayList<>();

        // Employee 1
        Employee jian = new Employee(1,
                "jian",
                "jian@gmail.com",
                Department.FINANCE,
                List.of(new Asset("MacBook",Type.LAPTOP),
                        new Asset("24 Asus Monitor",Type.MONITOR),
                        new Asset("HK Gaming KeyBoard",Type.KEYBOARD)));
        employees.add(jian);

        // Employee 2
        Employee he = new Employee(1,
                "he",
                "he@gmail.com",
                Department.SALES,
                List.of(new Asset("Surface",Type.LAPTOP),new Asset("IKEA Chair",Type.CHAIR),new Asset("NA mouse",Type.MOUSE)));
        employees.add(he);

        // Employee 3
        Employee eliane = new Employee(1,
                "elaine",
                "elaine@gmail.com",
                Department.ENGINEERING,
                List.of(new Asset("MacBookPro 16",Type.LAPTOP),new Asset("24 Lenovo Monitor",Type.MONITOR)));
        employees.add(eliane);

        System.out.println("All Employees");
        System.out.println("Total we have "+employees.size());

        System.out.println("Filtered Employees...........");

        // any time you find yourself iterating over a list to create a new list there is a better way
//        List<Employee> filteredEmployees = new ArrayList<>();
//        for(Employee employee : employees) {
//            if( employee.getName().toLowerCase().equals("marcus") && employee.getDepartment().equals(Department.ENGINEERING)) {
//                filteredEmployees.add(employee);
//            }
//        }

//        employees.stream()
//                .filter(employee -> employee.getName().toLowerCase().equals("marcus"))
//                .filter(employee -> employee.getDepartment().equals(Department.ENGINEERING))
//                .forEach(System.out::println);

        employees.stream(
                )
//                .filter(employee -> employee.getName().toLowerCase().startsWith("marcus"))
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
