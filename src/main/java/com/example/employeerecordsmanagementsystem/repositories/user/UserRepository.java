package com.example.employeerecordsmanagementsystem.repositories.user;

import com.example.employeerecordsmanagementsystem.entities.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
