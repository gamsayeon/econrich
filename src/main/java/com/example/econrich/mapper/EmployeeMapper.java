package com.example.econrich.mapper;

import com.example.econrich.dto.CurrentEmployeeResultDTO;
import com.example.econrich.dto.EmployeeDTO;
import org.apache.ibatis.annotations.ResultMap;

import java.util.Optional;

public interface EmployeeMapper {
    @ResultMap("currentEmployeeResultMap")
    Optional<CurrentEmployeeResultDTO> findEmployeeDTOById(Long employeeId);
}
