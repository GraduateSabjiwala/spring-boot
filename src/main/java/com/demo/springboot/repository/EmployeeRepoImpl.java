package com.demo.springboot.repository;

import com.demo.springboot.model.Employee;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

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
}
