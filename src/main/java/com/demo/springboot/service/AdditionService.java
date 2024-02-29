package com.demo.springboot.service;

import com.demo.springboot.model.AdditionRequest;
import com.demo.springboot.model.Calculator;

public interface AdditionService {
    int add(AdditionRequest additionRequest);

    Calculator calculation(Calculator calculator);
}
