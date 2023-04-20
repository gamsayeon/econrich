package com.example.econrich.mapper;

import com.example.econrich.dto.DepartmentLocationDTO;

import java.util.Optional;

public interface DepartmentMapper {
    public Optional<DepartmentLocationDTO> findDepartmentById(Long departmentId);

    Optional<DepartmentLocationDTO> findDepartmentByName(String departmentName);
}
