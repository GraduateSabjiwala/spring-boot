package com.demo.springboot.controller;


import com.demo.springboot.model.Employee;
import com.demo.springboot.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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




    // Save --> Update --> Get --> Delete --> basic
    // External API -> Integrate


}
