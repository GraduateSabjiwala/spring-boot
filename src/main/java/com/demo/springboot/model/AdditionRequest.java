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
public class AdditionRequest {

    @JsonProperty("iFirstVariable")
    private int a;

    @JsonProperty("iSecondVariable")
    private int b;

    @JsonProperty("sName")
    private String name;


}
