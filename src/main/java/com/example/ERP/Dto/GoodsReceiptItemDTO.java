package com.example.ERP.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GoodsReceiptItemDTO {
    private Long id;
    private String productName;
    private Integer quantity;
    private Double price;
    private Long goodsReceiptId;
    private Long productId;
}