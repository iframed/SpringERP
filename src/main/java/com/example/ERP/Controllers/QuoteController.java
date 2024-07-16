package com.example.ERP.Controllers;

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

import com.example.ERP.Dto.QuoteDTO;
import com.example.ERP.Services.QuoteService;


@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/api/quotes")
public class QuoteController {
    @Autowired
    private QuoteService quoteService;

    @PostMapping
    public ResponseEntity<QuoteDTO> createQuote(@RequestBody QuoteDTO quoteDTO) {
        QuoteDTO createdQuote = quoteService.createQuote(quoteDTO);
        return ResponseEntity.ok(createdQuote);
    }

    @PutMapping("/{id}")
    public ResponseEntity<QuoteDTO> updateQuote(@PathVariable Long id, @RequestBody QuoteDTO quoteDTO) {
        QuoteDTO updatedQuote = quoteService.updateQuote(id, quoteDTO);
        return ResponseEntity.ok(updatedQuote);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteQuote(@PathVariable Long id) {
        quoteService.deleteQuote(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<QuoteDTO> getQuoteById(@PathVariable Long id) {
        QuoteDTO quoteDTO = quoteService.getQuoteById(id);
        return ResponseEntity.ok(quoteDTO);
    }

    @GetMapping
    public ResponseEntity<List<QuoteDTO>> getAllQuotes() {
        List<QuoteDTO> quotes = quoteService.getAllQuotes();
        return ResponseEntity.ok(quotes);
    }

    @GetMapping("/search")
    public ResponseEntity<List<QuoteDTO>> searchQuotes(
            @RequestParam(required = false) String code,
            @RequestParam(required = false) String revision,
            @RequestParam(required = false) String objet,
            @RequestParam(required = false) Boolean actif,
            @RequestParam(required = false) Boolean valide,
            @RequestParam(required = false) String statut,
            @RequestParam(required = false) Double montant,
            @RequestParam(required = false) String nature,
            @RequestParam(required = false) String projet,
            @RequestParam(required = false) Long clientId) {
                List<QuoteDTO> quotes = quoteService.searchQuotes(code, revision, objet, actif, valide, statut, montant, nature, projet, clientId);
                return ResponseEntity.ok(quotes);
            }
        }
        

