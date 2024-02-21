package com.demo.SpringBoot.controller;

import com.demo.SpringBoot.model.AdditionRequest;
import com.demo.SpringBoot.service.AdditionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class DemoController {

    @Autowired
    AdditionService additionService;
    @GetMapping("/test-application")
    public String testApp(){
        return "Application is up and running ";
    }

    @PostMapping("/addition")
    public int addition(@RequestBody AdditionRequest additionRequest){
        return additionService.add(additionRequest);

    }

}
