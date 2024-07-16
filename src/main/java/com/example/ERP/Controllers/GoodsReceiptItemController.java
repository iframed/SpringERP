package com.example.ERP.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ERP.Dto.GoodsReceiptItemDTO;
import com.example.ERP.Services.GoodsReceiptItemService;

@RestController
@RequestMapping("/api/goods-receipt-items")
public class GoodsReceiptItemController {
    

    @Autowired
    private GoodsReceiptItemService goodsReceiptItemService;

    @PostMapping
    public ResponseEntity<GoodsReceiptItemDTO> createGoodsReceiptItem(@RequestBody GoodsReceiptItemDTO goodsReceiptItemDTO) {
        GoodsReceiptItemDTO createdItem = goodsReceiptItemService.createGoodsReceiptItem(goodsReceiptItemDTO);
        return ResponseEntity.ok(createdItem);
    }

}
