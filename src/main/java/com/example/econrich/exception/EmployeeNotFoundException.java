package com.example.econrich.exception;

public class EmployeeNotFoundException extends RuntimeException {
    public EmployeeNotFoundException(Long employeeId) {
        super("Could not find Employee " + employeeId);
    }
    public EmployeeNotFoundException(String email){
        super("Could not find Employee " + email);
    }
    public EmployeeNotFoundException(String firstName, String lastName){
        super("Could not find Employee " + firstName + lastName);
    }
}
