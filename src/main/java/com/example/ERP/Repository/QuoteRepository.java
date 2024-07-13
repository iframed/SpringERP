package com.example.ERP.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ERP.Models.Quote;

public interface QuoteRepository extends JpaRepository<Quote,Long> {
    
}
