package com.myhotel.employees.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.myhotel.employees.dto.SalarySegmentDTO;
import com.myhotel.employees.dto.DepartmentSalarySegmentDTO;
import com.myhotel.employees.dto.TopPaidEmployeeDTO;
import com.myhotel.employees.dto.ExperiencedManagerDTO;
import com.myhotel.employees.dto.CountrySalaryStatsDTO;
import com.myhotel.employees.dto.DepartmentAverageSalaryDTO;
import com.myhotel.employees.entity.Employee;
import java.util.List;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long> {

    // 🔹 Cantidad de empleados en cada segmento salarial
    @Query("SELECT new com.myhotel.employees.dto.SalarySegmentDTO( " +
            "CAST(SUM(CASE WHEN e.salary < 3500 THEN 1 ELSE 0 END) AS Long), " +
            "CAST(SUM(CASE WHEN e.salary >= 3500 AND e.salary < 8000 THEN 1 ELSE 0 END) AS Long), " +
            "CAST(SUM(CASE WHEN e.salary >= 8000 THEN 1 ELSE 0 END) AS Long) ) " +
            "FROM Employee e")
    SalarySegmentDTO getSalarySegments();


    // 🔹 Cantidad de empleados en cada segmento salarial, agrupados por departamento
    @Query("SELECT new com.myhotel.employees.dto.DepartmentSalarySegmentDTO( " +
            "d.id, d.name, " +
            "CAST(SUM(CASE WHEN e.salary < 3500 THEN 1 ELSE 0 END) AS Long), " +
            "CAST(SUM(CASE WHEN e.salary >= 3500 AND e.salary < 8000 THEN 1 ELSE 0 END) AS Long), " +
            "CAST(SUM(CASE WHEN e.salary >= 8000 THEN 1 ELSE 0 END) AS Long) ) " +
            "FROM Employee e JOIN e.department d " +
            "GROUP BY d.id, d.name")
    List<DepartmentSalarySegmentDTO> getSalarySegmentsByDepartment();

    // 🔹 Empleado con el mayor sueldo de cada departamento
    @Query("SELECT new com.myhotel.employees.dto.TopPaidEmployeeDTO( " +
            "e.id, e.firstName, e.lastName, e.salary, d.id, d.name) " +
            "FROM Employee e " +
            "JOIN e.department d " +
            "WHERE e.salary = (SELECT MAX(e2.salary) FROM Employee e2 WHERE e2.department.id = e.department.id)")
    List<TopPaidEmployeeDTO> getTopPaidEmployeeByDepartment();

    // 🔹 Gerentes con más de 15 años de experiencia
    @Query("SELECT new com.myhotel.employees.dto.ExperiencedManagerDTO( " +
            "e.id, e.firstName, e.lastName, e.hireDate, e.jobId, e.salary, e.department.id) " +
            "FROM Employee e " +
            "WHERE e.id IN (SELECT DISTINCT e2.managerId FROM Employee e2 WHERE e2.managerId IS NOT NULL) " +
            "AND FUNCTION('DATEDIFF', CURRENT_DATE, e.hireDate) / 365 > 15")
    List<ExperiencedManagerDTO> getExperiencedManagers();


    // 🔹 Salario promedio de departamentos con más de 10 empleados
    @Query("SELECT new com.myhotel.employees.dto.DepartmentAverageSalaryDTO( " +
            "d.id, d.name, AVG(e.salary)) " +
            "FROM Employee e " +
            "JOIN e.department d " +
            "GROUP BY d.id, d.name " +
            "HAVING COUNT(e.id) > 10")
    List<DepartmentAverageSalaryDTO> getAverageSalaryByDepartmentWithMoreThan10Employees();

    // 🔹 Estadísticas salariales por país
    @Query("SELECT new com.myhotel.employees.dto.CountrySalaryStatsDTO( " +
            "l.country.countryName, COUNT(e), " +
            "CAST(AVG(e.salary) AS Double), " +
            "MAX(e.salary), " +
            "MIN(e.salary), " +
            "CAST(AVG(YEAR(CURRENT_DATE) - YEAR(e.hireDate)) AS Double) ) " +
            "FROM Employee e " +
            "JOIN e.department d " +
            "JOIN d.location l " +
            "GROUP BY l.country.countryName")
    List<CountrySalaryStatsDTO> getSalaryStatsByCountry();

}
