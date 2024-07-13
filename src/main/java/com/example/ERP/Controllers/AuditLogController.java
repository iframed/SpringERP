package com.example.ERP.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ERP.Dto.AuditLogDTO;
import com.example.ERP.Services.AuditLogService;

@RestController
@RequestMapping("/api/audit-logs")
public class AuditLogController {
    @Autowired
    private AuditLogService auditLogService;

    @PostMapping
    public ResponseEntity<AuditLogDTO> createAuditLog(@RequestBody AuditLogDTO auditLogDTO) {
        AuditLogDTO createdAuditLog = auditLogService.createAuditLog(auditLogDTO);
        return ResponseEntity.ok(createdAuditLog);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AuditLogDTO> updateAuditLog(@PathVariable Long id, @RequestBody AuditLogDTO auditLogDTO) {
        AuditLogDTO updatedAuditLog = auditLogService.updateAuditLog(id, auditLogDTO);
        return ResponseEntity.ok(updatedAuditLog);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAuditLog(@PathVariable Long id) {
        auditLogService.deleteAuditLog(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AuditLogDTO> getAuditLogById(@PathVariable Long id) {
        AuditLogDTO auditLogDTO = auditLogService.getAuditLogById(id);
        return ResponseEntity.ok(auditLogDTO);
    }

    @GetMapping
    public ResponseEntity<List<AuditLogDTO>> getAllAuditLogs() {
        List<AuditLogDTO> auditLogs = auditLogService.getAllAuditLogs();
        return ResponseEntity.ok(auditLogs);
    }
}
