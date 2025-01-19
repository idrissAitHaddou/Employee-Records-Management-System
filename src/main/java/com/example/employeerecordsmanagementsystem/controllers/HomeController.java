package com.example.employeerecordsmanagementsystem.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    // just to test if the app is run
    @GetMapping("/")
    public String home() {
        return "Welcome to the Spring Boot Application !";
    }
}
