package com.example.econrich.mapper;

import com.example.econrich.dto.DepartmentLocationDTO;
import org.apache.ibatis.annotations.Param;

import java.util.Optional;

public interface DepartmentMapper {
    Optional<DepartmentLocationDTO> findDepartmentById(@Param("departmentId") Long departmentId);

    Optional<DepartmentLocationDTO> findDepartmentByName(@Param("departmentName") String departmentName);
}
