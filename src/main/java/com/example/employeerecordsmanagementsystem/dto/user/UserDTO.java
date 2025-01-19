package com.example.employeerecordsmanagementsystem.dto.user;

import com.example.employeerecordsmanagementsystem.dto.RoleDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    @ManyToOne
    @JoinColumn(name = "role_id")
    private RoleDTO role;
    @OneToOne
    @JoinColumn(name = "employee_id")
    private EmployeeDTO employee;

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public RoleDTO getRole() {
        return role;
    }

    public EmployeeDTO getEmployee() {
        return employee;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRole(RoleDTO role) {
        this.role = role;
    }

    public void setEmployee(EmployeeDTO employee) {
        this.employee = employee;
    }
}