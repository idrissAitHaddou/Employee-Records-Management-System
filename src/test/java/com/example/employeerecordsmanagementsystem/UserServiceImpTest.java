package com.example.employeerecordsmanagementsystem;

import com.example.employeerecordsmanagementsystem.entities.Role;
import com.example.employeerecordsmanagementsystem.entities.user.User;
import com.example.employeerecordsmanagementsystem.mapper.user.UserMapper;
import com.example.employeerecordsmanagementsystem.repositories.user.UserRepository;
import com.example.employeerecordsmanagementsystem.services.user.UserServiceImp;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UserServiceImpTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImp userServiceImp;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void loadUserByUsername_UserExists_ReturnsUserDetails() {
        User user = new User();
        user.setUsername("idriss");
        user.setPassword("123");
        Role role = new Role();
        role.setName("ROLE_RH");
        user.setRole(role);
        when(userRepository.findByUsername("idriss")).thenReturn(user);
        var userDetails = userServiceImp.loadUserByUsername("idriss");
        assertNotNull(userDetails);
        assertEquals("idriss", userDetails.getUsername());
        assertEquals("123", userDetails.getPassword());
    }

    @Test
    void loadUserByUsername_UserDoesNotExist_ThrowsException() {
        when(userRepository.findByUsername("ali")).thenReturn(null);
        assertThrows(UsernameNotFoundException.class, () -> userServiceImp.loadUserByUsername("ali"));
    }

    @Test
    void deleteUser_UserExists_ReturnsTrue() {
        when(userRepository.existsById(1L)).thenReturn(true);
        boolean result = userServiceImp.deleteUser(1L);
        assertTrue(result);
        verify(userRepository, times(1)).deleteById(1L);
    }

    @Test
    void deleteUser_UserDoesNotExist_ReturnsFalse() {
        when(userRepository.existsById(1L)).thenReturn(false);
        boolean result = userServiceImp.deleteUser(1L);
        assertFalse(result);
        verify(userRepository, never()).deleteById(anyLong());
    }
}

