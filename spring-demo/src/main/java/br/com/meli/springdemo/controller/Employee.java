package br.com.meli.springdemo.controller;

public class Employee {
    String name;
    Integer age;
    String department;

    public Employee(String name, Integer age, String department) {
        this.name = name;
        this.age = age;
        this.department = department;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}