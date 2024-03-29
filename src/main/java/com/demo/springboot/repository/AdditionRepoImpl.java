package com.demo.springboot.repository;

import com.demo.springboot.model.AdditionRepoModel;
import com.demo.springboot.model.Calculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class AdditionRepoImpl implements AdditionRepo {

    @Autowired
    MongoTemplate mongoTemplate;
    @Override
    public void save(AdditionRepoModel addition) {
        mongoTemplate.save(addition);
    }

    @Override
    public void Calculate(Calculator calculator) {
        mongoTemplate.save(calculator);
    }
}
