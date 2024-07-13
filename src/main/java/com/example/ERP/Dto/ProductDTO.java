package com.example.ERP.Dto;

import java.math.BigDecimal;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {
    private Long id;
    private String name;
    private BigDecimal price;
    private Long categoryId;
    private List<Long> inventoryIds;
    private List<Long> orderItemIds;
    private List<Long> quoteItemIds;
    private List<Long> purchaseOrderItemIds;
    private List<Long> goodsReceiptItemIds;
}
