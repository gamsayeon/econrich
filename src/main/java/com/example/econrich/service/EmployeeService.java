package com.example.econrich.service;

import com.example.econrich.dto.CurrentEmployeeDTO;

public interface EmployeeService {
    CurrentEmployeeDTO getEmployeeById(Long employeeId);
    CurrentEmployeeDTO getEmployeeByEmail(String email);
    CurrentEmployeeDTO getEmployeeByName(String firstName, String lastName);
}
