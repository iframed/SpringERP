package com.example.ERP.Services;

import java.util.List;

import com.example.ERP.Dto.QuoteDTO;

public interface QuoteService {
    QuoteDTO createQuote(QuoteDTO quoteDTO);
    QuoteDTO updateQuote(Long id, QuoteDTO quoteDTO);
    void deleteQuote(Long id);
    QuoteDTO getQuoteById(Long id);
    List<QuoteDTO> getAllQuotes();
    List<QuoteDTO> searchQuotes(String code, String revision, String objet, Boolean actif, Boolean valide, String statut, Double montant, String nature, String projet, Long clientId);
}
