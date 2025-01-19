package com.example.employeerecordsmanagementsystem;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@OpenAPIDefinition(
        info = @Info(
                title = "Employee Records Management System API",
                version = "v1",
                description = "API for Employee Records Management System",
                contact = @Contact(name = "Idriss Ait Haddou", email = "idrissaithadou@gmail.com")
        )
)

@SpringBootApplication
public class EmployeeRecordsManagementSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmployeeRecordsManagementSystemApplication.class, args);
    }

}
