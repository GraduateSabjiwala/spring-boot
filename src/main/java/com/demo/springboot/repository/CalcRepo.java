package com.demo.springboot.repository;

import com.demo.springboot.model.CalcRequest;

public interface CalcRepo {
    CalcRequest saveOperation(CalcRequest calcRequest);
}
