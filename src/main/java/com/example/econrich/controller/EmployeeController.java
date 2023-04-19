package com.example.econrich.controller;

import com.example.econrich.dto.CurrentEmployeeResultDTO;
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

    @GetMapping(params = "email")
    public ResponseEntity<CurrentEmployeeResultDTO> getEmployeeByEmail(@RequestParam("email") String email) {
        CurrentEmployeeResultDTO currentEmployeeResultDTO  = employeeService.getEmployeeByEmail(email);
        return ResponseEntity.ok(currentEmployeeResultDTO);
    }

    @GetMapping(params = {"firstName", "lastName"})
    public ResponseEntity<CurrentEmployeeResultDTO> getEmployeeByName(@RequestParam("firstName") String firstName,
                                                                      @RequestParam("lastName") String lastName) {
        CurrentEmployeeResultDTO currentEmployeeResultDTO  = employeeService.getEmployeeByName(firstName, lastName);
        return ResponseEntity.ok(currentEmployeeResultDTO);
    }
}
