package com.demo.SpringBoot.repository;

import com.demo.SpringBoot.model.AdditionRepoModel;
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
}
