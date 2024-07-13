package com.example.ERP.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ERP.Models.AuditLog;

public interface AuditLogRepository extends JpaRepository<AuditLog,Long> {
    
}
