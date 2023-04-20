package com.example.econrich.controller;

import com.example.econrich.dto.DepartmentLocationDTO;
import com.example.econrich.service.Impl.DepartmentServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/departments")
public class DepartmentController {
    private final DepartmentServiceImpl departmentService;

    public DepartmentController(DepartmentServiceImpl departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/{departmentId}")
    public ResponseEntity<DepartmentLocationDTO> getDepartmentById(@PathVariable("departmentId") Long departmentId) {
        DepartmentLocationDTO departmentLocationDTO = departmentService.getDepartmentById(departmentId);
        return ResponseEntity.ok(departmentLocationDTO);
    }

    @GetMapping(params = "name")
    public ResponseEntity<DepartmentLocationDTO> getDepartmentByName(@RequestParam("name") String departmentName) {
        DepartmentLocationDTO departmentLocationDTO = departmentService.getDepartmentByName(departmentName);
        return ResponseEntity.ok(departmentLocationDTO);
    }
}
