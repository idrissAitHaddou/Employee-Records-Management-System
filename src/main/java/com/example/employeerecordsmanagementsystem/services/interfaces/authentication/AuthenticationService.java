package com.example.employeerecordsmanagementsystem.services.interfaces.authentication;

import com.example.employeerecordsmanagementsystem.request.authentication.AuthenticationRegidterRequest;
import com.example.employeerecordsmanagementsystem.request.authentication.AuthenticationRequest;
import com.example.employeerecordsmanagementsystem.response.authentication.AuthenticationResponse;

public interface AuthenticationService {
    AuthenticationResponse authenticate(AuthenticationRequest authenticationRequest);
    void register(AuthenticationRegidterRequest authenticationRequest);
}
