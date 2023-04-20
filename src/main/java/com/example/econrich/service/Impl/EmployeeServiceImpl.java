package com.example.econrich.service.Impl;

import com.example.econrich.dto.CurrentEmployeeDTO;
import com.example.econrich.dto.EmployeeDTO;
import com.example.econrich.exception.CommissionPctNullPointException;
import com.example.econrich.exception.DepartmentNotFoundException;
import com.example.econrich.exception.EmployeeNotFoundException;
import com.example.econrich.exception.JobHistoryNotFoundException;
import com.example.econrich.mapper.EmployeeMapper;
import com.example.econrich.service.EmployeeService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeMapper employeeMapper;

    public EmployeeServiceImpl(EmployeeMapper employeeMapper) {
        this.employeeMapper = employeeMapper;
    }

    @Override
    public CurrentEmployeeDTO getEmployeeById(Long employeeId){
        Optional<CurrentEmployeeDTO> optionalEmployeeDTO= employeeMapper.findEmployeeById(employeeId);

        if (optionalEmployeeDTO.isPresent()) {
            return optionalEmployeeDTO.get();
        }
        else{
            throw new EmployeeNotFoundException(employeeId);
        }
    }

    @Override
    public CurrentEmployeeDTO getEmployeeByEmail(String email) {
        Optional<CurrentEmployeeDTO> optionalEmployeeDTO = employeeMapper.findEmployeeByEmail(email);
        if (optionalEmployeeDTO.isPresent()) {
            return optionalEmployeeDTO.get();
        }
        else{
            throw new EmployeeNotFoundException(email);
        }
    }

    @Override
    public CurrentEmployeeDTO getEmployeeByName(String firstName, String lastName) {
        Optional<CurrentEmployeeDTO> optionalEmployeeDTO = employeeMapper.findEmployeeByName(firstName, lastName);
        if (optionalEmployeeDTO.isPresent()) {
            return optionalEmployeeDTO.get();
        }
        else{
            throw new EmployeeNotFoundException(firstName, lastName);
        }
    }

    @Override
    @Transactional
    public void updateSalaryAndInfoByDepartment(Long departmentId) {
        List<EmployeeDTO> employeeDTOS = employeeMapper.findEmployeeByDepartmentId(departmentId);
        if(employeeDTOS.isEmpty()){
            throw new DepartmentNotFoundException(departmentId);
        }

        for(EmployeeDTO employee : employeeDTOS){
            try {
                BigDecimal oldSalary = employee.getSalary();
                BigDecimal newSalary = oldSalary.multiply(BigDecimal.ONE.add(employee.getCommissionPct()));

                employee.setSalary(newSalary);
                employeeMapper.updateSalaryByDepartmentId(employee.getEmployeeId(), employee.getSalary());
            }catch (NullPointerException e){
                throw new CommissionPctNullPointException();
            }
        }
    }
}
