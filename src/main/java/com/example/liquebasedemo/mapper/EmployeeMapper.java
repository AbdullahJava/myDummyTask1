package com.example.liquebasedemo.mapper;

import com.example.liquebasedemo.dto.EmployeeDto;
import com.example.liquebasedemo.entity.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {

    EmployeeDto ToDto (Employee employeeEntity);

    List<EmployeeDto> ToDto (List<Employee> employeeEntity);

    Employee ToEntity (EmployeeDto employeeDto);

    Employee ToUpdate (EmployeeDto employeeDto, @MappingTarget Employee employee);

}
