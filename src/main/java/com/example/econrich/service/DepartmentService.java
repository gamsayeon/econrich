package com.example.econrich.service;

import com.example.econrich.dto.DepartmentLocationDTO;


public interface DepartmentService {

    DepartmentLocationDTO getDepartmentById(Long departmentId);
}
