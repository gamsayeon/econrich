package com.example.econrich.service.Impl;

import com.example.econrich.dto.DepartmentLocationDTO;
import com.example.econrich.exception.DepartmentNotFoundException;
import com.example.econrich.mapper.DepartmentMapper;
import com.example.econrich.service.DepartmentService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    private final DepartmentMapper departmentMapper;
    private final Logger logger = LogManager.getLogger(DepartmentServiceImpl.class);

    public DepartmentServiceImpl(DepartmentMapper departmentMapper){
        this.departmentMapper = departmentMapper;
    }

    @Override
    public DepartmentLocationDTO getDepartmentById(Long departmentId){
        Optional<DepartmentLocationDTO> optionalDepartmentLocationDTO= departmentMapper.findDepartmentById(departmentId);

        if (optionalDepartmentLocationDTO.isPresent()) {
            logger.info("부서 번호 " + departmentId + "의 부서 및 위치 정보를 조회했습니다.");
            return optionalDepartmentLocationDTO.get();
        }
        else{
            logger.warn("부서 번호 " + departmentId + "의 부서 및 위치 정보가 존재하지 않습니다.");
            throw new DepartmentNotFoundException(departmentId);
        }

    }
    @Override
    public DepartmentLocationDTO getDepartmentByName(String departmentName){
        Optional<DepartmentLocationDTO> optionalDepartmentLocationDTO= departmentMapper.findDepartmentByName(departmentName);

        if (optionalDepartmentLocationDTO.isPresent()) {
            logger.info("부서 이름 " + departmentName + "의 부서 및 위치 정보를 조회했습니다.");
            return optionalDepartmentLocationDTO.get();
        }
        else{
            logger.warn("부서 이름 " + departmentName + "의 부서 및 위치 정보가 존재하지 않습니다.");
            throw new DepartmentNotFoundException(departmentName);
        }

    }
}
