package com.example.liquebasedemo.service;

import com.example.liquebasedemo.entity.Employee;
import com.example.liquebasedemo.repo.EmployeeRepo;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmployeeService {

    private EmployeeRepo employeeRepo;

    public Employee save(Employee employee) {

        return employeeRepo.save(employee);
    }

    public Page<Employee> getAll(Pageable pageable) {
        return employeeRepo.findAll(pageable);
    }

    public Page<Employee> findByAddressContaining(String address, Pageable pageable) {
        return employeeRepo.findByAddressContaining(address, pageable);
    }

    public Employee findById (Long id) {
        return employeeRepo.findById(id).orElse(null);
    }

}
