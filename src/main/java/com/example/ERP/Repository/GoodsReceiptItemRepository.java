package com.example.ERP.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ERP.Models.GoodsReceiptItem;

public interface GoodsReceiptItemRepository extends JpaRepository<GoodsReceiptItem,Long> {
    
}
