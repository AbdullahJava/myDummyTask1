package com.example.liquebasedemo.controller;

import com.example.liquebasedemo.dto.EmployeeDto;
import com.example.liquebasedemo.handler.EmployeeHandler;
import com.example.liquebasedemo.payload.EmployeeResponse;
import com.example.liquebasedemo.utils.AppConstants;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/employee")
@AllArgsConstructor
public class EmployeeController {

    private EmployeeHandler employeeHandler;

    @GetMapping("/employees")
    public EmployeeResponse getAllPosts(
            @RequestParam(value = "address", required = false) String address,
            @RequestParam(value = "page", defaultValue = AppConstants.DEFAULT_PAGE_NUMBER, required = false) int pageNo,
            @RequestParam(value = "size", defaultValue = AppConstants.DEFAULT_PAGE_SIZE, required = false) int pageSize,
            @RequestParam(value = "sortBy", defaultValue = AppConstants.DEFAULT_SORT_BY, required = false) String sortBy,
            @RequestParam(value = "sortDir", defaultValue = AppConstants.DEFAULT_SORT_DIRECTION, required = false) String sortDir
    ){
        return employeeHandler.getAllEmployees(address, pageNo, pageSize, sortBy, sortDir);
    }

    @PostMapping("/insert")
    public ResponseEntity<EmployeeDto> saveEmployee(@RequestBody EmployeeDto employeeDto){

        return employeeHandler.saveEmployee(employeeDto);

    }




}
