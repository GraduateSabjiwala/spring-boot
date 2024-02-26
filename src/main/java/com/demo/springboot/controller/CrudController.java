package com.demo.springboot.controller;


import com.demo.springboot.model.Employee;
import com.demo.springboot.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping("/get-all-emp")
    public List<Employee> getAllEmp(){
        return employeeService.getAllEmp();
    }

    @GetMapping("/get-by-id/{empId}")
    public List<Employee> getById(@PathVariable String empId){
        return employeeService.getEmpById(empId);
    }
    // Save --> Update --> Get --> Delete --> basic
    // External API -> Integrate --> External --> cloud remote --> url --> request format --> response format
    // Response --> CallBack API --> waitTime


}
