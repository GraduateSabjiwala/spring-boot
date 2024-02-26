package com.demo.springboot.repository;

import com.demo.springboot.model.Language;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface LangRepo{
    Language findByLangId(String langId);

    List<Language> findAll();

    void deleteById(String langId);

    Language save(Language language);

    boolean existsById(String langId);
}
