package com.example.econrich.controller;

import com.example.econrich.dto.CurrentEmployeeDTO;
import com.example.econrich.service.Impl.EmployeeServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/employees")
@Tag(name = "특정 사원 현재 정보 조회 API")
public class EmployeeController {
    private final EmployeeServiceImpl employeeService;
    private final Logger logger = LogManager.getLogger(EmployeeController.class);

    public EmployeeController(EmployeeServiceImpl employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/{employeeId}")
    @Operation(summary = "employee_id 로 사원의 현재 정보를 조회", description = "employee_id 로 사원의 현재 정보를 조회합니다.")
    @Parameter(name = "employeeId", description = "조회할 사원의 Id", example = "100")
    public ResponseEntity<CurrentEmployeeDTO> getEmployeeById(@PathVariable("employeeId") Long employeeId) {
        logger.debug("사원 번호 " + employeeId + "의 현재 정보를 조회합니다.");
        CurrentEmployeeDTO currentEmployeeDTO = employeeService.getEmployeeById(employeeId);
        return ResponseEntity.ok(currentEmployeeDTO);
    }

    @GetMapping(params = "email")
    @Operation(summary = "email 로 사원의 현재 정보를 조회", description = "email 로 사원의 현재 정보를 조회합니다.")
    @Parameter(name = "email", description = "조회할 사원의 email", example = "SKING")
    public ResponseEntity<CurrentEmployeeDTO> getEmployeeByEmail(@RequestParam("email") String email) {
        logger.debug("사원 이메일 " + email + "의 현재 정보를 조회합니다.");
        CurrentEmployeeDTO currentEmployeeDTO  = employeeService.getEmployeeByEmail(email);
        return ResponseEntity.ok(currentEmployeeDTO);
    }

    @GetMapping(params = {"firstName", "lastName"})
    @Operation(summary = "firstName 와 lastName 로 사원의 현재 정보를 조회", description = "이름(firstName, lastName) 으로 사원의 현재 정보를 조회합니다.")
    @Parameters({
            @Parameter(name = "firstName", description = "조회할 사원의 first_name", example = "Steven"),
            @Parameter(name = "lastName", description = "조회할 사원의 last_name", example = "King")
    })
    public ResponseEntity<CurrentEmployeeDTO> getEmployeeByName(@RequestParam("firstName") String firstName,
                                                                @RequestParam("lastName") String lastName) {
        logger.debug("사원 이름 " + firstName + lastName + "의 현재 정보를 조회합니다.");
        CurrentEmployeeDTO currentEmployeeDTO  = employeeService.getEmployeeByName(firstName, lastName);
        return ResponseEntity.ok(currentEmployeeDTO);
    }
}
