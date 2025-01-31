package com.webapp.springweb.repo;

import com.webapp.springweb.model.Employee;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EmployeeRepo {
    List<Employee> employeeList = new ArrayList<>();
    public EmployeeRepo() {
        employeeList.add(new Employee(1,"Karthick"));
        employeeList.add(new Employee(2,"Sundararaj"));
        employeeList.add(new Employee(3,"Vicknesh"));
        employeeList.add(new Employee(4,"Maheshwari"));
        employeeList.add(new Employee(5,"Thanvi"));
    }
    public Employee getEmployeeData(int empID) {
        return employeeList
                .stream().
                filter(x-> x.getEmpId()== empID)
                .findFirst().orElse(new Employee(-1,"Unknown"));
    }

    public void addEmployeeData(Employee employee) {
        employeeList.add(employee);
    }
}
