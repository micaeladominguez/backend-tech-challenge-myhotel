package com.myhotel.employees.dto;

import java.math.BigDecimal;

public class TopPaidEmployeeDTO {
    private Long employeeId;
    private String firstName;
    private String lastName;
    private BigDecimal salary;
    private Long departmentId;
    private String departmentName;

    public TopPaidEmployeeDTO(Long employeeId, String firstName, String lastName, BigDecimal salary, Long departmentId, String departmentName) {
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.departmentId = departmentId;
        this.departmentName = departmentName;
    }

    public Long getEmployeeId() { return employeeId; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public BigDecimal getSalary() { return salary; }
    public Long getDepartmentId() { return departmentId; }
    public String getDepartmentName() { return departmentName; }
}
