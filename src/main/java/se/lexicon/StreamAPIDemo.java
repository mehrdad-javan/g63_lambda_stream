package se.lexicon;

import java.util.*;
import java.util.function.Predicate;

public class StreamAPIDemo {


    void main() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        //Predicate<Integer> isEven = number -> number % 2 == 0;
        //Predicate<Integer> biggerThanFour = number -> number > 4;

        List<Integer> evenNumbers = numbers.stream()
                .filter(number -> number % 2 == 0)
                .filter(number -> number > 4)
                .toList();
        IO.println(evenNumbers);


        List<Integer> distinctNumbers = Arrays.asList(1, 2, 2, 3, 3, 3, 4)
                .stream()
                .distinct()
                .toList();

        IO.println(distinctNumbers);


        Optional<Integer> numbersStream = numbers.stream()
                .findFirst();
        numbersStream.ifPresent(number -> IO.println("First Number is : " + number));

        long count = numbers.stream().count();
        IO.println("Count of numbers : " + count);


        List<Employee> employees = new ArrayList<>();

        employees.addAll(Arrays.asList(
                new Employee("Anna", "Engineering", 30, 60000),
                new Employee("Erik", "Engineering", 35, 70000),
                new Employee("Karin", "HR", 28, 50000),
                new Employee("Lars", "HR", 40, 45000),
                new Employee("Sofia", "Finance", 32, 65000),
                new Employee("Gustav", "Finance", 25, 55000),
                new Employee("Ingrid", "Engineering", 45, 80000),
                new Employee("Oskar", "Engineering", 29, 62000),
                new Employee("Maja", "HR", 33, 52000),
                new Employee("Nils", "Finance", 38, 68000),
                new Employee("Astrid", "Engineering", 27, 58000),
                new Employee("Sven", "HR", 42, 47000),
                new Employee("Elin", "Finance", 31, 64000),
                new Employee("Johan", "Engineering", 36, 72000),
                new Employee("Linnea", "HR", 26, 48000)
        ));

        // 1. Filter employees in the "Engineering" department earning more than 60k
        IO.println("Filtered Employees (Engineering, >60k):");
        List<Employee> filteredEmployees = employees.stream()
                .filter(e -> e.getDepartment().equalsIgnoreCase("Engineering")) // filter by department
                .filter(e -> e.getSalary() > 60000) // filter by salary
                .toList(); // collect the filtered employees into a list

        filteredEmployees.forEach(employee -> IO.println(employee.toString()));
        IO.println("-------------------");
        // 2. Get employee names sorted by salary
        List<String> employeesName = employees.stream()
                .sorted(Comparator.comparingDouble(employee -> employee.getSalary())) // sorty employees by salary
                .map(employee -> employee.getName()) // Extract employee name
                .toList();

        employeesName.forEach(s -> IO.println(s));

        // 3. Get unique departments
        List<String> uniqueDepartments = employees.stream()
                .map(employee -> employee.getDepartment())
                .distinct()
                .toList();

        IO.println("-------------------");
        IO.println("Unique Departments:");
        uniqueDepartments.forEach(s -> IO.println(s));

    }
}
