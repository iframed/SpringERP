package com.example.ERP.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ERP.Models.PurchaseOrder;

public interface PurchaseOrderRepository extends JpaRepository<PurchaseOrder,Long> {
    
}
