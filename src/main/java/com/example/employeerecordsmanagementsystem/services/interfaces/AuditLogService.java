package com.example.employeerecordsmanagementsystem.services.interfaces;

import com.example.employeerecordsmanagementsystem.dto.AuditLogDTO;
import java.util.List;
import java.util.Optional;

public interface AuditLogService {
    AuditLogDTO saveAuditLog(AuditLogDTO auditLog);
    List<AuditLogDTO> findAuditLogsByUserId(Long userId);
    Optional<AuditLogDTO> findAuditLogsById(Long id);
}
