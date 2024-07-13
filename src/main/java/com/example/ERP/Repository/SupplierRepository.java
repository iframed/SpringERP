package com.example.ERP.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ERP.Models.Supplier;

public interface SupplierRepository  extends JpaRepository<Supplier,Long> {
    
}
