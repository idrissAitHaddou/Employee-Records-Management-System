package com.example.employeerecordsmanagementsystem.controllers;

import com.example.employeerecordsmanagementsystem.dto.AuditLogDTO;
import com.example.employeerecordsmanagementsystem.services.interfaces.AuditLogService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/audit-logs")
public class AuditLogController {

    @Autowired
    private AuditLogService auditLogService;

    @Operation(summary = "Create New Audit Log")
    @PostMapping("/save")
    public ResponseEntity<AuditLogDTO> saveAuditLog(@RequestBody AuditLogDTO auditLogDTO) {
        AuditLogDTO savedAuditLogDTO = auditLogService.saveAuditLog(auditLogDTO);
        return new ResponseEntity<>(savedAuditLogDTO, HttpStatus.CREATED);
    }

    @Operation(summary = "Get Audit Log By ID")
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<AuditLogDTO>> getAuditLogsByUserId(@PathVariable Long userId) {
        List<AuditLogDTO> auditLogDTOs = auditLogService.findAuditLogsByUserId(userId);
        return new ResponseEntity<>(auditLogDTOs, HttpStatus.OK);
    }

    @Operation(summary = "Find Audit Logs By Employee ID")
    @GetMapping("/{id}")
    public ResponseEntity<AuditLogDTO> findAuditLogsByEmployeeId(@PathVariable Long id) {
        Optional<AuditLogDTO> auditLogDTO = auditLogService.findAuditLogsById(id);
        return auditLogDTO
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}

