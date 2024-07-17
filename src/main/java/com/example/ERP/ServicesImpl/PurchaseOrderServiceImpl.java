package com.example.ERP.ServicesImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ERP.Dto.PurchaseOrderDTO;
import com.example.ERP.Mappers.PurchaseOrderMapper;
import com.example.ERP.Models.GoodsReceipt;
import com.example.ERP.Models.PurchaseOrder;
import com.example.ERP.Models.PurchaseOrderItem;
import com.example.ERP.Models.Supplier;
import com.example.ERP.Repository.GoodsReceiptRepository;
import com.example.ERP.Repository.PurchaseOrderItemRepository;
import com.example.ERP.Repository.PurchaseOrderRepository;
import com.example.ERP.Repository.SupplierRepository;
import com.example.ERP.Services.PurchaseOrderService;


@Service
public class PurchaseOrderServiceImpl  implements PurchaseOrderService {

    @Autowired
    private PurchaseOrderRepository purchaseOrderRepository;

    @Autowired
    private SupplierRepository supplierRepository;

    @Autowired
    private PurchaseOrderItemRepository purchaseOrderItemRepository;

    @Autowired
    private GoodsReceiptRepository goodsReceiptRepository;


    @Override
public PurchaseOrderDTO createPurchaseOrder(PurchaseOrderDTO purchaseOrderDTO) {
    PurchaseOrder purchaseOrder = PurchaseOrderMapper.toEntity(purchaseOrderDTO);

    if (purchaseOrderDTO.getSupplierId() != null) {
        Supplier supplier = supplierRepository.findById(purchaseOrderDTO.getSupplierId())
            .orElseThrow(() -> new RuntimeException("Supplier not found"));
        purchaseOrder.setSupplier(supplier);
    }

    if (purchaseOrderDTO.getPurchaseOrderItemIds() != null) {
        List<PurchaseOrderItem> purchaseOrderItems = purchaseOrderDTO.getPurchaseOrderItemIds().stream()
            .map(id -> {
                PurchaseOrderItem item = purchaseOrderItemRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("PurchaseOrderItem not found"));
                item.setPurchaseOrder(purchaseOrder);
                return item;
            })
            .collect(Collectors.toList());
        purchaseOrder.setPurchaseOrderItems(purchaseOrderItems);
    }

    if (purchaseOrderDTO.getGoodsReceiptIds() != null) {
        List<GoodsReceipt> goodsReceipts = purchaseOrderDTO.getGoodsReceiptIds().stream()
            .map(id -> {
                GoodsReceipt receipt = goodsReceiptRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("GoodsReceipt not found"));
                receipt.setPurchaseOrder(purchaseOrder);
                return receipt;
            })
            .collect(Collectors.toList());
        purchaseOrder.setGoodsReceipts(goodsReceipts);
    }

    PurchaseOrder savedPurchaseOrder = purchaseOrderRepository.save(purchaseOrder);
    return PurchaseOrderMapper.toDTO(savedPurchaseOrder);
}



    @Override
public PurchaseOrderDTO updatePurchaseOrder(Long id, PurchaseOrderDTO purchaseOrderDTO) {
    PurchaseOrder purchaseOrder = purchaseOrderRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("PurchaseOrder not found"));
    purchaseOrder.setOrderDate(purchaseOrderDTO.getOrderDate());
    purchaseOrder.setStatus(purchaseOrderDTO.getStatus());
    purchaseOrder.setCode(purchaseOrderDTO.getCode());
    purchaseOrder.setTypeBC(purchaseOrderDTO.getTypeBC());
    purchaseOrder.setProjet(purchaseOrderDTO.getProjet());
    purchaseOrder.setMontant(purchaseOrderDTO.getMontant());
    purchaseOrder.setFournisseur(purchaseOrderDTO.getFournisseur());

    if (purchaseOrderDTO.getSupplierId() != null) {
        Supplier supplier = supplierRepository.findById(purchaseOrderDTO.getSupplierId())
            .orElseThrow(() -> new RuntimeException("Supplier not found"));
        purchaseOrder.setSupplier(supplier);
    }

    if (purchaseOrderDTO.getPurchaseOrderItemIds() != null) {
        List<PurchaseOrderItem> purchaseOrderItems = purchaseOrderDTO.getPurchaseOrderItemIds().stream()
            .map(itemId -> purchaseOrderItemRepository.findById(itemId)
                .orElseThrow(() -> new RuntimeException("PurchaseOrderItem not found")))
            .collect(Collectors.toList());
        purchaseOrder.setPurchaseOrderItems(purchaseOrderItems);
    }

    if (purchaseOrderDTO.getGoodsReceiptIds() != null) {
        List<GoodsReceipt> goodsReceipts = purchaseOrderDTO.getGoodsReceiptIds().stream()
            .map(goodsReceiptId -> goodsReceiptRepository.findById(goodsReceiptId)
                .orElseThrow(() -> new RuntimeException("GoodsReceipt not found")))
            .collect(Collectors.toList());
        purchaseOrder.setGoodsReceipts(goodsReceipts);
    }

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

    @Override
    public List<PurchaseOrderDTO> searchPurchaseOrders(String code, String typeBC, String projet, Double montant, String fournisseur, Long supplierId) {
        List<PurchaseOrder> purchaseOrders = purchaseOrderRepository.searchPurchaseOrders(code, typeBC, projet, montant, fournisseur, supplierId);
        List<PurchaseOrderDTO> dtos = purchaseOrders.stream()
            .map(PurchaseOrderMapper::toDTO)
            .collect(Collectors.toList());
        // Log the DTOs to verify the data
        dtos.forEach(dto -> System.out.println("Searched Purchase Order: " + dto));
        return dtos;
    }
    
    
}
