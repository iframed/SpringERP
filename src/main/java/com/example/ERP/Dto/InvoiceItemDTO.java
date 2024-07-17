package com.example.ERP.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class InvoiceItemDTO {
    private Long id;
    private Long invoiceId;
    private Long productId;
    private int quantity;
    private double unitPrice;
}
