package com.example.ERP.Repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.ERP.Models.GoodsReceipt;

@Repository
public interface GoodsReceiptRepository extends JpaRepository<GoodsReceipt,Long> {
    
    @Query("SELECT gr FROM GoodsReceipt gr WHERE " +
           "(:codeBL IS NULL OR gr.codeBL = :codeBL) AND " +
           "(:codeBC IS NULL OR gr.codeBC = :codeBC) AND " +
           "(:type IS NULL OR gr.type = :type) AND " +
           "(:codeProjet IS NULL OR gr.codeProjet = :codeProjet) AND " +
           "(:status IS NULL OR gr.status = :status) AND " +
           "(:clientId IS NULL OR gr.client.id = :clientId) AND " +
           "(:purchaseOrderId IS NULL OR gr.purchaseOrder.id = :purchaseOrderId) AND " +
           "(:startDate IS NULL OR gr.receiptDate >= :startDate) AND " +
           "(:endDate IS NULL OR gr.receiptDate <= :endDate)")
    List<GoodsReceipt> searchGoodsReceipts(@Param("codeBL") String codeBL,
                                           @Param("codeBC") String codeBC,
                                           @Param("type") String type,
                                           @Param("codeProjet") String codeProjet,
                                           @Param("status") String status,
                                           @Param("clientId") Long clientId,
                                           @Param("purchaseOrderId") Long purchaseOrderId,
                                           @Param("startDate") LocalDate startDate,
                                           @Param("endDate") LocalDate endDate);
}