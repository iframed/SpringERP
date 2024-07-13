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
                purchaseOrder.getSupplier() != null ? purchaseOrder.getSupplier().getId() : null,
                purchaseOrder.getPurchaseOrderItems() != null ? purchaseOrder.getPurchaseOrderItems().stream().map(PurchaseOrderItem::getId).collect(Collectors.toList()) : null,
                purchaseOrder.getGoodsReceipts() != null ? purchaseOrder.getGoodsReceipts().stream().map(GoodsReceipt::getId).collect(Collectors.toList()) : null
        );
    }

    public static PurchaseOrder toEntity(PurchaseOrderDTO purchaseOrderDTO) {
        PurchaseOrder purchaseOrder = new PurchaseOrder();
        purchaseOrder.setId(purchaseOrderDTO.getId());
        purchaseOrder.setOrderDate(purchaseOrderDTO.getOrderDate());
        purchaseOrder.setStatus(purchaseOrderDTO.getStatus());
        // supplier, purchaseOrderItems, goodsReceipts should be set by service layer or ORM relationships
        return purchaseOrder;
    }
}
