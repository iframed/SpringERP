package com.example.ERP.Mappers;

import org.springframework.stereotype.Component;

import com.example.ERP.Dto.GoodsReceiptItemDTO;
import com.example.ERP.Models.GoodsReceiptItem;

@Component
public class GoodsReceiptItemMapper {
    public static GoodsReceiptItemDTO toDTO(GoodsReceiptItem goodsReceiptItem) {
        return new GoodsReceiptItemDTO(
            goodsReceiptItem.getId(),
            goodsReceiptItem.getProductName(),
            goodsReceiptItem.getQuantity(),
            goodsReceiptItem.getPrice(),
            goodsReceiptItem.getGoodsReceipt() != null ? goodsReceiptItem.getGoodsReceipt().getId() : null,
            goodsReceiptItem.getProduct() != null ? goodsReceiptItem.getProduct().getId() : null
        );
    }

    public static GoodsReceiptItem toEntity(GoodsReceiptItemDTO goodsReceiptItemDTO) {
        GoodsReceiptItem goodsReceiptItem = new GoodsReceiptItem();
        
        goodsReceiptItem.setId(goodsReceiptItemDTO.getId());
        goodsReceiptItem.setProductName(goodsReceiptItemDTO.getProductName());
        goodsReceiptItem.setQuantity(goodsReceiptItemDTO.getQuantity());
        goodsReceiptItem.setPrice(goodsReceiptItemDTO.getPrice());
        return goodsReceiptItem;
    }
}
