package com.example.econrich.service.Impl;

import com.example.econrich.dto.CurrentEmployeeDTO;
import com.example.econrich.dto.EmployeeDTO;
import com.example.econrich.exception.CommissionPctNullPointException;
import com.example.econrich.exception.DepartmentNotFoundException;
import com.example.econrich.exception.EmployeeNotFoundException;
import com.example.econrich.mapper.EmployeeMapper;
import com.example.econrich.service.EmployeeService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeMapper employeeMapper;
    private final Logger logger = LogManager.getLogger(EmployeeServiceImpl.class);

    public EmployeeServiceImpl(EmployeeMapper employeeMapper) {
        this.employeeMapper = employeeMapper;
    }

    @Override
    public CurrentEmployeeDTO getEmployeeById(Long employeeId){
        Optional<CurrentEmployeeDTO> optionalEmployeeDTO= employeeMapper.findEmployeeById(employeeId);

        if (optionalEmployeeDTO.isPresent()) {
            logger.info("사원 번호 " + employeeId + "의 현재 정보를 조회했습니다.");
            return optionalEmployeeDTO.get();
        }
        else{
            logger.warn("사원 번호 " + employeeId + "의 현재 정보가 존재하지 않습니다.");
            throw new EmployeeNotFoundException(employeeId);
        }
    }

    @Override
    public CurrentEmployeeDTO getEmployeeByEmail(String email) {
        Optional<CurrentEmployeeDTO> optionalEmployeeDTO = employeeMapper.findEmployeeByEmail(email);
        if (optionalEmployeeDTO.isPresent()) {
            logger.info("사원 이메일 " + email + "의 현재 정보를 조회했습니다.");
            return optionalEmployeeDTO.get();
        }
        else{
            logger.warn("사원 이메일 " + email + "의 현재 정보가 존재하지 않습니다.");
            throw new EmployeeNotFoundException(email);
        }
    }

    @Override
    public CurrentEmployeeDTO getEmployeeByName(String firstName, String lastName) {
        Optional<CurrentEmployeeDTO> optionalEmployeeDTO = employeeMapper.findEmployeeByName(firstName, lastName);
        if (optionalEmployeeDTO.isPresent()) {
            logger.info("사원 이름 " + firstName + lastName + "의 현재 정보를 조회했습니다.");
            return optionalEmployeeDTO.get();
        }
        else{
            logger.warn("사원 이름 " + firstName + lastName + "의 현재 정보가 존재하지 않습니다.");
            throw new EmployeeNotFoundException(firstName, lastName);
        }
    }

    @Override
    @Transactional
    public void updateSalaryAndInfoByDepartment(Long departmentId) {
        List<EmployeeDTO> employeeDTOS = employeeMapper.findEmployeeByDepartmentId(departmentId);
        if(employeeDTOS.isEmpty()){
            logger.warn("부서 번호 " + departmentId + "의 부서 정보가 존재하지 않습니다.");
            throw new DepartmentNotFoundException(departmentId);
        }

        for(EmployeeDTO employee : employeeDTOS){
            try {
                BigDecimal oldSalary = employee.getSalary();
                BigDecimal newSalary = oldSalary.multiply(BigDecimal.ONE.add(employee.getCommissionPct()));

                employee.setSalary(newSalary);
                employeeMapper.updateSalaryByDepartmentId(employee.getEmployeeId(), employee.getSalary());
            }catch (NullPointerException e){
                logger.warn("부서 번호 " + departmentId + "commission_pct 의 급여 인상률이 존재하지 않습니다.");
                throw new CommissionPctNullPointException();
            }
            logger.info("사원 번호 " + employee.getEmployeeId() + "의 사원 급여를 업데이트했습니다.");
        }
    }
}
