package com.example.ERP.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.ERP.Models.Quote;


@Repository
public interface QuoteRepository extends JpaRepository<Quote,Long> {
    
    @Query("SELECT q FROM Quote q WHERE " +
    "(:code IS NULL OR q.code LIKE %:code%) AND " +
    "(:revision IS NULL OR q.revision LIKE %:revision%) AND " +
    "(:objet IS NULL OR q.objet LIKE %:objet%) AND " +
    "(:actif IS NULL OR q.actif = :actif) AND " +
    "(:valide IS NULL OR q.valide = :valide) AND " +
    "(:statut IS NULL OR q.statut LIKE %:statut%) AND " +
    "(:montant IS NULL OR q.montant = :montant) AND " +
    "(:nature IS NULL OR q.nature LIKE %:nature%) AND " +
    "(:projet IS NULL OR q.projet LIKE %:projet%) AND " +
    "(:clientId IS NULL OR q.client.id = :clientId)")
List<Quote> searchQuotes(String code, String revision, String objet, Boolean actif, Boolean valide, String statut, Double montant, String nature, String projet, Long clientId);
}
