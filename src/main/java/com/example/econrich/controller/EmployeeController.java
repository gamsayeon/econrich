package com.example.econrich.controller;

import com.example.econrich.dto.CurrentEmployeeDTO;
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
    public ResponseEntity<CurrentEmployeeDTO> getEmployeeById(@PathVariable("employeeId") Long employeeId) {
        CurrentEmployeeDTO currentEmployeeDTO = employeeService.getEmployeeById(employeeId);
        return ResponseEntity.ok(currentEmployeeDTO);
    }

    @GetMapping(params = "email")
    public ResponseEntity<CurrentEmployeeDTO> getEmployeeByEmail(@RequestParam("email") String email) {
        CurrentEmployeeDTO currentEmployeeDTO  = employeeService.getEmployeeByEmail(email);
        return ResponseEntity.ok(currentEmployeeDTO);
    }

    @GetMapping(params = {"firstName", "lastName"})
    public ResponseEntity<CurrentEmployeeDTO> getEmployeeByName(@RequestParam("firstName") String firstName,
                                                                @RequestParam("lastName") String lastName) {
        CurrentEmployeeDTO currentEmployeeDTO  = employeeService.getEmployeeByName(firstName, lastName);
        return ResponseEntity.ok(currentEmployeeDTO);
    }
}
