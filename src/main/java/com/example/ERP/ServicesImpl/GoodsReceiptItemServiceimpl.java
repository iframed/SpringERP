package com.example.ERP.ServicesImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ERP.Dto.GoodsReceiptItemDTO;
import com.example.ERP.Mappers.GoodsReceiptItemMapper;
import com.example.ERP.Models.GoodsReceiptItem;
import com.example.ERP.Models.Product;
import com.example.ERP.Repository.GoodsReceiptItemRepository;
import com.example.ERP.Repository.ProductRepository;
import com.example.ERP.Services.GoodsReceiptItemService;

@Service
public class GoodsReceiptItemServiceimpl implements GoodsReceiptItemService {

    @Autowired
    private GoodsReceiptItemRepository goodsReceiptItemRepository;
    @Autowired
    private ProductRepository productRepository;

    public GoodsReceiptItemDTO createGoodsReceiptItem(GoodsReceiptItemDTO goodsReceiptItemDTO) {
        GoodsReceiptItem goodsReceiptItem = GoodsReceiptItemMapper.toEntity(goodsReceiptItemDTO);

        if (goodsReceiptItemDTO.getProductId() != null) {
            Product product = productRepository.findById(goodsReceiptItemDTO.getProductId())
                .orElseThrow(() -> new RuntimeException("Product with ID " + goodsReceiptItemDTO.getProductId() + " not found"));
            goodsReceiptItem.setProduct(product);
        }

        GoodsReceiptItem savedItem = goodsReceiptItemRepository.save(goodsReceiptItem);
        return GoodsReceiptItemMapper.toDTO(savedItem);
    }


}
