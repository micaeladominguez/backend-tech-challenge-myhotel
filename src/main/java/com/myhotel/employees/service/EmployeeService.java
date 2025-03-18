package com.myhotel.employees.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import com.myhotel.employees.dto.SalarySegmentDTO;
import com.myhotel.employees.dto.DepartmentSalarySegmentDTO;
import com.myhotel.employees.dto.ExperiencedManagerDTO;
import com.myhotel.employees.repository.EmployeeRepository;
import com.myhotel.employees.dto.DepartmentAverageSalaryDTO;
import com.myhotel.employees.dto.TopPaidEmployeeDTO;
import com.myhotel.employees.dto.CountrySalaryStatsDTO;
import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public SalarySegmentDTO getSalarySegments() {
        try {
            SalarySegmentDTO result = employeeRepository.getSalarySegments();
            if (result == null) throw new EmptyResultDataAccessException(1);
            return result;
        } catch (Exception e) {
            throw new RuntimeException("Error al obtener segmentos de salario", e);
        }
    }

    public List<DepartmentSalarySegmentDTO> getSalarySegmentsByDepartment() {
        try {
            List<DepartmentSalarySegmentDTO> result = employeeRepository.getSalarySegmentsByDepartment();
            if (result.isEmpty()) throw new EmptyResultDataAccessException(1);
            return result;
        } catch (Exception e) {
            throw new RuntimeException("Error al obtener segmentos de salario por departamento", e);
        }
    }

    public List<TopPaidEmployeeDTO> getTopPaidEmployeeByDepartment() {
        try {
            List<TopPaidEmployeeDTO> result = employeeRepository.getTopPaidEmployeeByDepartment();
            if (result.isEmpty()) throw new EmptyResultDataAccessException(1);
            return result;
        } catch (Exception e) {
            throw new RuntimeException("Error al obtener empleados mejor pagados por departamento", e);
        }
    }

    public List<ExperiencedManagerDTO> getExperiencedManagers() {
        try {
            List<ExperiencedManagerDTO> result = employeeRepository.getExperiencedManagers();
            if (result.isEmpty()) throw new EmptyResultDataAccessException(1);
            return result;
        } catch (Exception e) {
            throw new RuntimeException("Error al obtener gerentes experimentados", e);
        }
    }

    public List<DepartmentAverageSalaryDTO> getAverageSalaryByDepartmentWithMoreThan10Employees() {
        try {
            List<DepartmentAverageSalaryDTO> result = employeeRepository.getAverageSalaryByDepartmentWithMoreThan10Employees();
            if (result.isEmpty()) throw new EmptyResultDataAccessException(1);
            return result;
        } catch (Exception e) {
            throw new RuntimeException("Error al obtener salario promedio por departamento", e);
        }
    }

    public List<CountrySalaryStatsDTO> getSalaryStatsByCountry() {
        try {
            List<CountrySalaryStatsDTO> result = employeeRepository.getSalaryStatsByCountry();
            if (result.isEmpty()) throw new EmptyResultDataAccessException(1);
            return result;
        } catch (Exception e) {
            throw new RuntimeException("Error al obtener estadísticas salariales por país", e);
        }
    }
}
