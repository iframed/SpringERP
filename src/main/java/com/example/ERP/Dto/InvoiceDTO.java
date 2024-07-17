package com.example.ERP.Dto;

import java.time.LocalDate;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InvoiceDTO {
    private Long id;
    private String codeFacture;
    private String codeBC;
    private LocalDate dateFacture;
    private LocalDate dateExigibilite;
    private LocalDate dateEcheance;
    private String modalitePaiement;
    private boolean clientAssure;
    private Long clientId;
    private List<Long> invoiceItemIds;
}
