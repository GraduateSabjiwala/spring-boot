package com.demo.springboot.repository;

import com.demo.springboot.model.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MongoRepo extends MongoRepository<Employee, String> {

    //MongoRepository<Object, ID-Datatype>
}
