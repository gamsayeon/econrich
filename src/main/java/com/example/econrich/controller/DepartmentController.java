package com.example.econrich.controller;

import com.example.econrich.dto.DepartmentLocationDTO;
import com.example.econrich.service.Impl.DepartmentServiceImpl;
import com.example.econrich.service.Impl.EmployeeServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/departments")
@Tag(name = "부서 및 위치 정보 조회 API + 특정 부서 급여 인상 API")
public class DepartmentController {
    private final DepartmentServiceImpl departmentService;
    private final EmployeeServiceImpl employeeService;
    private final Logger logger = LogManager.getLogger(DepartmentController.class);

    public DepartmentController(DepartmentServiceImpl departmentService, EmployeeServiceImpl employeeService) {
        this.departmentService = departmentService;
        this.employeeService = employeeService;
    }

    @GetMapping("/{departmentId}")
    @Operation(summary = "department_id 으로 조회", description = "department_id로 부서 및 위치 정보를 조회합니다.")
    @Parameter(name = "departmentId", description = "조회할 부서의 Id", example = "80")
    public ResponseEntity<DepartmentLocationDTO> getDepartmentById(@PathVariable("departmentId") Long departmentId) {
        logger.debug("부서 번호 " + departmentId + "의 부서 및 위치 정보를 조회합니다.");
        DepartmentLocationDTO departmentLocationDTO = departmentService.getDepartmentById(departmentId);
        return ResponseEntity.ok(departmentLocationDTO);
    }

    @GetMapping(params = "name")
    @Operation(summary = "department_name 으로 조회", description = "department_name 으로 부서 및 위치 정보를 조회합니다.")
    @Parameter(name = "name", description = "조회할 부서의 이름", example = "Administration")
    public ResponseEntity<DepartmentLocationDTO> getDepartmentByName(@RequestParam("name") String departmentName) {
        logger.debug("부서 이름 " + departmentName + "의 부서 및 위치 정보를 조회합니다.");
        DepartmentLocationDTO departmentLocationDTO = departmentService.getDepartmentByName(departmentName);
        return ResponseEntity.ok(departmentLocationDTO);
    }

    @PatchMapping("/{departmentId}/employees")
    @Operation(summary = "특정 부서의 사원 급여 인상", description = "department_id로 부서를 조회하여 각 사원의 급여를 인상합니다.")
    @Parameter(name = "departmentId", description = "급여를 인상할 부서의 Id", example = "80")
    public void updateSalaryAndInfoByDepartment(@PathVariable("departmentId") Long departmentId){
        logger.debug("부서 번호 " + departmentId + "의 급여를 인상 및 사원 정보 업데이트합니다.");
        employeeService.updateSalaryAndInfoByDepartment(departmentId);
    }
}
