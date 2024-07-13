package com.example.ERP.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ERP.Models.Shipment;

public interface ShipmentRepository extends JpaRepository<Shipment,Long> {
    
}
