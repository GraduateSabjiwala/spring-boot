package com.demo.springboot.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Location {
    private String street;
    private String city;
    private String state;
    private String country;
    private String postcode;
    private Coordinates coordinates;
    private Timezone timezone;
}
