package com.myhotel.employees.dto;

import java.math.BigDecimal;

public class DepartmentSalarySegmentDTO {
    private Long departmentId;
    private String departmentName;
    private Long segmentoA;
    private Long segmentoB;
    private Long segmentoC;

    public DepartmentSalarySegmentDTO(Long departmentId, String departmentName, Long segmentoA, Long segmentoB, Long segmentoC) {
        this.departmentId = departmentId;
        this.departmentName = departmentName;
        this.segmentoA = segmentoA;
        this.segmentoB = segmentoB;
        this.segmentoC = segmentoC;
    }

    public Long getDepartmentId() { return departmentId; }
    public String getDepartmentName() { return departmentName; }
    public Long getSegmentoA() { return segmentoA; }
    public Long getSegmentoB() { return segmentoB; }
    public Long getSegmentoC() { return segmentoC; }
}
