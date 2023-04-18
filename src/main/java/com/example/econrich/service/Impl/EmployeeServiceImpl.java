package com.example.econrich.service.Impl;

import com.example.econrich.dto.CurrentEmployeeResultDTO;
import com.example.econrich.dto.EmployeeDTO;
import com.example.econrich.exception.EmployeeNotFoundException;
import com.example.econrich.mapper.EmployeeMapper;
import com.example.econrich.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeMapper employeeMapper;

    public EmployeeServiceImpl(EmployeeMapper employeeMapper) {
        this.employeeMapper = employeeMapper;
    }

    @Override
    public CurrentEmployeeResultDTO getEmployeeById(Long employeeId){
        Optional<CurrentEmployeeResultDTO> optionalEmployeeDTO= employeeMapper.findEmployeeDTOById(employeeId);

        if (optionalEmployeeDTO.isPresent()) {
            return optionalEmployeeDTO.get();
        }
        else{
            throw new EmployeeNotFoundException(employeeId);
        }

    }
}
