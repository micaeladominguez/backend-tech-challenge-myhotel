package com.myhotel.employees.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;

@Entity
@Table(name = "employees") // Nombre exacto de la tabla en la base de datos
public class Employee {

    @Id
    @Column(name = "EMPLOYEE_ID")
    private Long id;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;

    @Column(name = "HIRE_DATE")
    private Date hireDate;

    @Column(name = "JOB_ID")
    private String jobId;

    @Column(name = "SALARY")
    private BigDecimal salary;  // Cambio a BigDecimal

    @Column(name = "COMMISSION_PCT")
    private BigDecimal commissionPct;

    @Column(name = "MANAGER_ID")
    private Long managerId;


    @ManyToOne
    @JoinColumn(name = "DEPARTMENT_ID", referencedColumnName = "DEPARTMENT_ID", insertable = false, updatable = false)
    private Department department;

    public Employee() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public BigDecimal getSalary() { return salary; }
    public void setSalary(BigDecimal salary) { this.salary = salary; }

    public Department getDepartment() { return department; }

}
