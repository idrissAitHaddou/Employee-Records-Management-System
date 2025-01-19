package com.example.employeerecordsmanagementsystem.dto;

import com.example.employeerecordsmanagementsystem.dto.user.UserDTO;
import jakarta.persistence.*;

import java.util.Date;

public class AuditLogDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserDTO user;
    private String action;
    private Date createdAt;
    private String details;

    public Long getId() {
        return id;
    }

    public UserDTO getUser() {
        return user;
    }

    public String getAction() {
        return action;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public String getDetails() {
        return details;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
