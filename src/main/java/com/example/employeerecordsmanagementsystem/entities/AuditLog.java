package com.example.employeerecordsmanagementsystem.entities;

import com.example.employeerecordsmanagementsystem.entities.user.User;
import jakarta.persistence.*;

import java.util.Date;

@Entity
public class AuditLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    private String action;
    private Date createdAt;
    private String details;

    public Long getId() {
        return id;
    }

    public User getUser() {
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

    public void setUser(User user) {
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
