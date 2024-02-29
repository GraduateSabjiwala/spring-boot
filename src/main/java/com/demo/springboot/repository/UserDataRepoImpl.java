package com.demo.springboot.repository;

import com.demo.springboot.model.UserData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

@Repository
@Slf4j
public class UserDataRepoImpl implements UserDataRepo {

    @Autowired
    MongoTemplate mongoTemplate;
    @Override
    public UserData addUser(UserData userData) {

        try {
            log.info("inside addUser repository ");
            return mongoTemplate.save(userData);
        } catch (Exception e) {
            log.error("Exception occurred {}" , e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
