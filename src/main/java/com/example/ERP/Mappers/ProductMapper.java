package com.example.ERP.Mappers;

import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.example.ERP.Dto.ProductDTO;
import com.example.ERP.Models.GoodsReceiptItem;
import com.example.ERP.Models.Inventory;
import com.example.ERP.Models.OrderItem;
import com.example.ERP.Models.Product;
import com.example.ERP.Models.PurchaseOrderItem;
import com.example.ERP.Models.QuoteItem;


@Component
public class ProductMapper {
    public static ProductDTO toDTO(Product product) {
        return new ProductDTO(
                product.getId(),
                product.getName(),
                product.getPrice(),
                product.getCategory() != null ? product.getCategory().getId() : null,
                product.getInventories() != null ? product.getInventories().stream().map(Inventory::getId).collect(Collectors.toList()) : null,
                product.getOrderItems() != null ? product.getOrderItems().stream().map(OrderItem::getId).collect(Collectors.toList()) : null,
                product.getQuoteItems() != null ? product.getQuoteItems().stream().map(QuoteItem::getId).collect(Collectors.toList()) : null,
                product.getPurchaseOrderItems() != null ? product.getPurchaseOrderItems().stream().map(PurchaseOrderItem::getId).collect(Collectors.toList()) : null,
                product.getGoodsReceiptItems() != null ? product.getGoodsReceiptItems().stream().map(GoodsReceiptItem::getId).collect(Collectors.toList()) : null
        );
    }

    public static Product toEntity(ProductDTO productDTO) {
        Product product = new Product();
        product.setId(productDTO.getId());
        product.setName(productDTO.getName());
        product.setPrice(productDTO.getPrice());
        // category, inventories, orderItems, quoteItems, purchaseOrderItems, goodsReceiptItems should be set by service layer or ORM relationships
        return product;
    }
}
