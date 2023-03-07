package com.example.liquebasedemo.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Id;

@Setter
@Getter
public class EmployeeDto {

    @Id
    private Long id;

    private String name;

    private Long phone;

    private String address;

}
