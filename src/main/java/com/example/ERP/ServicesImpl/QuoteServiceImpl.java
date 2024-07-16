package com.example.ERP.ServicesImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ERP.Dto.QuoteDTO;
import com.example.ERP.Mappers.QuoteMapper;
import com.example.ERP.Models.Client;
import com.example.ERP.Models.Quote;
import com.example.ERP.Repository.QuoteRepository;
import com.example.ERP.Services.QuoteService;


@Service
public class QuoteServiceImpl implements QuoteService {

    @Autowired
    private QuoteRepository quoteRepository;

    @Override
    public QuoteDTO createQuote(QuoteDTO quoteDTO) {
        Quote quote = QuoteMapper.toEntity(quoteDTO);
        Quote savedQuote = quoteRepository.save(quote);
        return QuoteMapper.toDTO(savedQuote);
    }

    @Override
    public QuoteDTO updateQuote(Long id, QuoteDTO quoteDTO) {
        Quote quote = quoteRepository.findById(id).orElseThrow(() -> new RuntimeException("Quote not found"));
        quote.setDate(quoteDTO.getDate());
        quote.setCode(quoteDTO.getCode());
        quote.setRevision(quoteDTO.getRevision());
        quote.setObjet(quoteDTO.getObjet());
        quote.setActif(quoteDTO.isActif());
        quote.setValide(quoteDTO.isValide());
        quote.setStatut(quoteDTO.getStatut());
        quote.setMontant(quoteDTO.getMontant());
        quote.setNature(quoteDTO.getNature());
        quote.setProjet(quoteDTO.getProjet());

        if (quoteDTO.getClientId() != null) {
            Client client = new Client();
            client.setId(quoteDTO.getClientId());
            quote.setClient(client);
        }

        Quote updatedQuote = quoteRepository.save(quote);
        return QuoteMapper.toDTO(updatedQuote);
    }

    @Override
    public void deleteQuote(Long id) {
        quoteRepository.deleteById(id);
    }

    @Override
    public QuoteDTO getQuoteById(Long id) {
        Quote quote = quoteRepository.findById(id).orElseThrow(() -> new RuntimeException("Quote not found"));
        return QuoteMapper.toDTO(quote);
    }

    @Override
    public List<QuoteDTO> getAllQuotes() {
        return quoteRepository.findAll().stream().map(QuoteMapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public List<QuoteDTO> searchQuotes(String code, String revision, String objet, Boolean actif, Boolean valide, String statut, Double montant, String nature, String projet, Long clientId) {
        List<Quote> quotes = quoteRepository.searchQuotes(code, revision, objet, actif, valide, statut, montant, nature, projet, clientId);
        return quotes.stream().map(QuoteMapper::toDTO).collect(Collectors.toList());
    }
}
