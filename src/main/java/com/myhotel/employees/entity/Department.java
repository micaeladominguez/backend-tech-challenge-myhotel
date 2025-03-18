package com.myhotel.employees.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "departments")
public class Department {

    @Id
    @Column(name = "DEPARTMENT_ID")
    private Long id;

    @Column(name = "DEPARTMENT_NAME", nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "LOCATION_ID", referencedColumnName = "LOCATION_ID")
    private Location location;

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Location getLocation() { return location; }
    public void setLocation(Location location) { this.location = location; }
}
