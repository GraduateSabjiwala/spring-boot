package com.demo.springboot.service;

import com.demo.springboot.model.Language;
import com.demo.springboot.repository.LangRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class LangServiceImpl implements LangService {
    @Autowired
    private LangRepo langRepo;

    @Override
    public Language getLanguage(String langId) {
        return langRepo.findByLangId(langId);
    }

    @Override
    public Language addLanguage(Language language) {
        if (language.getLangId().isEmpty() || language.getLangName().isEmpty()
                || language.getLangDeveloper().isEmpty() || language.getReleaseYear() < 1957) {

            log.warn("Please provide all the fields before adding new language...");
            return null;
        }
        return langRepo.save(language);
    }

    @Override
    public Language updateLanguageById(Language language) {
        if (langRepo.existsById(language.getLangId())) {
            return langRepo.save(language);
        }
        log.warn("no language with id {} exist", language.getLangId());
        return null;
    }

    @Override
    public List<Language> getAll() {
        return langRepo.findAll();
    }

    @Override
    public void deleteLanguageById(String langId) {
        langRepo.deleteById(langId);
    }
}