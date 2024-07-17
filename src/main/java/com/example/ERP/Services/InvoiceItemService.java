package com.example.ERP.Services;

import java.util.List;

import com.example.ERP.Dto.InvoiceItemDTO;

public interface InvoiceItemService {
    
    InvoiceItemDTO createInvoiceItem(InvoiceItemDTO invoiceItemDTO);
    InvoiceItemDTO updateInvoiceItem(Long id, InvoiceItemDTO invoiceItemDTO);
    void deleteInvoiceItem(Long id);
    InvoiceItemDTO getInvoiceItemById(Long id);
    List<InvoiceItemDTO> getAllInvoiceItems();
    List<InvoiceItemDTO> getAllInvoiceItemsByInvoiceId(Long invoiceId);
}
