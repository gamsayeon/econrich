package com.example.econrich.controller;

import com.example.econrich.dto.EmployeeJobHistoryDTO;
import com.example.econrich.service.Impl.JobHistoryServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/job")
public class JobHistoryController {
    private final JobHistoryServiceImpl jobHistoryService;

    private final Logger logger = LogManager.getLogger(JobHistoryController.class);

    public JobHistoryController(JobHistoryServiceImpl jobHistoryService) {
        this.jobHistoryService = jobHistoryService;
    }

    @GetMapping("/{employeeId}")
    public ResponseEntity<List<EmployeeJobHistoryDTO>> getJobHistoryById(@PathVariable("employeeId") Long employeeId) {
        logger.debug("사원 번호 " + employeeId + "의 이력 정보를 조회합니다.");
        List<EmployeeJobHistoryDTO> employeeJobHistoryDTOS = jobHistoryService.getJobHistoryById(employeeId);
        return ResponseEntity.ok(employeeJobHistoryDTOS);
    }
}
