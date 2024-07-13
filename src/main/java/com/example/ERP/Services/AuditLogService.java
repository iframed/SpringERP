package com.example.ERP.Services;

import java.util.List;

import com.example.ERP.Dto.AuditLogDTO;

public interface AuditLogService {
    AuditLogDTO createAuditLog(AuditLogDTO auditLogDTO);
    AuditLogDTO updateAuditLog(Long id, AuditLogDTO auditLogDTO);
    void deleteAuditLog(Long id);
    AuditLogDTO getAuditLogById(Long id);
    List<AuditLogDTO> getAllAuditLogs();
}
