package com.example.econrich.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class JobHistoryDTO {

    private Long employeeId;

    private Date startDate;

    private Date endDate;
    private JobDTO jobDTO;

    private DepartmentDTO departmentDTO;
}
