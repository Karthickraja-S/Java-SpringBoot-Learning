package com.h2DB.Example.H2TutorialJDBC.repository;

import com.h2DB.Example.H2TutorialJDBC.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class EmployeeRepository {
    JdbcTemplate template;
    public JdbcTemplate getTemplate() {
        return template;
    }
    @Autowired
    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }
    public void save(Employee e) {
        String saveQuery = "insert into employee (empId,name,age,salary) values(?,?,?,?)";
        int rowsAff = template.update(saveQuery,e.getEmpId(),e.getName(),e.getAge(),e.getSalary());
        System.out.println(rowsAff + " rows affected.");
    }

    public List<Employee> findAll() {
        String selectQuery = "select * from employee";

        RowMapper<Employee> rowMapper = (rs, rowNum) -> {
            int empId = rs.getInt("empId");
            String name  = rs.getString("name");
            int age      = rs.getInt("age");
            int salary   = rs.getInt("salary");

            Employee employee = new Employee();
            employee.setEmpId(empId);
            employee.setAge(age);
            employee.setName(name);
            employee.setSalary(salary);
            return employee;
        };
        return template.query(selectQuery , rowMapper);
    }
}
