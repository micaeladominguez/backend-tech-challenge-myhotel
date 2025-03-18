package com.myhotel.employees.dto;

import java.math.BigDecimal;
import java.sql.Date;

public class ExperiencedManagerDTO {
    private Long employeeId;
    private String firstName;
    private String lastName;
    private Date hireDate;
    private String jobId;
    private BigDecimal salary;
    private Long departmentId;

    public ExperiencedManagerDTO(Long employeeId, String firstName, String lastName, Date hireDate, String jobId, BigDecimal salary, Long departmentId) {
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.hireDate = hireDate;
        this.jobId = jobId;
        this.salary = salary;
        this.departmentId = departmentId;
    }

    public Long getEmployeeId() { return employeeId; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public Date getHireDate() { return hireDate; }
    public String getJobId() { return jobId; }
    public BigDecimal getSalary() { return salary; }
    public Long getDepartmentId() { return departmentId; }
}
