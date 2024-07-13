package com.example.ERP.Mappers;

import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.example.ERP.Dto.GoodsReceiptDTO;
import com.example.ERP.Models.GoodsReceipt;
import com.example.ERP.Models.GoodsReceiptItem;

@Component
public class GoodsReceiptMapper {
    public static GoodsReceiptDTO toDTO(GoodsReceipt goodsReceipt) {
        return new GoodsReceiptDTO(
                goodsReceipt.getId(),
                goodsReceipt.getReceiptDate(),
                goodsReceipt.getStatus(),
                goodsReceipt.getPurchaseOrder() != null ? goodsReceipt.getPurchaseOrder().getId() : null,
                goodsReceipt.getGoodsReceiptItems() != null ? goodsReceipt.getGoodsReceiptItems().stream().map(GoodsReceiptItem::getId).collect(Collectors.toList()) : null
        );
    }

    public static GoodsReceipt toEntity(GoodsReceiptDTO goodsReceiptDTO) {
        GoodsReceipt goodsReceipt = new GoodsReceipt();
        goodsReceipt.setId(goodsReceiptDTO.getId());
        goodsReceipt.setReceiptDate(goodsReceiptDTO.getReceiptDate());
        goodsReceipt.setStatus(goodsReceiptDTO.getStatus());
        // purchaseOrder and goodsReceiptItems should be set by service layer or ORM relationships
        return goodsReceipt;
    }
}
