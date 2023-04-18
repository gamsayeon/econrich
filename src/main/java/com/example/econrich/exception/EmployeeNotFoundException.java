package com.example.econrich.exception;

public class EmployeeNotFoundException extends RuntimeException {
    public EmployeeNotFoundException(Long employeeId) {
        super("Could not find employee " + employeeId);
    }
}
