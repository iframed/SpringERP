package com.example.ERP.Dto;

import java.time.LocalDate;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuoteDTO {
    private Long id;
    private LocalDate date;
    private String code;
    private String revision;
    private String objet;
    private boolean actif;
    private boolean valide;
    private String statut;
    private Double montant;
    private String nature;
    private String projet;
    private Long clientId;
    private List<Long> quoteItemIds;
}
