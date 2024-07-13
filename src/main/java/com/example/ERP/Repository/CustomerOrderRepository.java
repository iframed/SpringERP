package com.example.ERP.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ERP.Models.CustomerOrder;

@Repository
public interface CustomerOrderRepository extends JpaRepository<CustomerOrder,Long> {
    
}
