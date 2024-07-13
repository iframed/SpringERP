package com.example.ERP.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ERP.Models.Warehouse;

@Repository
public interface WarehouseRepository extends JpaRepository<Warehouse,Long>{
    
}
