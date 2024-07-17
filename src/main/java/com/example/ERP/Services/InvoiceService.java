package com.example.ERP.Services;

import java.time.LocalDate;
import java.util.List;

import com.example.ERP.Dto.InvoiceDTO;

public interface InvoiceService {
    
    InvoiceDTO createInvoice(InvoiceDTO invoiceDTO);
    InvoiceDTO updateInvoice(Long id, InvoiceDTO invoiceDTO);
    void deleteInvoice(Long id);
    InvoiceDTO getInvoiceById(Long id);
    List<InvoiceDTO> getAllInvoices();
   



    List<InvoiceDTO> searchInvoices(String codeFacture, String codeBC, LocalDate dateFacture, LocalDate dateExigibilite, LocalDate dateEcheance, String modalitePaiement, Boolean clientAssure, Long clientId);
}
