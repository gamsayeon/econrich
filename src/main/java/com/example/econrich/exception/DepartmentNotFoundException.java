package com.example.econrich.exception;

public class DepartmentNotFoundException extends RuntimeException {
    public DepartmentNotFoundException(Long departmentId) {
        super("Could not find Department " + departmentId);
    }
}
