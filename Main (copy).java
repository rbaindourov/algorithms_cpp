package org.example;

import java.util.*;//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
import lombok.Getter;


class Employee {
    String name;
    @Getter
    int salary;

    public Employee(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }


}

// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    static double getAverage(List<Employee> arr) {

        double sum = 0;
        for( Employee e : arr) {
            sum += e.salary;
        }
        return sum / arr.size();
    }

    static int getMaxSalary(List<Employee> arr) {
        int max = Integer.MIN_VALUE;
        for( Employee e : arr) {
            if (e.salary > max) {
                max = e.salary;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee("John", 80000),
                new Employee("Alice", 60000),
                new Employee("Bob", 70000)
        );


        employees.stream().sorted( (o1, o2) -> ((Employee) o1).salary - ((Employee) o2).salary)
                .forEach(o -> System.out.println(((Employee) o).name));

        employees.stream().sorted(Comparator.comparing(Employee::getSalary)).forEach(o -> System.out.println(o.name));

        System.out.println(getAverage(employees));
        System.out.println(getMaxSalary(employees));

        // Compute Table features
        // chain async tasks
        // collectors


        //TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.employees);
    }
}


/*

import java.util.ArrayList;
import java.util.List;

public class Employee {
    private String name;
    private double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }
}

public class Main {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("John", 50000));
        employees.add(new Employee("Jane", 60000));
        employees.add(new Employee("Bob", 70000));

        double averageSalary = calculateAverageSalary(employees);
        System.out.println("Average salary: " + averageSalary);
    }

    public static double calculateAverageSalary(List<Employee> employees) {
        double totalSalary = 0;
        for (Employee employee : employees) {
            totalSalary += employee.getSalary();
        }
        return totalSalary / employees.size();
    }
}
 */

/*
public static double calculateAverageSalary(List<Employee> employees) {
    return employees.stream()
            .mapToDouble(Employee::getSalary)
            .average()
            .orElse(0);
}

public static double getMaxSalary(List<Employee> employees) {
    return employees.stream()
            .mapToDouble(Employee::getSalary)
            .max()
            .orElse(Double.MIN_VALUE);
}

public static Optional<Double> getMaxSalary(List<Employee> employees) {
    return employees.stream()
            .mapToDouble(Employee::getSalary)
            .max();
}

double maxSalary = getMaxSalary(employees).orElse(Double.MIN_VALUE);

 */