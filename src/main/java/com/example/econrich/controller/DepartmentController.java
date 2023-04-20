package com.example.econrich.controller;

import com.example.econrich.dto.DepartmentLocationDTO;
import com.example.econrich.service.Impl.DepartmentServiceImpl;
import com.example.econrich.service.Impl.EmployeeServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/departments")
public class DepartmentController {
    private final DepartmentServiceImpl departmentService;
    private final EmployeeServiceImpl employeeService;
    private final Logger logger = LogManager.getLogger(DepartmentController.class);

    public DepartmentController(DepartmentServiceImpl departmentService, EmployeeServiceImpl employeeService) {
        this.departmentService = departmentService;
        this.employeeService = employeeService;
    }

    @GetMapping("/{departmentId}")
    public ResponseEntity<DepartmentLocationDTO> getDepartmentById(@PathVariable("departmentId") Long departmentId) {
        logger.debug("부서 번호 " + departmentId + "의 부서 및 위치 정보를 조회합니다.");
        DepartmentLocationDTO departmentLocationDTO = departmentService.getDepartmentById(departmentId);
        return ResponseEntity.ok(departmentLocationDTO);
    }

    @GetMapping(params = "name")
    public ResponseEntity<DepartmentLocationDTO> getDepartmentByName(@RequestParam("name") String departmentName) {
        logger.debug("부서 이름 " + departmentName + "의 부서 및 위치 정보를 조회합니다.");
        DepartmentLocationDTO departmentLocationDTO = departmentService.getDepartmentByName(departmentName);
        return ResponseEntity.ok(departmentLocationDTO);
    }

    @PatchMapping("/{departmentId}/employees")
    public void updateSalaryAndInfoByDepartment(@PathVariable("departmentId") Long departmentId){
        logger.debug("부서 번호 " + departmentId + "의 급여를 인상 및 사원 정보 업데이트합니다.");
        employeeService.updateSalaryAndInfoByDepartment(departmentId);
    }
}
