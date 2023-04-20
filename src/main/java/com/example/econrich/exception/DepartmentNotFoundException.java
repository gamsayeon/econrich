package com.example.econrich.exception;

public class DepartmentNotFoundException extends RuntimeException {
    public DepartmentNotFoundException(Long departmentId) {
        super("Could not find Department " + departmentId);
    }
    public DepartmentNotFoundException(String departmentName) {
        super("Could not find Department " + departmentName);
    }
}
