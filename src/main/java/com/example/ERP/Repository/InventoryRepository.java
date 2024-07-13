package com.example.ERP.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ERP.Models.Inventory;

public interface InventoryRepository extends JpaRepository<Inventory,Long> {
    
}
