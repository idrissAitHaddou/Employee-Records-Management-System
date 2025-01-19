package com.example.employeerecordsmanagementsystem.mapper;

import com.example.employeerecordsmanagementsystem.dto.AuditLogDTO;
import com.example.employeerecordsmanagementsystem.entities.AuditLog;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AuditLogMapper {
    AuditLogMapper INSTANCE = Mappers.getMapper(AuditLogMapper.class);

    AuditLogDTO auditLogToAuditLogDTO(AuditLog auditLog);
    AuditLog auditLogDTOToAuditLog(AuditLogDTO auditLogDTO);
}
