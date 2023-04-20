package com.example.econrich.exception;

public class JobHistoryNotFoundException extends RuntimeException {
    public JobHistoryNotFoundException(Long employeeId) {
        super("Could not find Employee " + employeeId + " Job History");
    }
}
