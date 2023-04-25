package com.example.econrich.mapper;

import com.example.econrich.dto.CurrentEmployeeDTO;
import com.example.econrich.dto.EmployeeJobHistoryDTO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;

import java.util.List;
import java.util.Optional;

public interface JobHistoryMapper {
    @ResultMap("currentEmployeeResultMap")
    List<EmployeeJobHistoryDTO> findJobHistoryById(@Param("employeeId") Long employeeId);
}
