package com.example.ERP.Dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuoteItemDTO {
    private Long id;
    private int quantity;
    private BigDecimal price;
    private Long quoteId;
    private Long productId;
}
