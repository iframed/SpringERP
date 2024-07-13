package com.example.ERP.ServicesImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ERP.Dto.PurchaseOrderDTO;
import com.example.ERP.Mappers.PurchaseOrderMapper;
import com.example.ERP.Models.PurchaseOrder;
import com.example.ERP.Repository.PurchaseOrderRepository;
import com.example.ERP.Services.PurchaseOrderService;


@Service
public class PurchaseOrderServiceImpl  implements PurchaseOrderService {

    @Autowired
    private PurchaseOrderRepository purchaseOrderRepository;

    @Override
    public PurchaseOrderDTO createPurchaseOrder(PurchaseOrderDTO purchaseOrderDTO) {
        PurchaseOrder purchaseOrder = PurchaseOrderMapper.toEntity(purchaseOrderDTO);
        PurchaseOrder savedPurchaseOrder = purchaseOrderRepository.save(purchaseOrder);
        return PurchaseOrderMapper.toDTO(savedPurchaseOrder);
    }

    @Override
    public PurchaseOrderDTO updatePurchaseOrder(Long id, PurchaseOrderDTO purchaseOrderDTO) {
        PurchaseOrder purchaseOrder = purchaseOrderRepository.findById(id).orElseThrow(() -> new RuntimeException("PurchaseOrder not found"));
        purchaseOrder.setOrderDate(purchaseOrderDTO.getOrderDate());
        purchaseOrder.setStatus(purchaseOrderDTO.getStatus());
        // Update other fields as necessary
        PurchaseOrder updatedPurchaseOrder = purchaseOrderRepository.save(purchaseOrder);
        return PurchaseOrderMapper.toDTO(updatedPurchaseOrder);
    }

    @Override
    public void deletePurchaseOrder(Long id) {
        purchaseOrderRepository.deleteById(id);
    }

    @Override
    public PurchaseOrderDTO getPurchaseOrderById(Long id) {
        PurchaseOrder purchaseOrder = purchaseOrderRepository.findById(id).orElseThrow(() -> new RuntimeException("PurchaseOrder not found"));
        return PurchaseOrderMapper.toDTO(purchaseOrder);
    }

    @Override
    public List<PurchaseOrderDTO> getAllPurchaseOrders() {
        return purchaseOrderRepository.findAll().stream().map(PurchaseOrderMapper::toDTO).collect(Collectors.toList());
    }
    
}
