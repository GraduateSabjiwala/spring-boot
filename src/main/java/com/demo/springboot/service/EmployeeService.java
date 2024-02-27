package com.demo.springboot.service;

import com.demo.springboot.model.Employee;

import java.util.List;

public interface EmployeeService {
    Employee addEmployee(Employee employee);

    Object updateEmployee(Employee employee);

    List<Employee> getEmployee();

    Object deleteEmployee(String empId);
}
