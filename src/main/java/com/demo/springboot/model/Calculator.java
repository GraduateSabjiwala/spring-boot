package com.demo.springboot.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Calculator {
    @JsonProperty("dFirstNumber")
    private double firstNumber;
    @JsonProperty("dSecondNumber")
    private double secondNumber;
    @JsonProperty("sOperation")
    private String operation;

    private double result;

    boolean isInvalidOperation;

}
