package com.example.econrich.mapper;

import com.example.econrich.dto.CurrentEmployeeDTO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;

import java.util.Optional;

public interface EmployeeMapper {
    @ResultMap("currentEmployeeResultMap")
    Optional<CurrentEmployeeDTO> findEmployeeById(@Param("employeeId") Long employeeId);
    @ResultMap("currentEmployeeResultMap")
    Optional<CurrentEmployeeDTO> findEmployeeByEmail(@Param("email") String email);
    @ResultMap("currentEmployeeResultMap")
    Optional<CurrentEmployeeDTO> findEmployeeByName(@Param("firstName") String firstName, @Param("lastName") String lastName);
}
