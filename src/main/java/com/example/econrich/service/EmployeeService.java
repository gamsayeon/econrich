package com.example.econrich.service;

import com.example.econrich.dto.CurrentEmployeeResultDTO;

public interface EmployeeService {
    CurrentEmployeeResultDTO getEmployeeById(Long employeeId);
    CurrentEmployeeResultDTO getEmployeeByEmail(String email);
    CurrentEmployeeResultDTO getEmployeeByName(String firstName, String lastName);
}
