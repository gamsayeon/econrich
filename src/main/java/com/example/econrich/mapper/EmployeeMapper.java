package com.example.econrich.mapper;

import com.example.econrich.dto.CurrentEmployeeDTO;
import com.example.econrich.dto.EmployeeDTO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface EmployeeMapper {
    @ResultMap("currentEmployeeResultMap")
    Optional<CurrentEmployeeDTO> findEmployeeById(@Param("employeeId") Long employeeId);
    @ResultMap("currentEmployeeResultMap")
    Optional<CurrentEmployeeDTO> findEmployeeByEmail(@Param("email") String email);
    @ResultMap("currentEmployeeResultMap")
    Optional<CurrentEmployeeDTO> findEmployeeByName(@Param("firstName") String firstName, @Param("lastName") String lastName);

    List<EmployeeDTO> findEmployeeByDepartmentId(@Param("departmentId") Long departmentId);
    void updateSalaryByDepartmentId(@Param("employeeId") Long employeeId, @Param("salary") BigDecimal salary);
}
