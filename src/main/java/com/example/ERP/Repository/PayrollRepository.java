package com.example.ERP.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ERP.Models.Payroll;

public interface PayrollRepository extends JpaRepository<Payroll,Long> {
    
}
