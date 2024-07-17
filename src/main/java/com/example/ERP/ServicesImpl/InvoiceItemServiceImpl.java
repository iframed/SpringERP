package com.example.ERP.ServicesImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ERP.Dto.InvoiceItemDTO;
import com.example.ERP.Mappers.InvoiceItemMapper;
import com.example.ERP.Models.InvoiceItem;
import com.example.ERP.Repository.InvoiceItemRepository;
import com.example.ERP.Services.InvoiceItemService;


@Service
public class InvoiceItemServiceImpl implements InvoiceItemService {

  
    @Autowired
    private InvoiceItemRepository invoiceItemRepository;

    @Override
    public InvoiceItemDTO createInvoiceItem(InvoiceItemDTO invoiceItemDTO) {
        InvoiceItem invoiceItem = InvoiceItemMapper.toEntity(invoiceItemDTO);
        InvoiceItem savedInvoiceItem = invoiceItemRepository.save(invoiceItem);
        return InvoiceItemMapper.toDTO(savedInvoiceItem);
    }

    @Override
    public InvoiceItemDTO updateInvoiceItem(Long id, InvoiceItemDTO invoiceItemDTO) {
        InvoiceItem invoiceItem = invoiceItemRepository.findById(id).orElseThrow(() -> new RuntimeException("InvoiceItem not found"));
        invoiceItem.setQuantity(invoiceItemDTO.getQuantity());
        invoiceItem.setUnitPrice(invoiceItemDTO.getUnitPrice());
        InvoiceItem updatedInvoiceItem = invoiceItemRepository.save(invoiceItem);
        return InvoiceItemMapper.toDTO(updatedInvoiceItem);
    }

    @Override
    public void deleteInvoiceItem(Long id) {
        invoiceItemRepository.deleteById(id);
    }

    @Override
    public InvoiceItemDTO getInvoiceItemById(Long id) {
        InvoiceItem invoiceItem = invoiceItemRepository.findById(id).orElseThrow(() -> new RuntimeException("InvoiceItem not found"));
        return InvoiceItemMapper.toDTO(invoiceItem);
    }

    @Override
    public List<InvoiceItemDTO> getAllInvoiceItems() {
        return invoiceItemRepository.findAll().stream().map(InvoiceItemMapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public List<InvoiceItemDTO> getAllInvoiceItemsByInvoiceId(Long invoiceId) {
        return invoiceItemRepository.findByInvoiceId(invoiceId).stream().map(InvoiceItemMapper::toDTO).collect(Collectors.toList());
    }
    
}
