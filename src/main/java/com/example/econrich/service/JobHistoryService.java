package com.example.econrich.service;

import com.example.econrich.dto.EmployeeJobHistoryDTO;

import java.util.List;

public interface JobHistoryService {
    List<EmployeeJobHistoryDTO> getJobHistoryById(Long employeeId);
}
