package com.demo.springboot.service;

import com.demo.springboot.model.Employee;
import com.demo.springboot.repository.EmployeeRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
@Slf4j
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepo employeeRepo;

    @Override // this method is from its parent
    public Employee addEmployee(Employee employee) {
        Employee employee1 = new Employee();
        try {
            employee.setEmpId(generateEmpId(employee.getEmpName(), "1000"));
            log.info("Inside addEmployee with data {} ", employee);
            if (employee.getEmpId() != null && employee.getEmpDepartment() != null
                    && employee.getEmpName() != null && employee.getEmpSalary() > 0) {
                employee1 = employeeRepo.addEmployee(employee);
            } else {
                log.error("Null request / Required data not found");
            }
        } catch (Exception e) {
            log.error("Exception occurred while saving employee with probable cause {} ", e.getMessage());
            throw new RuntimeException(e);
        }
        return employee1;
    }

    @Override
    public Object updateEmployee(Employee employee) {
        Object employee1 = new Object();
        try {
           if (employee.getEmpId() != null){
               employee1= employeeRepo.updateEmployee(employee);
           }else {
               log.error("Null employeeId");
           }
        } catch (Exception e) {
            log.error("Exception occurred while updating employee with probable cause {} ", e.getMessage());
            throw new RuntimeException(e);
        }
        return employee1;
    }

    @Override
    public List<Employee> getAllEmp() {
        log.info("Inside getAllEmp");
        List<Employee> employees ;
        try{
            employees = employeeRepo.getEmployees();

        } catch (Exception e) {
            log.error("Exception occurred while get employees with probable cause {} ", e.getMessage());
            throw new RuntimeException(e);
        }
        return employees;
    }

    @Override
    public List<Employee> getEmpById(String empId) {
        List<Employee> employee = null;
        try{
            if (!empId.isEmpty()){
              employee =  employeeRepo.getEmpById(empId);
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return employee;
    }

    public static String generateEmpId(String name, String boundValue) {
        log.info("Inside generateProductId");
        Random random = new Random();
        int rValue = random.nextInt(Integer.parseInt(boundValue));
        // Logic to generate a unique ID based on the name and some random numeric value
        String prefix = name.substring(0, Math.min(name.length(), 4)).toUpperCase();
        String randomNumericPart = String.format("%04d", rValue);
        return prefix + randomNumericPart;
    }
}
