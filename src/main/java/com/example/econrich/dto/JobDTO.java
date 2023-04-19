package com.example.econrich.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class JobDTO {
    private Long jobId;

    private String jobTitle;

    private BigDecimal minSalary;
    private BigDecimal maxSalary;
}
