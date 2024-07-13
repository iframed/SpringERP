package com.example.ERP.ServicesImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ERP.Dto.QuoteDTO;
import com.example.ERP.Mappers.QuoteMapper;
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
        quote.setQuoteDate(quoteDTO.getQuoteDate());
        quote.setStatus(quoteDTO.getStatus());
        // Update other fields as necessary
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
}
