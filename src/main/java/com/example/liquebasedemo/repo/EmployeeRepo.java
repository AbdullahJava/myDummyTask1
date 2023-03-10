package com.example.liquebasedemo.repo;

import com.example.liquebasedemo.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Long> {

    Page<Employee> findByAddressContaining(String address, Pageable pageable);

}
