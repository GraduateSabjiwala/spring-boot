package com.demo.springboot.repository;

import com.demo.springboot.model.Employee;

import java.util.List;

public interface EmployeeRepo {
    Employee addEmployee(Employee employee);

    Object updateEmployee(Employee employee);

    List<Employee> getEmployees();

    List<Employee> getEmpById(String empId);
}
