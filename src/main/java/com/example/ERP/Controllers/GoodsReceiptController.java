package com.example.ERP.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ERP.Dto.GoodsReceiptDTO;
import com.example.ERP.Services.GoodsReceiptService;


@RestController
@RequestMapping("/api/goods-receipts")
public class GoodsReceiptController {
    @Autowired
    private GoodsReceiptService goodsReceiptService;

    @PostMapping
    public ResponseEntity<GoodsReceiptDTO> createGoodsReceipt(@RequestBody GoodsReceiptDTO goodsReceiptDTO) {
        GoodsReceiptDTO createdGoodsReceipt = goodsReceiptService.createGoodsReceipt(goodsReceiptDTO);
        return ResponseEntity.ok(createdGoodsReceipt);
    }

    @PutMapping("/{id}")
    public ResponseEntity<GoodsReceiptDTO> updateGoodsReceipt(@PathVariable Long id, @RequestBody GoodsReceiptDTO goodsReceiptDTO) {
        GoodsReceiptDTO updatedGoodsReceipt = goodsReceiptService.updateGoodsReceipt(id, goodsReceiptDTO);
        return ResponseEntity.ok(updatedGoodsReceipt);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGoodsReceipt(@PathVariable Long id) {
        goodsReceiptService.deleteGoodsReceipt(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<GoodsReceiptDTO> getGoodsReceiptById(@PathVariable Long id) {
        GoodsReceiptDTO goodsReceiptDTO = goodsReceiptService.getGoodsReceiptById(id);
        return ResponseEntity.ok(goodsReceiptDTO);
    }

    @GetMapping
    public ResponseEntity<List<GoodsReceiptDTO>> getAllGoodsReceipts() {
        List<GoodsReceiptDTO> goodsReceipts = goodsReceiptService.getAllGoodsReceipts();
        return ResponseEntity.ok(goodsReceipts);
    }
}
