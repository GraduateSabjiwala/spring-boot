package com.demo.springboot.controller;

import com.demo.springboot.model.CalcRequest;
import com.demo.springboot.service.CalcService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class CalcController {

    @Autowired
    CalcService calcService;
    @PostMapping("/calc")
    public CalcRequest saveOperation(@RequestBody CalcRequest calcRequest) {
        log.info("Inside calc");
        return calcService.saveOperation(calcRequest);

    }
}
