package com.myhotel.employees.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;
@Entity
@Table(name = "countries")
public class Country {

    @Id
    @Column(name = "COUNTRY_ID", length = 2)
    private String id;

    @Column(name = "COUNTRY_NAME", nullable = false)
    private String countryName;

    // Getters y Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getCountryName() { return countryName; }
    public void setCountryName(String countryName) { this.countryName = countryName; }
}
