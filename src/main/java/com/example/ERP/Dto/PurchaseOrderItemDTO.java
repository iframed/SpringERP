package com.example.ERP.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PurchaseOrderItemDTO {
    private Long id;
    private int quantity;
    private Long purchaseOrderId;
    private Long productId;
}