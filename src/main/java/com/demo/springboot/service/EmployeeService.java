package com.demo.springboot.service;

import com.demo.springboot.model.Employee;

public interface EmployeeService {
    Employee addEmployee(Employee employee);

    Object updateEmployee(Employee employee);
}
