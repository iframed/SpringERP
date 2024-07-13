package com.example.ERP.Services;

import java.util.List;

import com.example.ERP.Dto.PurchaseOrderDTO;

public interface PurchaseOrderService {
    PurchaseOrderDTO createPurchaseOrder(PurchaseOrderDTO purchaseOrderDTO);
    PurchaseOrderDTO updatePurchaseOrder(Long id, PurchaseOrderDTO purchaseOrderDTO);
    void deletePurchaseOrder(Long id);
    PurchaseOrderDTO getPurchaseOrderById(Long id);
    List<PurchaseOrderDTO> getAllPurchaseOrders();
}
