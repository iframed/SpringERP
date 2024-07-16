package com.example.ERP.Models;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Quote {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @ManyToOne
    private Client client;

    @OneToMany(mappedBy = "quote", cascade = CascadeType.ALL)
    private List<QuoteItem> quoteItems;
}
