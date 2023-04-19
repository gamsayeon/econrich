package com.example.econrich.service.Impl;

import com.example.econrich.dto.CurrentEmployeeDTO;
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
}
