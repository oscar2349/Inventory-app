package com.example.inventory.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Equipment {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String type;
    @Column(unique = true)
    private String serial;
    private LocalDate entryDate;
    private Boolean active;
    private String user;
    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;
    // getters y setters
}