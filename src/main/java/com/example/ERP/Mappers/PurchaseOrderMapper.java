package com.example.ERP.Mappers;

import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.example.ERP.Dto.PurchaseOrderDTO;
import com.example.ERP.Models.GoodsReceipt;
import com.example.ERP.Models.PurchaseOrder;
import com.example.ERP.Models.PurchaseOrderItem;


@Component
public class PurchaseOrderMapper {
    public static PurchaseOrderDTO toDTO(PurchaseOrder purchaseOrder) {
        return new PurchaseOrderDTO(
            purchaseOrder.getId(),
            purchaseOrder.getOrderDate(),
            purchaseOrder.getStatus(),
            purchaseOrder.getCode(),
            purchaseOrder.getTypeBC(),
            purchaseOrder.getProjet(),
            purchaseOrder.getMontant(),
            purchaseOrder.getFournisseur(),
            purchaseOrder.getSupplier() != null ? purchaseOrder.getSupplier().getId() : null,
            purchaseOrder.getPurchaseOrderItems() != null ? purchaseOrder.getPurchaseOrderItems().stream().map(PurchaseOrderItem::getId).collect(Collectors.toList()) : null,
            purchaseOrder.getGoodsReceipts() != null ? purchaseOrder.getGoodsReceipts().stream().map(GoodsReceipt::getId).collect(Collectors.toList()) : null  // Add this line
        );
       
    }

    public static PurchaseOrder toEntity(PurchaseOrderDTO purchaseOrderDTO) {
        PurchaseOrder purchaseOrder = new PurchaseOrder();
        purchaseOrder.setId(purchaseOrderDTO.getId());
        purchaseOrder.setOrderDate(purchaseOrderDTO.getOrderDate());
        purchaseOrder.setStatus(purchaseOrderDTO.getStatus());
        purchaseOrder.setCode(purchaseOrderDTO.getCode());
        purchaseOrder.setTypeBC(purchaseOrderDTO.getTypeBC());
        purchaseOrder.setProjet(purchaseOrderDTO.getProjet());
        purchaseOrder.setMontant(purchaseOrderDTO.getMontant());
        purchaseOrder.setFournisseur(purchaseOrderDTO.getFournisseur());

        // supplier, purchaseOrderItems, goodsReceipts should be set by service layer or ORM relationships
        return purchaseOrder;
    }
}
