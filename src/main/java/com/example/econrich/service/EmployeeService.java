package com.example.econrich.service;

import com.example.econrich.dto.CurrentEmployeeResultDTO;
import com.example.econrich.dto.EmployeeDTO;

public interface EmployeeService {
    CurrentEmployeeResultDTO getEmployeeById(Long employeeId);
}
