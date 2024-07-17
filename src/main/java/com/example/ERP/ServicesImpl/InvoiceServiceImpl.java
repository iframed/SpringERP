package com.example.ERP.ServicesImpl;



import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ERP.Dto.InvoiceDTO;
import com.example.ERP.Mappers.InvoiceMapper;
import com.example.ERP.Models.Client;
import com.example.ERP.Models.Invoice;
import com.example.ERP.Models.InvoiceItem;
import com.example.ERP.Repository.ClientRepository;
import com.example.ERP.Repository.InvoiceItemRepository;
import com.example.ERP.Repository.InvoiceRepository;
import com.example.ERP.Services.InvoiceService;



import java.time.LocalDate;


@Service
public class InvoiceServiceImpl  implements InvoiceService {

    @Autowired
    private InvoiceRepository invoiceRepository;

    @Autowired
    private InvoiceItemRepository invoiceItemRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public InvoiceDTO createInvoice(InvoiceDTO invoiceDTO) {
        Invoice invoice = InvoiceMapper.toEntity(invoiceDTO);

        if (invoiceDTO.getClientId() != null) {
            Client client = clientRepository.findById(invoiceDTO.getClientId())
                .orElseThrow(() -> new RuntimeException("Client not found"));
            invoice.setClient(client);
        }

        if (invoiceDTO.getInvoiceItemIds() != null) {
            List<InvoiceItem> invoiceItems = invoiceDTO.getInvoiceItemIds().stream()
                .map(id -> {
                    InvoiceItem item = invoiceItemRepository.findById(id)
                        .orElseThrow(() -> new RuntimeException("InvoiceItem not found"));
                    item.setInvoice(invoice); // Lié à l'Invoice
                    return item;
                })
                .collect(Collectors.toList());
            invoice.setInvoiceItems(invoiceItems);
        }

        Invoice savedInvoice = invoiceRepository.save(invoice);
        return InvoiceMapper.toDTO(savedInvoice);
    }
    @Override
    public InvoiceDTO updateInvoice(Long id, InvoiceDTO invoiceDTO) {
        Invoice invoice = invoiceRepository.findById(id).orElseThrow(() -> new RuntimeException("Invoice not found"));
        invoice.setCodeFacture(invoiceDTO.getCodeFacture());
        invoice.setCodeBC(invoiceDTO.getCodeBC());
        invoice.setDateFacture(invoiceDTO.getDateFacture());
        invoice.setDateExigibilite(invoiceDTO.getDateExigibilite());
        invoice.setDateEcheance(invoiceDTO.getDateEcheance());
        invoice.setModalitePaiement(invoiceDTO.getModalitePaiement());
        invoice.setClientAssure(invoiceDTO.isClientAssure());
        Invoice updatedInvoice = invoiceRepository.save(invoice);
        return InvoiceMapper.toDTO(updatedInvoice);
    }

    @Override
    public void deleteInvoice(Long id) {
        invoiceRepository.deleteById(id);
    }

    @Override
    public InvoiceDTO getInvoiceById(Long id) {
        Invoice invoice = invoiceRepository.findById(id).orElseThrow(() -> new RuntimeException("Invoice not found"));
        return InvoiceMapper.toDTO(invoice);
    }

    @Override
    public List<InvoiceDTO> getAllInvoices() {
        return invoiceRepository.findAll().stream().map(InvoiceMapper::toDTO).collect(Collectors.toList());
    }

   


   
    @Override
    public List<InvoiceDTO> searchInvoices(String codeFacture, String codeBC, LocalDate dateFacture, 
                                           LocalDate dateExigibilite, LocalDate dateEcheance, 
                                           String modalitePaiement, Boolean clientAssure, Long clientId) {
        List<Invoice> invoices = invoiceRepository.searchInvoices(codeFacture, codeBC, dateFacture, 
                                                                  dateExigibilite, dateEcheance, 
                                                                  modalitePaiement, clientAssure, clientId);
        return invoices.stream()
            .map(InvoiceMapper::toDTO)
            .collect(Collectors.toList());
    }
    
}

