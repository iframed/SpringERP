package com.example.ERP.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ERP.Models.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    
}
