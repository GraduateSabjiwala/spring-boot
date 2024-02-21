package com.demo.SpringBoot.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Validated
public class AdditionRequest {

    @JsonProperty("iFirstVariable")
    private int a;

    @JsonProperty("iSecondVariable")
    private int b;

}
