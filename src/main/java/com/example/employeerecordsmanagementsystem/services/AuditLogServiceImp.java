package com.example.employeerecordsmanagementsystem.services;

import com.example.employeerecordsmanagementsystem.dto.AuditLogDTO;
import com.example.employeerecordsmanagementsystem.entities.AuditLog;
import com.example.employeerecordsmanagementsystem.mapper.AuditLogMapper;
import com.example.employeerecordsmanagementsystem.repositories.AuditLogRepository;
import com.example.employeerecordsmanagementsystem.services.interfaces.AuditLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AuditLogServiceImp implements AuditLogService {

    @Autowired
    private AuditLogRepository auditLogRepository;

    public AuditLogDTO saveAuditLog(AuditLogDTO auditLogDTO) {
        AuditLog auditLog = AuditLogMapper.INSTANCE.auditLogDTOToAuditLog(auditLogDTO);
        AuditLog savedAuditLog = auditLogRepository.save(auditLog);
        return AuditLogMapper.INSTANCE.auditLogToAuditLogDTO(savedAuditLog);
    }

    public List<AuditLogDTO> findAuditLogsByUserId(Long userId) {
        List<AuditLog> auditLogs = auditLogRepository.findByUserId(userId);
        return auditLogs.stream()
                .map(AuditLogMapper.INSTANCE::auditLogToAuditLogDTO)
                .collect(Collectors.toList());
    }

    public Optional<AuditLogDTO> findAuditLogsById(Long id) {
        Optional<AuditLog> auditLog = auditLogRepository.findById(id);
        return auditLog.map(AuditLogMapper.INSTANCE::auditLogToAuditLogDTO);
    }
}

