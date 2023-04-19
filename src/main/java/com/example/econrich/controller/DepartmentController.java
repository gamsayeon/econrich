package com.example.econrich.controller;

import com.example.econrich.dto.DepartmentLocationDTO;
import com.example.econrich.service.Impl.DepartmentServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/department")
public class DepartmentController {
    private final DepartmentServiceImpl departmentService;

    public DepartmentController(DepartmentServiceImpl departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/{departmentId}")
    public ResponseEntity<DepartmentLocationDTO> getJobHistoryById(@PathVariable("departmentId") Long departmentId) {
        DepartmentLocationDTO departmentLocationDTO = departmentService.getDepartmentById(departmentId);
        return ResponseEntity.ok(departmentLocationDTO);
    }
}
