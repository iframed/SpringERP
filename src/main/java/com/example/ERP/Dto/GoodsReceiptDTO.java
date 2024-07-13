package com.example.ERP.Dto;

import java.time.LocalDate;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GoodsReceiptDTO {
    private Long id;
    private LocalDate receiptDate;
    private String status;
    private Long purchaseOrderId;
    private List<Long> goodsReceiptItemIds;
}
