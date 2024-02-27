package com.demo.springboot.controller;


import com.demo.springboot.model.Employee;
import com.demo.springboot.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class CrudController {

    @Autowired
    EmployeeService employeeService;

    @PostMapping("/add-employee") // save
    public Employee saveEmployee(@RequestBody Employee employee) {
        log.info("Inside saveEmployee");
        return employeeService.addEmployee(employee);
    }

    @PutMapping("/update-employee")
    public Object updateEmployee(@RequestBody Employee employee) {
        log.info("Inside updateEmployee");
        return employeeService.updateEmployee(employee);
    }

    @GetMapping("/get-employee")
    public List<Employee> getEmployee() {
        log.info("Inside getEmployee");
        return employeeService.getEmployee();
    }

    @DeleteMapping("/delete-employee/{empId}")
    public Object deleteEmployee(@PathVariable("empId") String empId) {
        log.info("Inside deleteEmployee");
        return employeeService.deleteEmployee(empId);
    }
    // Save --> Update --> Get --> Delete --> basic
    // External API -> Integrate


}
