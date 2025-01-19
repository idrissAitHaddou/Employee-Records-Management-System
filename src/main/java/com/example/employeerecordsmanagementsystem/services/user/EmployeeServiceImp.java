package com.example.employeerecordsmanagementsystem.services.user;

import com.example.employeerecordsmanagementsystem.dto.user.EmployeeDTO;
import com.example.employeerecordsmanagementsystem.entities.user.Employee;
import com.example.employeerecordsmanagementsystem.mapper.user.EmployeeMapper;
import com.example.employeerecordsmanagementsystem.repositories.user.EmployeeRepository;
import com.example.employeerecordsmanagementsystem.services.interfaces.user.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImp implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public EmployeeDTO saveEmployee(EmployeeDTO employeeDTO) {
        Employee employee = EmployeeMapper.INSTANCE.employeeDTOToEmployee(employeeDTO);
        Employee savedEmployee = employeeRepository.save(employee);
        return EmployeeMapper.INSTANCE.employeeToEmployeeDTO(savedEmployee);
    }

    @Override
    public List<EmployeeDTO> findEmployeesByDepartment(String department) {
        List<Employee> employees = employeeRepository.findByDepartment(department);
        return employees.stream()
                .map(EmployeeMapper.INSTANCE::employeeToEmployeeDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<EmployeeDTO> findEmployeesByStatus(String status) {
        List<Employee> employees = employeeRepository.findByEmploymentStatus(status);
        return employees.stream()
                .map(EmployeeMapper.INSTANCE::employeeToEmployeeDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<EmployeeDTO> findEmployeeById(Long id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        return employee.map(EmployeeMapper.INSTANCE::employeeToEmployeeDTO);
    }

    @Override
    public Boolean deleteEmployee(Long id) {
        if (employeeRepository.existsById(id)) {
            employeeRepository.deleteById(id);
            return true;
        }
        return false;
    }
}


