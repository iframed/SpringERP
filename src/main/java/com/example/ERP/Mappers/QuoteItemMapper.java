package com.example.ERP.Mappers;

import org.springframework.stereotype.Component;

import com.example.ERP.Dto.QuoteItemDTO;
import com.example.ERP.Models.QuoteItem;


@Component
public class QuoteItemMapper {
    public static QuoteItemDTO toDTO(QuoteItem quoteItem) {
        return new QuoteItemDTO(
                quoteItem.getId(),
                quoteItem.getQuantity(),
                quoteItem.getPrice(),
                quoteItem.getQuote() != null ? quoteItem.getQuote().getId() : null,
                quoteItem.getProduct() != null ? quoteItem.getProduct().getId() : null
        );
    }

    public static QuoteItem toEntity(QuoteItemDTO quoteItemDTO) {
        QuoteItem quoteItem = new QuoteItem();
        quoteItem.setId(quoteItemDTO.getId());
        quoteItem.setQuantity(quoteItemDTO.getQuantity());
        quoteItem.setPrice(quoteItemDTO.getPrice());
        // quote and product should be set by service layer or ORM relationships
        return quoteItem;
    }
}

