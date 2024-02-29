package com.demo.springboot.repository;

import com.demo.springboot.model.AdditionRepoModel;
import com.demo.springboot.model.Calculator;

public interface AdditionRepo {
    void save(AdditionRepoModel additionRepoModel);

    void Calculate(Calculator calculator);
}
