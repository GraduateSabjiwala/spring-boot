package com.demo.springboot.service;
import com.demo.springboot.model.CalcRequest;
import com.demo.springboot.repository.CalcRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CalcServiceImpl implements CalcService {
@Autowired
CalcRepo calcRepo;
    @Override
    public CalcRequest saveOperation(CalcRequest calcRequest) {
        switch (calcRequest.getOperation()) {
            case "add":
                calcRequest.setResult(calcRequest.getNum1() + calcRequest.getNum2());
                return calcRepo.saveOperation(calcRequest);
            case "sub":
                calcRequest.setResult(calcRequest.getNum1() - calcRequest.getNum2());
                return calcRepo.saveOperation(calcRequest);
            case "mul":
                calcRequest.setResult(calcRequest.getNum1() * calcRequest.getNum2());
                return calcRepo.saveOperation(calcRequest);
            case "div":
                calcRequest.setResult(calcRequest.getNum1() / calcRequest.getNum2());
                return calcRepo.saveOperation(calcRequest);
            default:
                log.error("Invalid operation");
                return null;
        }
    }
}
