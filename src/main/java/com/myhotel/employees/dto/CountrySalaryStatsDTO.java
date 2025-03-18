package com.myhotel.employees.dto;

import java.math.BigDecimal;


public class CountrySalaryStatsDTO {
    private String countryName;
    private Long employeeCount;
    private Double averageSalary;
    private BigDecimal maxSalary;
    private BigDecimal minSalary;
    private Double averageTenure;

    public CountrySalaryStatsDTO(String countryName, Long employeeCount, Double averageSalary, BigDecimal maxSalary, BigDecimal minSalary, Double averageTenure) {
        this.countryName = countryName;
        this.employeeCount = employeeCount;
        this.averageSalary = averageSalary;
        this.maxSalary = maxSalary;
        this.minSalary = minSalary;
        this.averageTenure = averageTenure;
    }

    public String getCountryName() { return countryName; }
    public Long getEmployeeCount() { return employeeCount; }
    public Double getAverageSalary() { return averageSalary; }
    public BigDecimal getMaxSalary() { return maxSalary; }
    public BigDecimal getMinSalary() { return minSalary; }
    public Double getAverageTenure() { return averageTenure; }
}
