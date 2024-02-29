package com.demo.springboot.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Info {
    private String seed;
    private int results;
    private int page;
    private String version;
}
