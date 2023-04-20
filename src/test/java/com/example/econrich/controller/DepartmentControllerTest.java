package com.example.econrich.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

import com.example.econrich.dto.DepartmentLocationDTO;
import com.example.econrich.service.Impl.DepartmentServiceImpl;
import com.example.econrich.service.Impl.EmployeeServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@ExtendWith(MockitoExtension.class)
public class DepartmentControllerTest {

    @InjectMocks
    private DepartmentController departmentController;

    @Mock
    private DepartmentServiceImpl departmentService;
    @Mock
    private EmployeeServiceImpl employeeService;

    private final Long departmentId = 1L;
    private final DepartmentLocationDTO expectedDepartmentLocationDTO = new DepartmentLocationDTO();

    @BeforeEach
    void setUp() {
        // given
        expectedDepartmentLocationDTO.setDepartmentId(departmentId);
        expectedDepartmentLocationDTO.setDepartmentName("IT");
        expectedDepartmentLocationDTO.setStreetAddress("123 Main St");
        expectedDepartmentLocationDTO.setPostalCode("12345");
        expectedDepartmentLocationDTO.setCity("San Francisco");
        expectedDepartmentLocationDTO.setStateProvince("CA");
        expectedDepartmentLocationDTO.setCountryName("USA");
        expectedDepartmentLocationDTO.setRegionName("Americas");
    }

    @Test
    @DisplayName("특정 부서 조회(departmentId 로 조회)")
    public void testGetDepartmentById() {
        when(departmentService.getDepartmentById(departmentId))
                .thenReturn(expectedDepartmentLocationDTO);

        // when
        ResponseEntity<DepartmentLocationDTO> responseEntity =
                departmentController.getDepartmentById(departmentId);

        // then
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getBody()).isEqualTo(expectedDepartmentLocationDTO);
    }

    @Test
    @DisplayName("특정 부서 조회(departmentName 로 조회)")
    public void testGetDepartmentByName() {
        when(departmentService.getDepartmentByName(expectedDepartmentLocationDTO.getDepartmentName()))
                .thenReturn(expectedDepartmentLocationDTO);

        // when
        ResponseEntity<DepartmentLocationDTO> responseEntity =
                departmentController.getDepartmentByName(expectedDepartmentLocationDTO.getDepartmentName());

        // then
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getBody()).isEqualTo(expectedDepartmentLocationDTO);
    }

    @Test
    @DisplayName("특정 부서 급여 인상 및 사원 업데이트")
    public void testUpdateSalaryAndInfoByDepartment() {
        doNothing().when(employeeService).updateSalaryAndInfoByDepartment(any(Long.class));

        // when
        departmentController.updateSalaryAndInfoByDepartment(departmentId);

        // then
        verify(employeeService).updateSalaryAndInfoByDepartment(departmentId);
    }

}
