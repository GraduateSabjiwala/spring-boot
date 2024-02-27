package com.demo.springboot.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Nutritions {

    @JsonProperty("sCalories")
    private String calories;

    @JsonProperty("sProtein")
    private String protein;

    @JsonProperty("sVitamins")
    private String vitamins;

    @JsonProperty("sFats")
    private String fats;
    @JsonProperty("sSugar")
    private String sugar;

    @JsonProperty("sMinerals")
    private String minerals;

    @JsonProperty("sFibers")
    private String fibers;

    @JsonProperty("sCarbohydrates")
    private String carbohydrates;


}
