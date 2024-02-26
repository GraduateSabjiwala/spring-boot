package com.demo.springboot.repository;

import com.demo.springboot.model.Employee;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;

@Repository
@Slf4j
public class EmployeeRepoImpl implements EmployeeRepo{

    //MongoTemplate or MongoRepository
    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public Employee addEmployee(Employee employee) {
        try {
            log.info("inside addEmployee repository ");
            return mongoTemplate.save(employee); // DB interaction save operation
        } catch (Exception e) {
            log.error("Exception occurred {}" , e.getMessage());
            throw new RuntimeException(e);
        }
    }

    @Override
    public Object updateEmployee(Employee employee) {
        //update --> single /multiple object update
        //upsert --> save + update --> combination
       Object updateData = new Object();
        try{
            Query query = new Query();//condition create to perform  operation
            query.addCriteria(Criteria.where("empId").is(employee.getEmpId())); // condition
            Update update = new Update();// data --> what to update
            update.set("empName", employee.getEmpName());
            update.set("empSalary", employee.getEmpSalary());
            update.set("empDepartment", employee.getEmpDepartment());
            updateData = mongoTemplate.upsert(query, update, Employee.class);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return updateData;
    }

    @Override
    public List<Employee> getEmployees() {
        log.info("Inside getEmployees in repository ");
        List<Employee> employees;
        try{
            //String emplyee = mongoTemplate.getCollection(String.valueOf(Employee.class));
             employees = mongoTemplate.findAll(Employee.class);
            log.info("FindAll() : {}",employees);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return employees;
    }

    @Override
    public List<Employee> getEmpById(String empId) {
        List<Employee> employee ;
        try{
            Query query = new Query();
            query.addCriteria(Criteria.where("empId").is(empId));
            //employee = mongoTemplate.find(query, Employee.class);
            employee = Collections.singletonList(mongoTemplate.findOne(query, Employee.class));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return employee;
    }

    //Save --> Update --> GetAll --> GetEmployeeByDepartment();
}
