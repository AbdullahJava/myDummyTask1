package com.example.liquebasedemo.payload;

import com.example.liquebasedemo.dto.EmployeeDto;
import com.example.liquebasedemo.entity.Employee;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeResponse {
    private List<EmployeeDto> content;
    private int page;
    private int size;
    private int currentPage;
    private long totalElements;
    private int totalPages;
}
