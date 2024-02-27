package com.demo.springboot.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;


@Data // Getter Setter --> method
@AllArgsConstructor // Constructor --> all arguments
@NoArgsConstructor // No argument / Default constructor
@Document("employeeData") // DB object name define
public class Employee {

    @JsonProperty("sEmpId") // property name define for external user  eg. OMV-8902/ 2893
    private String empId;


    @JsonProperty("sEmpName")
    private String empName;

    @JsonProperty("iEmpSalary")
    private int empSalary;

    @JsonProperty("sEmpDepartment")
    private String empDepartment;

}
