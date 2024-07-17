package com.example.ERP.Mappers;

import org.springframework.stereotype.Component;

import com.example.ERP.Dto.InvoiceItemDTO;
import com.example.ERP.Models.InvoiceItem;

@Component
public class InvoiceItemMapper {
    public static InvoiceItemDTO toDTO(InvoiceItem invoiceItem) {
        return new InvoiceItemDTO(
            invoiceItem.getId(),
            invoiceItem.getInvoice() != null ? invoiceItem.getInvoice().getId() : null,
            invoiceItem.getProduct() != null ? invoiceItem.getProduct().getId() : null,
            invoiceItem.getQuantity(),
            invoiceItem.getUnitPrice()
        );
    }

    public static InvoiceItem toEntity(InvoiceItemDTO invoiceItemDTO) {
        InvoiceItem invoiceItem = new InvoiceItem();
        invoiceItem.setId(invoiceItemDTO.getId());
        invoiceItem.setQuantity(invoiceItemDTO.getQuantity());
        invoiceItem.setUnitPrice(invoiceItemDTO.getUnitPrice());
        // invoice and product should be set by service layer or ORM relationships
        return invoiceItem;
    }
}
