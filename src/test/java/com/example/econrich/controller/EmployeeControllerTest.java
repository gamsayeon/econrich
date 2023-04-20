package com.example.econrich.controller;

import com.example.econrich.dto.CurrentEmployeeDTO;
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

import java.math.BigDecimal;
import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class EmployeeControllerTest {
    @InjectMocks
    private EmployeeController employeeController;

    @Mock
    private EmployeeServiceImpl employeeService;

    private final Long employeeId = 1L;
    private final CurrentEmployeeDTO expectedCurrentEmployeeDTO = new CurrentEmployeeDTO();

    @BeforeEach
    void setUp() {
        //given
        expectedCurrentEmployeeDTO.setEmployeeId(employeeId);
        expectedCurrentEmployeeDTO.setFirstName("John");
        expectedCurrentEmployeeDTO.setLastName("Doe");
        expectedCurrentEmployeeDTO.setEmail("Test Email");
        expectedCurrentEmployeeDTO.setPhoneNumber("123-456-7890");
        expectedCurrentEmployeeDTO.setHireDate(new Date());
        expectedCurrentEmployeeDTO.setJobTitle("Engineer");
        expectedCurrentEmployeeDTO.setSalary(new BigDecimal("5000.00"));
        expectedCurrentEmployeeDTO.setDepartmentName("Engineering");
        expectedCurrentEmployeeDTO.setStreetAddress("123 Main St");
        expectedCurrentEmployeeDTO.setPostalCode("12345");
        expectedCurrentEmployeeDTO.setCity("San Francisco");
        expectedCurrentEmployeeDTO.setStateProvince("CA");
        expectedCurrentEmployeeDTO.setCountryName("USA");
        expectedCurrentEmployeeDTO.setRegionName("North America");
    }

    @Test
    @DisplayName("특정 사원 현재 정보 조회(employeeId 로 조회)")
    public void testGetEmployeeById() {
        when(employeeService.getEmployeeById(employeeId))
                .thenReturn(expectedCurrentEmployeeDTO);

        // when
        ResponseEntity<CurrentEmployeeDTO> responseEntity =
                employeeController.getEmployeeById(employeeId);

        // then
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getBody()).isEqualTo(expectedCurrentEmployeeDTO);
    }

    @Test
    @DisplayName("특정 사원 현재 정보 조회(email 로 조회)")
    public void testGetEmployeeByEmail() {
        when(employeeService.getEmployeeByEmail(expectedCurrentEmployeeDTO.getEmail()))
                .thenReturn(expectedCurrentEmployeeDTO);

        // when
        ResponseEntity<CurrentEmployeeDTO> responseEntity =
                employeeController.getEmployeeByEmail(expectedCurrentEmployeeDTO.getEmail());

        // then
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getBody()).isEqualTo(expectedCurrentEmployeeDTO);
    }

    @Test
    @DisplayName("특정 사원 현재 정보 조회(firstName, lastName 로 조회)")
    public void testGetEmployeeByName() {
        when(employeeService.getEmployeeByName(expectedCurrentEmployeeDTO.getFirstName(), expectedCurrentEmployeeDTO.getLastName()))
                .thenReturn(expectedCurrentEmployeeDTO);

        // when
        ResponseEntity<CurrentEmployeeDTO> responseEntity =
                employeeController.getEmployeeByName(expectedCurrentEmployeeDTO.getFirstName(), expectedCurrentEmployeeDTO.getLastName());

        // then
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getBody()).isEqualTo(expectedCurrentEmployeeDTO);
    }

}
