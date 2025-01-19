package com.example.employeerecordsmanagementsystem.services.authentication;

import com.example.employeerecordsmanagementsystem.dto.user.UserDTO;
import com.example.employeerecordsmanagementsystem.request.authentication.AuthenticationRegidterRequest;
import com.example.employeerecordsmanagementsystem.request.authentication.AuthenticationRequest;
import com.example.employeerecordsmanagementsystem.response.authentication.AuthenticationResponse;
import com.example.employeerecordsmanagementsystem.security.config.JwtUtil;
import com.example.employeerecordsmanagementsystem.services.interfaces.authentication.AuthenticationService;
import com.example.employeerecordsmanagementsystem.services.interfaces.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImp implements AuthenticationService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserService userService;

    @Autowired
    private JwtUtil jwtUtil;

    public AuthenticationResponse authenticate(AuthenticationRequest authenticationRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authenticationRequest.getUsername(),
                        authenticationRequest.getPassword()
                )
        );
        UserDetails userDetails = userService.loadUserByUsername(authenticationRequest.getUsername());
        String jwtToken = jwtUtil.generateToken(userDetails);
        return new AuthenticationResponse(jwtToken);
    }

    public void register(AuthenticationRegidterRequest authenticationRequest) {
        UserDTO user = new UserDTO();
        user.setUsername(authenticationRequest.getUsername());
        user.setPassword(authenticationRequest.getPassword());
        userService.saveUser(user);
    }
}

