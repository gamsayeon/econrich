package com.example.econrich.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentDTO {
    private Long departmentId;

    private String departmentName;

    private Integer managerId;

    private LocationDTO location;
}
