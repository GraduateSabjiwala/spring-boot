package com.demo.springboot.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.springframework.data.annotation.Id;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductPayload {

    @Id
    @JsonProperty("sProductId")
    private String productId;

    @JsonProperty("sProductName")
    private String productName;


    @JsonProperty("sProductImage")
    private String image;

    @JsonProperty("sDescription")
    private String description;


    @JsonProperty("dPricePerKg")
    private double pricePerKg;

    @JsonProperty("dPricePerUnit")
    private double pricePerUnit;

    @JsonProperty("sCategory")
    private String category;

    @JsonProperty("sSubCategory")
    private String subCategory;

    @JsonProperty("iQuantity")
    private int quantity;

    @JsonProperty("isActive")
    private boolean isActive;

    @NonNull
    @JsonProperty("isOrganic")
    private boolean isOrganic;

    @NonNull
    @JsonProperty("oNutritions")
    private Nutritions nutritions;
}