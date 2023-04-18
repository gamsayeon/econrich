package com.example.econrich.controller;

import com.example.econrich.dto.CurrentEmployeeResultDTO;
import com.example.econrich.dto.EmployeeDTO;
import com.example.econrich.service.Impl.EmployeeServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/employees")
public class EmployeeController {
    private final EmployeeServiceImpl employeeService;

    public EmployeeController(EmployeeServiceImpl employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/{employeeId}")
    public ResponseEntity<CurrentEmployeeResultDTO> getEmployeeById(@PathVariable("employeeId") Long employeeId) {
        CurrentEmployeeResultDTO currentEmployeeResultDTO = employeeService.getEmployeeById(employeeId);
        return ResponseEntity.ok(currentEmployeeResultDTO);
    }

}
