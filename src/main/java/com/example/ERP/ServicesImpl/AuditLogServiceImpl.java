package com.example.ERP.ServicesImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ERP.Dto.AuditLogDTO;
import com.example.ERP.Mappers.AuditLogMapper;
import com.example.ERP.Models.AuditLog;
import com.example.ERP.Repository.AuditLogRepository;
import com.example.ERP.Services.AuditLogService;

@Service
public class AuditLogServiceImpl  implements AuditLogService {

    @Autowired
    private AuditLogRepository auditLogRepository;

    @Override
    public AuditLogDTO createAuditLog(AuditLogDTO auditLogDTO) {
        AuditLog auditLog = AuditLogMapper.toEntity(auditLogDTO);
        AuditLog savedAuditLog = auditLogRepository.save(auditLog);
        return AuditLogMapper.toDTO(savedAuditLog);
    }

    @Override
    public AuditLogDTO updateAuditLog(Long id, AuditLogDTO auditLogDTO) {
        AuditLog auditLog = auditLogRepository.findById(id).orElseThrow(() -> new RuntimeException("AuditLog not found"));
        auditLog.setAction(auditLogDTO.getAction());
        auditLog.setUsername(auditLogDTO.getUsername());
        auditLog.setTimestamp(auditLogDTO.getTimestamp());
        AuditLog updatedAuditLog = auditLogRepository.save(auditLog);
        return AuditLogMapper.toDTO(updatedAuditLog);
    }

    @Override
    public void deleteAuditLog(Long id) {
        auditLogRepository.deleteById(id);
    }

    @Override
    public AuditLogDTO getAuditLogById(Long id) {
        AuditLog auditLog = auditLogRepository.findById(id).orElseThrow(() -> new RuntimeException("AuditLog not found"));
        return AuditLogMapper.toDTO(auditLog);
    }

    @Override
    public List<AuditLogDTO> getAllAuditLogs() {
        return auditLogRepository.findAll().stream().map(AuditLogMapper::toDTO).collect(Collectors.toList());
    }
    
}
