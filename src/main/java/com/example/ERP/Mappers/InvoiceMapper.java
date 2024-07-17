package com.example.ERP.Mappers;

import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.example.ERP.Dto.InvoiceDTO;
import com.example.ERP.Models.Client;
import com.example.ERP.Models.Invoice;
import com.example.ERP.Models.InvoiceItem;


@Component
public class InvoiceMapper {
    

    public static InvoiceDTO toDTO(Invoice invoice) {
        return new InvoiceDTO(
            invoice.getId(),
            invoice.getCodeFacture(),
            invoice.getCodeBC(),
            invoice.getDateFacture(),
            invoice.getDateExigibilite(),
            invoice.getDateEcheance(),
            invoice.getModalitePaiement(),
            invoice.isClientAssure(),
            invoice.getClient() != null ? invoice.getClient().getId() : null,
            invoice.getInvoiceItems() != null ? invoice.getInvoiceItems().stream().map(InvoiceItem::getId).collect(Collectors.toList()) : null
        );
    }


    public static Invoice toEntity(InvoiceDTO invoiceDTO) {
        Invoice invoice = new Invoice();
        invoice.setId(invoiceDTO.getId());
        invoice.setCodeFacture(invoiceDTO.getCodeFacture());
        invoice.setCodeBC(invoiceDTO.getCodeBC());
        invoice.setDateFacture(invoiceDTO.getDateFacture());
        invoice.setDateExigibilite(invoiceDTO.getDateExigibilite());
        invoice.setDateEcheance(invoiceDTO.getDateEcheance());
        invoice.setModalitePaiement(invoiceDTO.getModalitePaiement());
        invoice.setClientAssure(invoiceDTO.isClientAssure());

        if (invoiceDTO.getClientId() != null) {
            Client client = new Client();
            client.setId(invoiceDTO.getClientId());
            invoice.setClient(client);
        }

        return invoice;
    }
}
