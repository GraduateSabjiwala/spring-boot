package com.demo.springboot.service;

import com.demo.springboot.model.Language;
import org.springframework.stereotype.Service;

import java.util.List;

public interface LangService {

    Language getLanguage(String langName);

    Language addLanguage(Language language);

    Language updateLanguageById(Language language);

    List<Language> getAll();

    void deleteLanguageById(String langId);
}