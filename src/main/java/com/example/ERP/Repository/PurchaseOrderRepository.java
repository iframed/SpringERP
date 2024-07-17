package com.example.ERP.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.ERP.Models.PurchaseOrder;

@Repository
public interface PurchaseOrderRepository extends JpaRepository<PurchaseOrder,Long> {
    @Query("SELECT po FROM PurchaseOrder po WHERE " +
    "(:code IS NULL OR po.code = :code) AND " +
    "(:typeBC IS NULL OR po.typeBC = :typeBC) AND " +
    "(:projet IS NULL OR po.projet = :projet) AND " +
    "(:montant IS NULL OR po.montant = :montant) AND " +
    "(:fournisseur IS NULL OR po.fournisseur = :fournisseur) AND " +
    "(:supplierId IS NULL OR po.supplier.id = :supplierId)")
      List<PurchaseOrder> searchPurchaseOrders(
      @Param("code") String code,
      @Param("typeBC") String typeBC,
      @Param("projet") String projet,
      @Param("montant") Double montant,
      @Param("fournisseur") String fournisseur,
      @Param("supplierId") Long supplierId
);
}
