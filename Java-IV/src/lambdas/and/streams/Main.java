package lambdas.and.streams;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        printOrderedITEmployees();
    }

    static ArrayList getEmployeesArray(){
        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Jorge", "Marketing"));
        employees.add(new Employee("Mateus", "IT"));
        employees.add(new Employee("Maria", "People"));
        employees.add(new Employee("Joana", "Shipping"));
        return employees;

    }
    static void printOrderedITEmployees() {
        ArrayList<Employee> employees = getEmployeesArray();
        employees.stream()
                .filter(employee -> employee.getDepartment().equals("IT"))
                .sorted((x, y) -> x.getName().compareTo(y.getName()))
                .forEach(System.out::println);
    }
}
