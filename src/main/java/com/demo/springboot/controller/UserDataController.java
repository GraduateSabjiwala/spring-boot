package com.demo.springboot.controller;

import com.demo.springboot.model.UserData;
import com.demo.springboot.service.UserDataService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@Slf4j
public class UserDataController {

    @Autowired
    UserDataService userDataService;
    @PostMapping("/add-user")
    public UserData addUser(){
        log.info("Inside UserDataController");
        return userDataService.addUser();
    }
}
