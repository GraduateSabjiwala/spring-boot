package com.demo.springboot.repository;

import com.demo.springboot.model.CalcRequest;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

@Repository
@Slf4j
public class CalcRepoImpl implements CalcRepo {
    @Autowired
    MongoTemplate mongoTemplate;
    @Override
    public CalcRequest saveOperation(CalcRequest calcRequest) {
        log.info("inside saveOperation repository ");
        return (mongoTemplate.save(calcRequest));

    }

}
