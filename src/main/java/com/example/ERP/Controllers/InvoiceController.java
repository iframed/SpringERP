package com.example.ERP.Controllers;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.ERP.Dto.InvoiceDTO;
import com.example.ERP.Dto.InvoiceItemDTO;
import com.example.ERP.Services.InvoiceItemService;
import com.example.ERP.Services.InvoiceService;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/api/invoices")
public class InvoiceController {
    
    @Autowired
    private InvoiceService invoiceService;
    
    @Autowired
    private InvoiceItemService invoiceItemService;

    @PostMapping
    public ResponseEntity<InvoiceDTO> createInvoice(@RequestBody InvoiceDTO invoiceDTO) {
        InvoiceDTO createdInvoice = invoiceService.createInvoice(invoiceDTO);
        return ResponseEntity.ok(createdInvoice);
    }

    @PutMapping("/{id}")
    public ResponseEntity<InvoiceDTO> updateInvoice(@PathVariable Long id, @RequestBody InvoiceDTO invoiceDTO) {
        InvoiceDTO updatedInvoice = invoiceService.updateInvoice(id, invoiceDTO);
        return ResponseEntity.ok(updatedInvoice);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInvoice(@PathVariable Long id) {
        invoiceService.deleteInvoice(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<InvoiceDTO> getInvoiceById(@PathVariable Long id) {
        InvoiceDTO invoiceDTO = invoiceService.getInvoiceById(id);
        return ResponseEntity.ok(invoiceDTO);
    }

    @GetMapping
    public ResponseEntity<List<InvoiceDTO>> getAllInvoices() {
        List<InvoiceDTO> invoices = invoiceService.getAllInvoices();
        return ResponseEntity.ok(invoices);
    }

    @GetMapping("/search")
    public ResponseEntity<List<InvoiceDTO>> searchInvoices(
            @RequestParam(required = false) String codeFacture,
            @RequestParam(required = false) String codeBC,
            @RequestParam(required = false) LocalDate dateFacture,
            @RequestParam(required = false) LocalDate dateExigibilite,
            @RequestParam(required = false) LocalDate dateEcheance,
            @RequestParam(required = false) String modalitePaiement,
            @RequestParam(required = false) Boolean clientAssure,
            @RequestParam(required = false) Long clientId) {
        List<InvoiceDTO> invoices = invoiceService.searchInvoices(codeFacture, codeBC, dateFacture, dateExigibilite, dateEcheance, modalitePaiement, clientAssure, clientId);
        return ResponseEntity.ok(invoices);
    }

    @GetMapping("/{invoiceId}/items")
    public ResponseEntity<List<InvoiceItemDTO>> getInvoiceItems(@PathVariable Long invoiceId) {
        List<InvoiceItemDTO> items = invoiceItemService.getAllInvoiceItemsByInvoiceId(invoiceId);
        return ResponseEntity.ok(items);
    }
}
