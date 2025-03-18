package com.myhotel.employees.service;

import com.myhotel.employees.dto.SalarySegmentDTO;
import com.myhotel.employees.dto.DepartmentSalarySegmentDTO;
import com.myhotel.employees.dto.TopPaidEmployeeDTO;
import com.myhotel.employees.dto.ExperiencedManagerDTO;
import com.myhotel.employees.dto.DepartmentAverageSalaryDTO;
import com.myhotel.employees.dto.CountrySalaryStatsDTO;
import com.myhotel.employees.repository.EmployeeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.Arrays;
import java.util.List;
import java.math.BigDecimal;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class EmployeeServiceTest {

    @Mock
    private EmployeeRepository employeeRepository;

    @InjectMocks
    private EmployeeService employeeService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this); // Inicializa los mocks
    }

    @Test
    void testGetSalarySegments() {
        SalarySegmentDTO mockResponse = new SalarySegmentDTO(10L, 20L, 30L);
        when(employeeRepository.getSalarySegments()).thenReturn(mockResponse);

        SalarySegmentDTO result = employeeService.getSalarySegments();

        assertNotNull(result);
        assertEquals(10L, result.getSegmentoA());
        assertEquals(20L, result.getSegmentoB());
        assertEquals(30L, result.getSegmentoC());
    }

    @Test
    void testGetSalarySegmentsByDepartment() {
        DepartmentSalarySegmentDTO department1 = new DepartmentSalarySegmentDTO(1L, "IT", 5L, 10L, 15L);
        List<DepartmentSalarySegmentDTO> mockResponse = Arrays.asList(department1);

        when(employeeRepository.getSalarySegmentsByDepartment()).thenReturn(mockResponse);

        List<DepartmentSalarySegmentDTO> result = employeeService.getSalarySegmentsByDepartment();

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("IT", result.get(0).getDepartmentName());
    }

    @Test
    void testGetTopPaidEmployeeByDepartment() {
        TopPaidEmployeeDTO employee = new TopPaidEmployeeDTO(1L, "Juan", "Pérez", BigDecimal.valueOf(5000.0), 1L, "IT");
        List<TopPaidEmployeeDTO> mockResponse = Arrays.asList(employee);

        when(employeeRepository.getTopPaidEmployeeByDepartment()).thenReturn(mockResponse);

        List<TopPaidEmployeeDTO> result = employeeService.getTopPaidEmployeeByDepartment();

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("Juan", result.get(0).getFirstName());
    }

    @Test
    void testGetExperiencedManagers() {
        ExperiencedManagerDTO manager = new ExperiencedManagerDTO(1L, "Carlos", "Lopez", null, "Manager", BigDecimal.valueOf(6000.0), 1L);
        List<ExperiencedManagerDTO> mockResponse = Arrays.asList(manager);

        when(employeeRepository.getExperiencedManagers()).thenReturn(mockResponse);

        List<ExperiencedManagerDTO> result = employeeService.getExperiencedManagers();

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("Carlos", result.get(0).getFirstName());
    }

    @Test
    void testGetAverageSalaryByDepartmentWithMoreThan10Employees() {
        DepartmentAverageSalaryDTO department = new DepartmentAverageSalaryDTO(1L, "IT", 5000.0);
        List<DepartmentAverageSalaryDTO> mockResponse = Arrays.asList(department);

        when(employeeRepository.getAverageSalaryByDepartmentWithMoreThan10Employees()).thenReturn(mockResponse);

        List<DepartmentAverageSalaryDTO> result = employeeService.getAverageSalaryByDepartmentWithMoreThan10Employees();

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("IT", result.get(0).getDepartmentName());
    }

    @Test
    void testGetSalaryStatsByCountry() {
        CountrySalaryStatsDTO country = new CountrySalaryStatsDTO(
                "Argentina",
                100L,
                5000.0,
                BigDecimal.valueOf(1000.0),
                BigDecimal.valueOf(10000.0),
                10.0
        );

        List<CountrySalaryStatsDTO> mockResponse = Arrays.asList(country);

        when(employeeRepository.getSalaryStatsByCountry()).thenReturn(mockResponse);

        List<CountrySalaryStatsDTO> result = employeeService.getSalaryStatsByCountry();

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("Argentina", result.get(0).getCountryName());
    }
}
