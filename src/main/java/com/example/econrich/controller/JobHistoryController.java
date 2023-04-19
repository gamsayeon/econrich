package com.example.econrich.controller;

import com.example.econrich.dto.EmployeeJobHistoryDTO;
import com.example.econrich.service.Impl.JobHistoryServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/job")
public class JobHistoryController {
    private final JobHistoryServiceImpl jobHistoryService;

    public JobHistoryController(JobHistoryServiceImpl jobHistoryService) {
        this.jobHistoryService = jobHistoryService;
    }

    @GetMapping("/{employeeId}")
    public ResponseEntity<List<EmployeeJobHistoryDTO>> getJobHistoryById(@PathVariable("employeeId") Long employeeId) {
        List<EmployeeJobHistoryDTO> employeeJobHistoryDTOS = jobHistoryService.getJobHistoryById(employeeId);
        return ResponseEntity.ok(employeeJobHistoryDTOS);
    }
}
