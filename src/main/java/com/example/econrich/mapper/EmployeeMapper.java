package com.example.econrich.mapper;

import com.example.econrich.dto.CurrentEmployeeResultDTO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;

import java.util.Optional;

public interface EmployeeMapper {
    @ResultMap("currentEmployeeResultMap")
    Optional<CurrentEmployeeResultDTO> findEmployeeDTOById(@Param("employeeId") Long employeeId);
    @ResultMap("currentEmployeeResultMap")
    Optional<CurrentEmployeeResultDTO> findByEmail(@Param("email") String email);
    @ResultMap("currentEmployeeResultMap")
    Optional<CurrentEmployeeResultDTO> findByName(@Param("firstName") String firstName, @Param("lastName") String lastName);
}
