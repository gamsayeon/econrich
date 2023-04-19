package com.example.econrich.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmployeeJobHistoryDTO {
    private Long employeeId;
    private Date startDate;
    private Date endDate;
    private String jobTitle;
    private String departmentName;
    private String streetAddress;
    private String postalCode;
    private String city;
    private String stateProvince;
    private String countryName;
    private String regionName;
}
