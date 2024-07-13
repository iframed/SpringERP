package com.example.ERP.Mappers;

import org.springframework.stereotype.Component;

import com.example.ERP.Dto.PurchaseOrderItemDTO;
import com.example.ERP.Models.PurchaseOrderItem;

@Component
public class PurchaseOrderItemMapper {
    public static PurchaseOrderItemDTO toDTO(PurchaseOrderItem purchaseOrderItem) {
        return new PurchaseOrderItemDTO(
                purchaseOrderItem.getId(),
                purchaseOrderItem.getQuantity(),
                purchaseOrderItem.getPurchaseOrder() != null ? purchaseOrderItem.getPurchaseOrder().getId() : null,
                purchaseOrderItem.getProduct() != null ? purchaseOrderItem.getProduct().getId() : null
        );
    }

    public static PurchaseOrderItem toEntity(PurchaseOrderItemDTO purchaseOrderItemDTO) {
        PurchaseOrderItem purchaseOrderItem = new PurchaseOrderItem();
        purchaseOrderItem.setId(purchaseOrderItemDTO.getId());
        purchaseOrderItem.setQuantity(purchaseOrderItemDTO.getQuantity());
        // purchaseOrder and product should be set by service layer or ORM relationships
        return purchaseOrderItem;
    }
}
