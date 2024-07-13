package com.example.ERP.Mappers;

import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.example.ERP.Dto.QuoteDTO;
import com.example.ERP.Models.Quote;
import com.example.ERP.Models.QuoteItem;

@Component
public class QuoteMapper {
    public static QuoteDTO toDTO(Quote quote) {
        return new QuoteDTO(
                quote.getId(),
                quote.getQuoteDate(),
                quote.getStatus(),
                quote.getClient() != null ? quote.getClient().getId() : null,
                quote.getQuoteItems() != null ? quote.getQuoteItems().stream().map(QuoteItem::getId).collect(Collectors.toList()) : null
        );
    }

    public static Quote toEntity(QuoteDTO quoteDTO) {
        Quote quote = new Quote();
        quote.setId(quoteDTO.getId());
        quote.setQuoteDate(quoteDTO.getQuoteDate());
        quote.setStatus(quoteDTO.getStatus());
        // client and quoteItems should be set by service layer or ORM relationships
        return quote;
    }
}
