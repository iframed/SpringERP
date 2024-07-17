package com.example.ERP.Repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.ERP.Models.Invoice;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
    
    @Query("SELECT i FROM Invoice i LEFT JOIN FETCH i.invoiceItems WHERE " +
    "(:codeFacture IS NULL OR i.codeFacture LIKE %:codeFacture%) AND " +
    "(:codeBC IS NULL OR i.codeBC LIKE %:codeBC%) AND " +
    "(:dateFacture IS NULL OR i.dateFacture = :dateFacture) AND " +
    "(:dateExigibilite IS NULL OR i.dateExigibilite = :dateExigibilite) AND " +
    "(:dateEcheance IS NULL OR i.dateEcheance = :dateEcheance) AND " +
    "(:modalitePaiement IS NULL OR i.modalitePaiement LIKE %:modalitePaiement%) AND " +
    "(:clientAssure IS NULL OR i.clientAssure = :clientAssure) AND " +
    "(:clientId IS NULL OR i.client.id = :clientId)")
List<Invoice> searchInvoices(@Param("codeFacture") String codeFacture,
                          @Param("codeBC") String codeBC,
                          @Param("dateFacture") LocalDate dateFacture,
                          @Param("dateExigibilite") LocalDate dateExigibilite,
                          @Param("dateEcheance") LocalDate dateEcheance,
                          @Param("modalitePaiement") String modalitePaiement,
                          @Param("clientAssure") Boolean clientAssure,
                          @Param("clientId") Long clientId);
}
