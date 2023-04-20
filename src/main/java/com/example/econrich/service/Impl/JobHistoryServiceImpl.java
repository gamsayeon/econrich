package com.example.econrich.service.Impl;

import com.example.econrich.dto.EmployeeJobHistoryDTO;
import com.example.econrich.exception.JobHistoryNotFoundException;
import com.example.econrich.mapper.JobHistoryMapper;
import com.example.econrich.service.JobHistoryService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobHistoryServiceImpl implements JobHistoryService {

    private final JobHistoryMapper jobHistoryMapper;
    private final Logger logger = LogManager.getLogger(JobHistoryServiceImpl.class);


    public JobHistoryServiceImpl(JobHistoryMapper jobHistoryMapper){
        this.jobHistoryMapper = jobHistoryMapper;
    }

    @Override
    public List<EmployeeJobHistoryDTO> getJobHistoryById(Long employeeId) {
        List<EmployeeJobHistoryDTO> jobHistoryDTOS = jobHistoryMapper.findJobHistoryById(employeeId);

        if (jobHistoryDTOS.isEmpty()) {
            logger.warn("사원 번호 " + employeeId + "의 이력 정보가 존재하지 않습니다.");
            throw new JobHistoryNotFoundException(employeeId);
        }
        logger.info("사원 번호 " + employeeId + "의 이력 정보를 조회했습니다.");
        return jobHistoryDTOS;
    }

}
