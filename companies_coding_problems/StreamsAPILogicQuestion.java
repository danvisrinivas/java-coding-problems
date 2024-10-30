package companies_coding_problems;

import javax.swing.text.html.Option;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * employees -> grade < B2 (10% increase)
 * 			grade > C1 (5% increase)
 * 			grade > M1 (2% increase)
 * 			grade > A1 keep as it is
 */

public class StreamsAPILogicQuestion {
    public static void main(String[] args) {

        List<Employee> employees = Arrays.asList(
                new Employee(1, "Alice", "B1", 3000.0),
                new Employee(2, "Bob", "B1", 3200.0),
                new Employee(3, "Charlie", "C2", 4000.0),
                new Employee(4, "David", "M2", 3500.0),
                new Employee(5, "Mike", "M2", 3900.0),
                new Employee(6, "Eve", "A1", 4500.0),
                new Employee(7, "Frank", "C2", 3700.0),
                new Employee(8, "Grace", "M1", 3300.0),
                new Employee(9, "Hank", "B2", 3100.0),
                new Employee(10, "Ivy", "A1", 5000.0),
                new Employee(11, "John", "B2", 3400.0)
        );

        Map<String, Optional<Employee>> maxSalaryByGrade = employees.stream().peek(employee -> {
            if (employee.getGrade().compareTo("B2") < 0) {
                employee.setSalary(employee.getSalary() * 1.10);
            } else if (employee.getGrade().compareTo("C1") > 0) {
                employee.setSalary(employee.getSalary() * 1.05);
            } else if (employee.getGrade().compareTo("M1") > 0) {
                employee.setSalary(employee.getSalary() * 1.02);
            }
            // A1 and other grades are kept as is
        }).collect(Collectors.groupingBy(
                Employee::getGrade, // Use first letter of grade as department
                Collectors.maxBy(Comparator.comparing(Employee::getSalary))
        ));

        System.out.println(maxSalaryByGrade);

    }
}

class Employee {
    private Integer id;
    private String name;
    private String grade;
    private Double salary;

    public Employee(Integer id, String name, String grade, Double salary) {
        this.id = id;
        this.name = name;
        this.grade = grade;
        this.salary = salary;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String toString(){
        return "Emp Name:"+ name + "salary: "+ salary;
    }
}

