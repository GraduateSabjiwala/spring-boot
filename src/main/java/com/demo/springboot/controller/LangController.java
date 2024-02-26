package com.demo.springboot.controller;

import com.demo.springboot.model.Language;
import com.demo.springboot.service.LangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class LangController {

    @Autowired
    private LangService langService;

    @GetMapping("/get/{langId}")
    public Language getLanguageById(@PathVariable String langId) {
        return langService.getLanguage(langId);
    }
    @GetMapping("/all")
    public List<Language> getAll(){
        return langService.getAll();
    }

    @PostMapping("/add")
    public Language addLanguage(@RequestBody Language language) {
        Language addedLanguage = langService.addLanguage(language);
        if (addedLanguage == null) {
            return new Language();
        }
        return addedLanguage;
    }

    @PutMapping("/update")
    public Language updateLanguageById(@RequestBody Language language) {

        return langService.updateLanguageById(language);
    }

    @DeleteMapping("/delete/{langId}")
    public String deleteLanguageById(@PathVariable String langId) {
        langService.deleteLanguageById(langId);
        return "Language deleted having id - " + langId;
    }
}