package com.myhotel.employees.dto;

import java.math.BigDecimal;

public class SalarySegmentDTO {
    private Long segmentoA;
    private Long segmentoB;
    private Long segmentoC;

    public SalarySegmentDTO(Long segmentoA, Long segmentoB, Long segmentoC) {
        this.segmentoA = segmentoA;
        this.segmentoB = segmentoB;
        this.segmentoC = segmentoC;
    }

    public Long getSegmentoA() { return segmentoA; }
    public Long getSegmentoB() { return segmentoB; }
    public Long getSegmentoC() { return segmentoC; }
}
