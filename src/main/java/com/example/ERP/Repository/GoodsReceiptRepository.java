package com.example.ERP.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ERP.Models.GoodsReceipt;

@Repository
public interface GoodsReceiptRepository extends JpaRepository<GoodsReceipt,Long> {
    
}
