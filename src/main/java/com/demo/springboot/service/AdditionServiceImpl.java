package com.demo.springboot.service;

import com.demo.springboot.model.AdditionRepoModel;
import com.demo.springboot.model.AdditionRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.demo.springboot.repository.AdditionRepo;

@Service
public class AdditionServiceImpl implements AdditionService{


    @Autowired
    AdditionRepo additionRepo;
    AdditionRepoModel additionRepoModel = new AdditionRepoModel();
    @Override
    public int add(AdditionRequest additionRequest) {
        int addition = 0;
        if (additionRequest.getA() >= 0 && additionRequest.getB() >=0) {
             addition = additionRequest.getA() + additionRequest.getB();
            addition = additionRequest.getA() + additionRequest.getB();
        }
        additionRepoModel.setAddition(addition);
        additionRepo.save(additionRepoModel);
        return addition;
    }
}
