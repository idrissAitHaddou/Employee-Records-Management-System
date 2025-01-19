package com.example.employeerecordsmanagementsystem.controllers.authentication;

import com.example.employeerecordsmanagementsystem.request.authentication.AuthenticationRegidterRequest;
import com.example.employeerecordsmanagementsystem.request.authentication.AuthenticationRequest;
import com.example.employeerecordsmanagementsystem.response.authentication.AuthenticationResponse;
import com.example.employeerecordsmanagementsystem.services.interfaces.authentication.AuthenticationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationService authenticationService;

    @Operation(summary = "Sign in and generate JWT token")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful authentication."),
            @ApiResponse(responseCode = "401", description = "Invalid credentials.")
    })
    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest authenticationRequest) {
        AuthenticationResponse authenticationResponse = authenticationService.authenticate(authenticationRequest);
        return ResponseEntity.ok(authenticationResponse);
    }

    @Operation(summary = "Sign up")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful authentication.")
    })
    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody AuthenticationRegidterRequest authenticationRequest) {
        authenticationService.register(authenticationRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body("User registered successfully");
    }
}

