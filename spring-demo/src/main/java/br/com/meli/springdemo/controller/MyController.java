package br.com.meli.springdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@ResponseBody
public class MyController {
    public static List<Employee> employees = new ArrayList<>();
    static {
        employees.add(new Employee("Mateus", 18, "marketing"));
        employees.add(new Employee("Jorge", 38, "IT"));
        employees.add(new Employee("Mariana", 91, "people"));
        employees.add(new Employee("Carlos", 83, "IT"));
    }
    @GetMapping("/ping")
    public String ping(){
        return "pon";
    }

    @GetMapping("/hello/{name}")
    public String helloName(@PathVariable String name){
        return "hello " + name;
    }

    @PostMapping("/employees/")
    public Employee createEmployee(@RequestBody Employee employee){
        employees.add(employee);
        return employee;
    }

    @GetMapping("/employees/")
    public List<Employee> getEmployees(@RequestParam(name = "department", required = false) String department,
                                       @RequestParam(name = "age", required = false) Integer age){
        List<Employee> response = employees;
        System.out.println(employees.toString());
        if (department != null && !department.isEmpty())
            response = response.stream()
                    .filter(e -> e.getDepartment().equalsIgnoreCase(department))
                    .collect(Collectors.toList());

        if (age != null && age != 0)
            response = response.stream()
                    .filter(e -> e.getAge() <= age)
                    .collect(Collectors.toList());

        return response;
    }
}
