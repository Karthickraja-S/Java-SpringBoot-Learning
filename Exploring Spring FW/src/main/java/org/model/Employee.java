package org.model;

public class Employee {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    public Employee() {
        System.out.println("obj created...");
    }

    public Employee(String name, int age) {
        System.out.println("parameterized obj created...");
        this.age = age;
        this.name = name;
    }

    public Employee(String name, int age,Address address) {
        System.out.println("parameterized obj created...");
        this.age = age;
        this.name = name;
        this.address = address;
    }

    private String name ;
    private int age;
    private Address address;

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
    public void doWork() {
        System.out.println("Employee is doing work...");
    }
}
