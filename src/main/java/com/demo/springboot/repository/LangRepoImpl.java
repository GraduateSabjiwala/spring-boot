package com.demo.springboot.repository;

import com.demo.springboot.model.Language;
import com.mongodb.client.result.DeleteResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Slf4j
public class LangRepoImpl implements LangRepo{

    @Autowired
    private MongoTemplate mongoTemplate;
    @Override
    public Language findByLangId(String langId) {
        log.info("Inside lang repo to find language with id {}", langId);
        return mongoTemplate.findById(langId, Language.class);
    }

    @Override
    public List<Language> findAll() {
        log.info("finding all languages...");
        return mongoTemplate.findAll(Language.class);
    }

    @Override
    public void deleteById(String langId) {
        log.info("deleting language having id {}", langId);
        Query query = new Query();
        query.addCriteria(Criteria.where("langId").is(langId));
        DeleteResult remove = mongoTemplate.remove(query, Language.class);
        log.info("Removed {} language",remove.getDeletedCount());
    }

    @Override
    public Language save(Language language) {
        Language savedLanguage = mongoTemplate.save(language);
        log.info("Saved {} language" ,language);
        return savedLanguage;
    }

    @Override
    public boolean existsById(String langId) {
        log.info("checking if lang with id {} exists",langId);
        Query query = new Query();
        query.addCriteria(Criteria.where("langId").is(langId));
        return mongoTemplate.exists(query, Language.class);
    }
}
