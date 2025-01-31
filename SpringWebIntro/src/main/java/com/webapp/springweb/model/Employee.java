package com.webapp.springweb.model;

public class Employee {
    @Override
    public String toString() {
        return "Employee ID : " + empId + "   Employee Name : " + name;
    }

    public Employee(int empId, String name) {
        this.empId = empId;
        this.name = name;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private int empId;
    private String name;
}
