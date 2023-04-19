package com.example.econrich.exception;

public class EmployeeNotFoundException extends RuntimeException {
    public EmployeeNotFoundException(Long employeeId) {
        super("Could not find employee " + employeeId);
    }
    public EmployeeNotFoundException(String email){
        super("Could not find employee " + email);
    }
    public EmployeeNotFoundException(String firstName, String lastName){
        super("Could not find employee " + firstName + lastName);
    }
}
