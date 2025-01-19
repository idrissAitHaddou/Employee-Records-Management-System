package com.example.employeerecordsmanagementsystem.repositories.user;

import com.example.employeerecordsmanagementsystem.entities.user.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    List<Employee> findByDepartment(String department);
    List<Employee> findByEmploymentStatus(String employmentStatus);
}
