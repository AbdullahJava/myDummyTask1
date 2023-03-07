package com.example.liquebasedemo.handler;

import com.example.liquebasedemo.dto.EmployeeDto;
import com.example.liquebasedemo.entity.Employee;
import com.example.liquebasedemo.mapper.EmployeeMapper;
import com.example.liquebasedemo.payload.EmployeeResponse;
import com.example.liquebasedemo.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class EmployeeHandler {

    private EmployeeMapper employeeMapper;
    private EmployeeService employeeService;


    public EmployeeResponse getAllEmployees(String address, int page, int size, String sortBy, String sortDir) {

        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending()
                : Sort.by(sortBy).descending();

        List<Employee> employees = new ArrayList<Employee>();
        Pageable pagingSort = PageRequest.of(page, size, sort);

        Page<Employee> pageTuts;
        if (address == null)
            pageTuts = employeeService.getAll(pagingSort);
        else
            pageTuts = employeeService.findByAddressContaining(address, pagingSort);

        employees = pageTuts.getContent();


        List<EmployeeDto> employeeDtos = employees.stream().map(employee -> employeeMapper.ToDto(employee)).collect(Collectors.toList());

        EmployeeResponse employeeResponse = new EmployeeResponse();

        employeeResponse.setContent(employeeDtos);
        employeeResponse.setPage(pageTuts.getNumber());
        employeeResponse.setSize(pageTuts.getSize());
        employeeResponse.setTotalElements(pageTuts.getTotalElements());
        employeeResponse.setTotalPages(pageTuts.getTotalPages());

        return employeeResponse;

    }

    public ResponseEntity<EmployeeDto> saveEmployee(EmployeeDto employeeDto){

        Employee employee = employeeMapper.ToEntity(employeeDto);

        EmployeeDto dto = employeeMapper.ToDto(employeeService.save(employee));

        return ResponseEntity.ok(dto);

    }
}
