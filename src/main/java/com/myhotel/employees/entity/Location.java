package com.myhotel.employees.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;

@Entity
@Table(name = "locations")
public class Location {

    @Id
    @Column(name = "LOCATION_ID")
    private Long id;

    @Column(name = "CITY", nullable = false)
    private String city;

    @ManyToOne
    @JoinColumn(name = "COUNTRY_ID", referencedColumnName = "COUNTRY_ID")
    private Country country;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }

    public Country getCountry() { return country; }
    public void setCountry(Country country) { this.country = country; }
}
