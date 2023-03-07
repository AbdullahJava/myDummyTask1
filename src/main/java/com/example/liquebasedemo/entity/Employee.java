package com.example.liquebasedemo.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "employee")
@Setter
@Getter
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private String editor;

    @Column
    private String name;

    @Column
    private Long phone;

    @Column
    private String address;

    @Column(name = "is_active")
    private Boolean isActive;
}
