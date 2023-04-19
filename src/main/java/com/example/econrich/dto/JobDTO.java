package com.example.econrich.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class JobDTO {
    private Long jobId;

    private String jobTitle;

    private BigDecimal minSalary;
    private BigDecimal maxSalary;
}
