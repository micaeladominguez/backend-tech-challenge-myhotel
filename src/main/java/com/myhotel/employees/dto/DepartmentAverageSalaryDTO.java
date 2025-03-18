package com.myhotel.employees.dto;

public class DepartmentAverageSalaryDTO {
    private Long departmentId;
    private String departmentName;
    private Double averageSalary;

    // 🔹 Constructor requerido por Hibernate
    public DepartmentAverageSalaryDTO(Long departmentId, String departmentName, Double averageSalary) {
        this.departmentId = departmentId;
        this.departmentName = departmentName;
        this.averageSalary = averageSalary;
    }

    // Getters y setters
    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public Double getAverageSalary() {
        return averageSalary;
    }

    public void setAverageSalary(Double averageSalary) {
        this.averageSalary = averageSalary;
    }
}

