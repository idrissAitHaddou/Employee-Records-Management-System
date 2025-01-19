package com.example.employeerecordsmanagementsystem.services.interfaces.user;

import com.example.employeerecordsmanagementsystem.dto.user.UserDTO;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.Optional;

public interface UserService {
    UserDetails loadUserByUsername(String username);
    UserDTO saveUser(UserDTO user);
    Optional<UserDTO> findUserById(Long id);
    boolean deleteUser(Long id);
}
