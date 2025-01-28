package com.h2DB.Example.H2TutorialJDBC.service;

import com.h2DB.Example.H2TutorialJDBC.model.Employee;
import com.h2DB.Example.H2TutorialJDBC.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    // If we put @Autowired below, then this is Field Injection
    EmployeeRepository repository;
    public EmployeeRepository getRepository() {
        return repository;
    }

    // The below one is Field Injection.
    @Autowired
    public void setRepository(EmployeeRepository repository) {
        this.repository = repository;
    }

    public void addEmployee(Employee e) {
        System.out.println("Saving data .... ");
        repository.save(e);
    }
    public List<Employee> getAllEmployees() {
        System.out.println("returning data .... ");
        return repository.findAll();
    }
}
