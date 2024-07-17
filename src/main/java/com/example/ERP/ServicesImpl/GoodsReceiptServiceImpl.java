package com.example.ERP.ServicesImpl;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ERP.Dto.GoodsReceiptDTO;
import com.example.ERP.Mappers.GoodsReceiptMapper;
import com.example.ERP.Models.Client;
import com.example.ERP.Models.GoodsReceipt;
import com.example.ERP.Models.GoodsReceiptItem;
import com.example.ERP.Models.PurchaseOrder;
import com.example.ERP.Repository.ClientRepository;
import com.example.ERP.Repository.GoodsReceiptItemRepository;
import com.example.ERP.Repository.GoodsReceiptRepository;
import com.example.ERP.Repository.PurchaseOrderRepository;
import com.example.ERP.Services.GoodsReceiptService;



@Service
public class GoodsReceiptServiceImpl  implements GoodsReceiptService {

    @Autowired
    private GoodsReceiptRepository goodsReceiptRepository;

    @Autowired
    private GoodsReceiptItemRepository  goodsReceiptItemRepository;
    
    @Autowired
    private PurchaseOrderRepository purchaseOrderRepository;

    @Autowired
    private ClientRepository clientRepository;
    
    @Override
    public GoodsReceiptDTO createGoodsReceipt(GoodsReceiptDTO goodsReceiptDTO) {
        GoodsReceipt goodsReceipt = GoodsReceiptMapper.toEntity(goodsReceiptDTO);
    
        if (goodsReceiptDTO.getClientId() != null) {
            Client client = clientRepository.findById(goodsReceiptDTO.getClientId())
                .orElseThrow(() -> new RuntimeException("Client with ID " + goodsReceiptDTO.getClientId() + " not found"));
            goodsReceipt.setClient(client);
        }
    
        if (goodsReceiptDTO.getPurchaseOrderId() != null) {
            PurchaseOrder purchaseOrder = purchaseOrderRepository.findById(goodsReceiptDTO.getPurchaseOrderId())
                .orElseThrow(() -> new RuntimeException("PurchaseOrder with ID " + goodsReceiptDTO.getPurchaseOrderId() + " not found"));
            goodsReceipt.setPurchaseOrder(purchaseOrder);
        }
    
        // Sauvegarde du GoodsReceipt
        GoodsReceipt savedGoodsReceipt = goodsReceiptRepository.save(goodsReceipt);
    
        // Mise à jour des GoodsReceiptItems avec le GoodsReceipt nouvellement créé
        if (goodsReceiptDTO.getGoodsReceiptItemIds() != null) {
            List<GoodsReceiptItem> goodsReceiptItems = goodsReceiptDTO.getGoodsReceiptItemIds().stream()
                .map(itemId -> {
                    GoodsReceiptItem item = goodsReceiptItemRepository.findById(itemId)
                        .orElseThrow(() -> new RuntimeException("GoodsReceiptItem with ID " + itemId + " not found"));
                    item.setGoodsReceipt(savedGoodsReceipt);
                    return item;
                })
                .collect(Collectors.toList());
            goodsReceiptItemRepository.saveAll(goodsReceiptItems);
            savedGoodsReceipt.setGoodsReceiptItems(goodsReceiptItems);
        }
    
        return GoodsReceiptMapper.toDTO(savedGoodsReceipt);
    }
    


    @Override
    public GoodsReceiptDTO updateGoodsReceipt(Long id, GoodsReceiptDTO goodsReceiptDTO) {
        GoodsReceipt goodsReceipt = goodsReceiptRepository.findById(id).orElseThrow(() -> new RuntimeException("GoodsReceipt not found"));
        goodsReceipt.setCodeBL(goodsReceiptDTO.getCodeBL());
        goodsReceipt.setCodeBC(goodsReceiptDTO.getCodeBC());
        goodsReceipt.setReceiptDate(goodsReceiptDTO.getReceiptDate());
        goodsReceipt.setType(goodsReceiptDTO.getType());
        goodsReceipt.setCodeProjet(goodsReceiptDTO.getCodeProjet());
        goodsReceipt.setStatus(goodsReceiptDTO.getStatus());
        GoodsReceipt updatedGoodsReceipt = goodsReceiptRepository.save(goodsReceipt);
        return GoodsReceiptMapper.toDTO(updatedGoodsReceipt);
    }

    @Override
    public void deleteGoodsReceipt(Long id) {
        goodsReceiptRepository.deleteById(id);
    }

    @Override
    public GoodsReceiptDTO getGoodsReceiptById(Long id) {
        GoodsReceipt goodsReceipt = goodsReceiptRepository.findById(id).orElseThrow(() -> new RuntimeException("GoodsReceipt not found"));
        return GoodsReceiptMapper.toDTO(goodsReceipt);
    }

    @Override
    public List<GoodsReceiptDTO> getAllGoodsReceipts() {
        return goodsReceiptRepository.findAll().stream().map(GoodsReceiptMapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public List<GoodsReceiptDTO> searchGoodsReceipts(String codeBL, String codeBC, String type, String codeProjet, String status, Long clientId, Long purchaseOrderId, LocalDate startDate, LocalDate endDate) {
        List<GoodsReceipt> receipts = goodsReceiptRepository.searchGoodsReceipts(codeBL, codeBC, type, codeProjet, status, clientId, purchaseOrderId, startDate, endDate);
        return receipts.stream().map(GoodsReceiptMapper::toDTO).collect(Collectors.toList());
    }

    

}
