package com.example.econrich.service.Impl;

import com.example.econrich.dto.DepartmentLocationDTO;
import com.example.econrich.exception.DepartmentNotFoundException;
import com.example.econrich.mapper.DepartmentMapper;
import com.example.econrich.service.DepartmentService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    private final DepartmentMapper departmentMapper;

    public DepartmentServiceImpl(DepartmentMapper departmentMapper){
        this.departmentMapper = departmentMapper;
    }

    @Override
    public DepartmentLocationDTO getDepartmentById(Long departmentId){
        Optional<DepartmentLocationDTO> optionalDepartmentLocationDTO= departmentMapper.findDepartmentById(departmentId);

        if (optionalDepartmentLocationDTO.isPresent()) {
            return optionalDepartmentLocationDTO.get();
        }
        else{
            throw new DepartmentNotFoundException(departmentId);
        }

    }
    @Override
    public DepartmentLocationDTO getDepartmentByName(String departmentName){
        Optional<DepartmentLocationDTO> optionalDepartmentLocationDTO= departmentMapper.findDepartmentByName(departmentName);

        if (optionalDepartmentLocationDTO.isPresent()) {
            return optionalDepartmentLocationDTO.get();
        }
        else{
            throw new DepartmentNotFoundException(departmentName);
        }

    }
}
