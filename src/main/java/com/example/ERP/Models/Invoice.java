package com.example.ERP.Models;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String codeFacture;
    private String codeBC;
    private LocalDate dateFacture;
    private LocalDate dateExigibilite;
    private LocalDate dateEcheance;
    private String modalitePaiement;
    private boolean clientAssure;

    @ManyToOne
    private Client client;

    @OneToMany(mappedBy = "invoice")
    private List<InvoiceItem> invoiceItems;
}
