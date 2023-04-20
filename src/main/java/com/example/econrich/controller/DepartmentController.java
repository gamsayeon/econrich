package com.example.econrich.controller;

import com.example.econrich.dto.DepartmentLocationDTO;
import com.example.econrich.service.Impl.DepartmentServiceImpl;
import com.example.econrich.service.Impl.EmployeeServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/departments")
public class DepartmentController {
    private final DepartmentServiceImpl departmentService;
    private final EmployeeServiceImpl employeeService;

    public DepartmentController(DepartmentServiceImpl departmentService, EmployeeServiceImpl employeeService) {
        this.departmentService = departmentService;
        this.employeeService = employeeService;
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

    @PutMapping("/{departmentId}/employees")
    public void updateSalaryAndInfoByDepartment(@PathVariable("departmentId") Long departmentId){
        employeeService.updateSalaryAndInfoByDepartment(departmentId);
    }
}
