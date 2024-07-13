package com.example.ERP.Mappers;

import org.springframework.stereotype.Component;

import com.example.ERP.Dto.AuditLogDTO;
import com.example.ERP.Models.AuditLog;

@Component
public class AuditLogMapper {
    public static AuditLogDTO toDTO(AuditLog auditLog) {
        return new AuditLogDTO(
                auditLog.getId(),
                auditLog.getAction(),
                auditLog.getUsername(),
                auditLog.getTimestamp()
        );
    }

    public static AuditLog toEntity(AuditLogDTO auditLogDTO) {
        AuditLog auditLog = new AuditLog();
        auditLog.setId(auditLogDTO.getId());
        auditLog.setAction(auditLogDTO.getAction());
        auditLog.setUsername(auditLogDTO.getUsername());
        auditLog.setTimestamp(auditLogDTO.getTimestamp());
        return auditLog;
    }
}
