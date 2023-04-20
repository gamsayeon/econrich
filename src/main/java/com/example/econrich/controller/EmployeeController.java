package com.example.econrich.controller;

import com.example.econrich.dto.CurrentEmployeeDTO;
import com.example.econrich.service.Impl.EmployeeServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/employees")
public class EmployeeController {
    private final EmployeeServiceImpl employeeService;
    private final Logger logger = LogManager.getLogger(EmployeeController.class);

    public EmployeeController(EmployeeServiceImpl employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/{employeeId}")
    public ResponseEntity<CurrentEmployeeDTO> getEmployeeById(@PathVariable("employeeId") Long employeeId) {
        logger.debug("사원 번호 " + employeeId + "의 현재 정보를 조회합니다.");
        CurrentEmployeeDTO currentEmployeeDTO = employeeService.getEmployeeById(employeeId);
        return ResponseEntity.ok(currentEmployeeDTO);
    }

    @GetMapping(params = "email")
    public ResponseEntity<CurrentEmployeeDTO> getEmployeeByEmail(@RequestParam("email") String email) {
        logger.debug("사원 이메일 " + email + "의 현재 정보를 조회합니다.");
        CurrentEmployeeDTO currentEmployeeDTO  = employeeService.getEmployeeByEmail(email);
        return ResponseEntity.ok(currentEmployeeDTO);
    }

    @GetMapping(params = {"firstName", "lastName"})
    public ResponseEntity<CurrentEmployeeDTO> getEmployeeByName(@RequestParam("firstName") String firstName,
                                                                @RequestParam("lastName") String lastName) {
        logger.debug("사원 이름 " + firstName + lastName + "의 현재 정보를 조회합니다.");
        CurrentEmployeeDTO currentEmployeeDTO  = employeeService.getEmployeeByName(firstName, lastName);
        return ResponseEntity.ok(currentEmployeeDTO);
    }
}
