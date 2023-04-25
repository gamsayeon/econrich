package com.example.econrich.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CurrentEmployeeDTO {

    private Long employeeId;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private Date hireDate;
    private String jobTitle;
    private BigDecimal salary;
    private String departmentName;
    private String streetAddress;
    private String postalCode;
    private String city;
    private String stateProvince;
    private String countryName;
    private String regionName;
}
