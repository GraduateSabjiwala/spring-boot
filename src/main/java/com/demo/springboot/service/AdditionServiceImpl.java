package com.demo.springboot.service;

import com.demo.springboot.model.AdditionRepoModel;
import com.demo.springboot.model.AdditionRequest;
import com.demo.springboot.model.Calculator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.demo.springboot.repository.AdditionRepo;

@Service
@Slf4j
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

    @Override
    public Calculator calculation(Calculator calculator) {

        try {
            if(calculator.getFirstNumber() >= 0 && calculator.getSecondNumber() >= 0 && calculator.getOperation()!=null){
                switch (calculator.getOperation()){
                    case "+":
                        calculator.setResult(calculator.getFirstNumber() + calculator.getSecondNumber());
                        break;
                    case "-":
                        calculator.setResult(calculator.getFirstNumber() - calculator.getSecondNumber());
                        break;
                    case "*":
                        calculator.setResult(calculator.getFirstNumber() * calculator.getSecondNumber());
                        break;
                    case "/":
                        calculator.setResult(calculator.getFirstNumber() / calculator.getSecondNumber());
                        break;
                    default:
                        log.error("invalid Credintial");
                        calculator.setInvalidOperation(true);
                        break;
                }
                additionRepo.Calculate(calculator);
                return calculator;
            }

        }catch (Exception e) {
            log.error("Failed to create calculator");
            e.printStackTrace();
        }
        return calculator;
    }
}
