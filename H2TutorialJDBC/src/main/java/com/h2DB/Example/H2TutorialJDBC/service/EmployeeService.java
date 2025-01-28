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

    // what if we have constructor of EmployeeService which accepts EmployeeRepository object and 
    // if we have autowired above to the constructor, then it is called as Constructor Injection
    

    // The below one is Setter Injection.
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
