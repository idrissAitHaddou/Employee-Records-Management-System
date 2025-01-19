package com.example.employeerecordsmanagementsystem.mapper.user;

import com.example.employeerecordsmanagementsystem.dto.user.EmployeeDTO;
import com.example.employeerecordsmanagementsystem.entities.user.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EmployeeMapper {
    EmployeeMapper INSTANCE = Mappers.getMapper(EmployeeMapper.class);

    EmployeeDTO employeeToEmployeeDTO(Employee employee);
    Employee employeeDTOToEmployee(EmployeeDTO employeeDTO);
}
