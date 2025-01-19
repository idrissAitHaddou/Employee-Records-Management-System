package com.example.employeerecordsmanagementsystem.controllers;

import com.example.employeerecordsmanagementsystem.dto.RoleDTO;
import com.example.employeerecordsmanagementsystem.services.interfaces.RoleService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/roles")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @Operation(summary = "Create New Role")
    @PostMapping
    public ResponseEntity<RoleDTO> saveRole(@RequestBody RoleDTO roleDTO) {
        RoleDTO role = roleService.saveRole(roleDTO);
        return new ResponseEntity<>(role, HttpStatus.CREATED);
    }

    @Operation(summary = "Get Role By ID")
    @GetMapping("/{id}")
    public ResponseEntity<RoleDTO> getRoleById(@PathVariable Long id) {
        Optional<RoleDTO> roleDTO = roleService.findRoleById(id);
        return roleDTO.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Operation(summary = "Delete Role By ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRole(@PathVariable Long id) {
        roleService.deleteRole(id);
        return ResponseEntity.noContent().build();
    }
}

