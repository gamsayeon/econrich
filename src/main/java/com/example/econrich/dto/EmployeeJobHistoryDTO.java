package com.example.econrich.dto;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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
