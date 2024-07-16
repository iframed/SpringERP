package com.example.ERP.Mappers;

import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.example.ERP.Dto.QuoteDTO;
import com.example.ERP.Models.Client;
import com.example.ERP.Models.Quote;
import com.example.ERP.Models.QuoteItem;

@Component
public class QuoteMapper {
    public static QuoteDTO toDTO(Quote quote) {
        return new QuoteDTO(
            quote.getId(),
            quote.getDate(),
            quote.getCode(),
            quote.getRevision(),
            quote.getObjet(),
            quote.isActif(),
            quote.isValide(),
            quote.getStatut(),
            quote.getMontant(),
            quote.getNature(),
            quote.getProjet(),
            quote.getClient() != null ? quote.getClient().getId() : null,
            quote.getQuoteItems() != null ? quote.getQuoteItems().stream().map(QuoteItem::getId).collect(Collectors.toList()) : null
        );

    }

    public static Quote toEntity(QuoteDTO quoteDTO) {
        Quote quote = new Quote();
        quote.setId(quoteDTO.getId());
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

        return quote;
    }
}
