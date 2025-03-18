package com.myhotel.employees.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
import com.myhotel.employees.service.EmployeeService;
import com.myhotel.employees.dto.DepartmentSalarySegmentDTO;
import com.myhotel.employees.dto.CountrySalaryStatsDTO;
import com.myhotel.employees.dto.DepartmentAverageSalaryDTO;
import com.myhotel.employees.dto.ExperiencedManagerDTO;
import com.myhotel.employees.dto.TopPaidEmployeeDTO;
import com.myhotel.employees.dto.SalarySegmentDTO;
import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/salary-segments")
    public SalarySegmentDTO getSalarySegments() {
        try {
            return employeeService.getSalarySegments();
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }

    @GetMapping("/salary-segments-by-department")
    public List<DepartmentSalarySegmentDTO> getSalarySegmentsByDepartment() {
        try {
            return employeeService.getSalarySegmentsByDepartment();
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }

    @GetMapping("/top-paid-by-department")
    public List<TopPaidEmployeeDTO> getTopPaidEmployeeByDepartment() {
        try {
            return employeeService.getTopPaidEmployeeByDepartment();
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }

    @GetMapping("/experienced-managers")
    public List<ExperiencedManagerDTO> getExperiencedManagers() {
        try {
            return employeeService.getExperiencedManagers();
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }

    @GetMapping("/average-salary-by-department")
    public List<DepartmentAverageSalaryDTO> getAverageSalaryByDepartmentWithMoreThan10Employees() {
        try {
            return employeeService.getAverageSalaryByDepartmentWithMoreThan10Employees();
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }

    @GetMapping("/salary-stats-by-country")
    public List<CountrySalaryStatsDTO> getSalaryStatsByCountry() {
        try {
            return employeeService.getSalaryStatsByCountry();
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }
}


