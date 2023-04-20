package com.example.econrich.controller;

import com.example.econrich.dto.EmployeeJobHistoryDTO;
import com.example.econrich.service.Impl.JobHistoryServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class JobHistoryControllerTest {
    @InjectMocks
    private JobHistoryController jobHistoryController;

    @Mock
    private JobHistoryServiceImpl jobHistoryService;

    private final Long employeeId = 1L;
    private List<EmployeeJobHistoryDTO> expectedEmployeeJobHistoryDTOS;

    @BeforeEach
    void setUp() {
        expectedEmployeeJobHistoryDTOS = new ArrayList<>();

        // 첫번째 EmployeeJobHistoryDTO 객체 추가
        EmployeeJobHistoryDTO employeeJobHistoryDTO1 = new EmployeeJobHistoryDTO();
        employeeJobHistoryDTO1.setEmployeeId(1L);
        employeeJobHistoryDTO1.setStartDate(Date.valueOf("2022-01-01"));
        employeeJobHistoryDTO1.setEndDate(Date.valueOf("2022-12-31"));
        employeeJobHistoryDTO1.setJobTitle("Manager");
        employeeJobHistoryDTO1.setDepartmentName("IT");
        employeeJobHistoryDTO1.setStreetAddress("123 Main St.");
        employeeJobHistoryDTO1.setPostalCode("12345");
        employeeJobHistoryDTO1.setCity("Los Angeles");
        employeeJobHistoryDTO1.setStateProvince("CA");
        employeeJobHistoryDTO1.setCountryName("USA");
        employeeJobHistoryDTO1.setRegionName("Americas");
        expectedEmployeeJobHistoryDTOS.add(employeeJobHistoryDTO1);

        // 두번째 EmployeeJobHistoryDTO 객체 추가
        EmployeeJobHistoryDTO employeeJobHistoryDTO2 = new EmployeeJobHistoryDTO();
        employeeJobHistoryDTO2.setEmployeeId(1L);
        employeeJobHistoryDTO2.setStartDate(Date.valueOf("2021-01-01"));
        employeeJobHistoryDTO2.setEndDate(Date.valueOf("2021-12-31"));
        employeeJobHistoryDTO2.setJobTitle("Manager");
        employeeJobHistoryDTO2.setDepartmentName("IT");
        employeeJobHistoryDTO2.setStreetAddress("123 Main St.");
        employeeJobHistoryDTO2.setPostalCode("12345");
        employeeJobHistoryDTO2.setCity("Los Angeles");
        employeeJobHistoryDTO2.setStateProvince("CA");
        employeeJobHistoryDTO2.setCountryName("USA");
        employeeJobHistoryDTO2.setRegionName("Americas");
        expectedEmployeeJobHistoryDTOS.add(employeeJobHistoryDTO2);
    }

    @Test
    @DisplayName("특정 사원 이력 조회(employeeId 로 조회)")
    public void testGetJobHistoryById() {
        when(jobHistoryService.getJobHistoryById(employeeId))
                .thenReturn(expectedEmployeeJobHistoryDTOS);

        // when
        ResponseEntity<List<EmployeeJobHistoryDTO>> responseEntity =
                jobHistoryController.getJobHistoryById(employeeId);

        // then
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getBody()).isEqualTo(expectedEmployeeJobHistoryDTOS);
    }
}
