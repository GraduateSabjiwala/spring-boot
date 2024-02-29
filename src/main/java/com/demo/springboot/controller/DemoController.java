package com.demo.springboot.controller;

import com.demo.springboot.model.Calculator;
import com.demo.springboot.service.AdditionService;
import com.demo.springboot.model.AdditionRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@Slf4j
public class DemoController {
    @Autowired
    //Runtime object creation after use distroy
    //Interface object
    AdditionService additionService;



    @GetMapping("/test-application")
    public String testApp(){
        return "Application is up and running ";
    }

    @PostMapping("/addition")
    public int addition(@RequestBody  AdditionRequest additionRequest){
        log.info("Request: {}", additionRequest);
        return additionService.add(additionRequest);
    }
    @PostMapping("/calculator")
    public Calculator calculation(@RequestBody Calculator calculator){
        log.info("Request: {}", calculator);
        return additionService.calculation(calculator);
    }
}
