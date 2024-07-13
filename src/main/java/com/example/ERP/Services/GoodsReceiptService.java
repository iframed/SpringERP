package com.example.ERP.Services;

import java.util.List;

import com.example.ERP.Dto.GoodsReceiptDTO;

public interface GoodsReceiptService {
    GoodsReceiptDTO createGoodsReceipt(GoodsReceiptDTO goodsReceiptDTO);
    GoodsReceiptDTO updateGoodsReceipt(Long id, GoodsReceiptDTO goodsReceiptDTO);
    void deleteGoodsReceipt(Long id);
    GoodsReceiptDTO getGoodsReceiptById(Long id);
    List<GoodsReceiptDTO> getAllGoodsReceipts();
}
