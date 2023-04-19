package com.example.econrich.service.Impl;

import com.example.econrich.dto.EmployeeJobHistoryDTO;
import com.example.econrich.exception.JobHistoryNotFoundException;
import com.example.econrich.mapper.JobHistoryMapper;
import com.example.econrich.service.JobHistoryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobHistoryServiceImpl implements JobHistoryService {

    private final JobHistoryMapper jobHistoryMapper;

    public JobHistoryServiceImpl(JobHistoryMapper jobHistoryMapper){
        this.jobHistoryMapper = jobHistoryMapper;
    }

    @Override
    public List<EmployeeJobHistoryDTO> getJobHistoryById(Long employeeId) {
        List<EmployeeJobHistoryDTO> jobHistoryDTOS = jobHistoryMapper.findJobHistoryById(employeeId);

        if (jobHistoryDTOS.isEmpty()) {
            throw new JobHistoryNotFoundException(employeeId);
        }
        return jobHistoryDTOS;
    }

}
