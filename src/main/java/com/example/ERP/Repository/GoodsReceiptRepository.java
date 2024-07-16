package com.example.ERP.Repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.stereotype.Repository;

import com.example.ERP.Models.GoodsReceipt;

@Repository
public interface GoodsReceiptRepository extends JpaRepository<GoodsReceipt,Long> {
    
    @Query("SELECT gr FROM GoodsReceipt gr WHERE " +
    "(:codeBL IS NULL OR gr.codeBL LIKE %:codeBL%) AND " +
    "(:codeBC IS NULL OR gr.codeBC LIKE %:codeBC%) AND " +
    "(:type IS NULL OR gr.type LIKE %:type%) AND " +
    "(:codeProjet IS NULL OR gr.codeProjet LIKE %:codeProjet%) AND " +
    "(:status IS NULL OR gr.status LIKE %:status%) AND " +
    "(:clientId IS NULL OR gr.client.id = :clientId) AND " +
    "(:startDate IS NULL OR gr.receiptDate >= :startDate) AND " +
    "(:endDate IS NULL OR gr.receiptDate <= :endDate)")
List<GoodsReceipt> searchGoodsReceipts(String codeBL, String codeBC, String type, String codeProjet, String status, Long clientId, LocalDate startDate, LocalDate endDate);
}