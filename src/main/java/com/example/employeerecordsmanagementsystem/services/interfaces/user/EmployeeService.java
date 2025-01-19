package com.example.employeerecordsmanagementsystem.services.interfaces.user;

import com.example.employeerecordsmanagementsystem.dto.user.EmployeeDTO;
import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    EmployeeDTO saveEmployee(EmployeeDTO employee);
    List<EmployeeDTO> findEmployeesByDepartment(String department);
    List<EmployeeDTO> findEmployeesByStatus(String status);
    Optional<EmployeeDTO> findEmployeeById(Long id);
    Boolean deleteEmployee(Long id);
}
