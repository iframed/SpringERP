package com.example.ERP.Mappers;

import org.springframework.stereotype.Component;

import com.example.ERP.Dto.GoodsReceiptItemDTO;
import com.example.ERP.Models.GoodsReceiptItem;

@Component
public class GoodsReceiptItemMapper {
    public static GoodsReceiptItemDTO toDTO(GoodsReceiptItem goodsReceiptItem) {
        return new GoodsReceiptItemDTO(
                goodsReceiptItem.getId(),
                goodsReceiptItem.getQuantity(),
                goodsReceiptItem.getGoodsReceipt() != null ? goodsReceiptItem.getGoodsReceipt().getId() : null,
                goodsReceiptItem.getProduct() != null ? goodsReceiptItem.getProduct().getId() : null
        );
    }

    public static GoodsReceiptItem toEntity(GoodsReceiptItemDTO goodsReceiptItemDTO) {
        GoodsReceiptItem goodsReceiptItem = new GoodsReceiptItem();
        goodsReceiptItem.setId(goodsReceiptItemDTO.getId());
        goodsReceiptItem.setQuantity(goodsReceiptItemDTO.getQuantity());
        // goodsReceipt and product should be set by service layer or ORM relationships
        return goodsReceiptItem;
    }
}
