package com.example.ERP.Dto;

import java.time.LocalDate;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PurchaseOrderDTO {
    private Long id;
    private LocalDate orderDate;
    private String status;
    private Long supplierId;
    private List<Long> purchaseOrderItemIds;
    private List<Long> goodsReceiptIds;
}
