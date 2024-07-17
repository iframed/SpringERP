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

import com.example.ERP.Dto.PurchaseOrderDTO;
import com.example.ERP.Services.PurchaseOrderService;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/api/purchase-orders")
public class PurchaseOrderController {
    @Autowired
    private PurchaseOrderService purchaseOrderService;

    @PostMapping
    public ResponseEntity<PurchaseOrderDTO> createPurchaseOrder(@RequestBody PurchaseOrderDTO purchaseOrderDTO) {
        PurchaseOrderDTO createdPurchaseOrder = purchaseOrderService.createPurchaseOrder(purchaseOrderDTO);
        return ResponseEntity.ok(createdPurchaseOrder);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PurchaseOrderDTO> updatePurchaseOrder(@PathVariable Long id, @RequestBody PurchaseOrderDTO purchaseOrderDTO) {
        PurchaseOrderDTO updatedPurchaseOrder = purchaseOrderService.updatePurchaseOrder(id, purchaseOrderDTO);
        return ResponseEntity.ok(updatedPurchaseOrder);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePurchaseOrder(@PathVariable Long id) {
        purchaseOrderService.deletePurchaseOrder(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PurchaseOrderDTO> getPurchaseOrderById(@PathVariable Long id) {
        PurchaseOrderDTO purchaseOrderDTO = purchaseOrderService.getPurchaseOrderById(id);
        return ResponseEntity.ok(purchaseOrderDTO);
    }

    @GetMapping
    public ResponseEntity<List<PurchaseOrderDTO>> getAllPurchaseOrders() {
        List<PurchaseOrderDTO> purchaseOrders = purchaseOrderService.getAllPurchaseOrders();
        return ResponseEntity.ok(purchaseOrders);
    }

    @GetMapping("/search")
    public ResponseEntity<List<PurchaseOrderDTO>> searchPurchaseOrders(
            @RequestParam(required = false) String code,
            @RequestParam(required = false) String typeBC,
            @RequestParam(required = false) String projet,
            @RequestParam(required = false) Double montant,
            @RequestParam(required = false) String fournisseur,
            @RequestParam(required = false) Long supplierId) {
        List<PurchaseOrderDTO> orders = purchaseOrderService.searchPurchaseOrders(code, typeBC, projet, montant, fournisseur, supplierId);
        return ResponseEntity.ok(orders);
    }
}
