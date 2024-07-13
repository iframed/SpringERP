package com.example.ERP.Mappers;

import org.springframework.stereotype.Component;

import com.example.ERP.Dto.OrderItemDTO;
import com.example.ERP.Models.OrderItem;

@Component
public class OrderItemMapper {
    public static OrderItemDTO toDTO(OrderItem orderItem) {
        return new OrderItemDTO(
                orderItem.getId(),
                orderItem.getQuantity(),
                orderItem.getPrice(),
                orderItem.getCustomerOrder() != null ? orderItem.getCustomerOrder().getId() : null,
                orderItem.getProduct() != null ? orderItem.getProduct().getId() : null
        );
    }

    public static OrderItem toEntity(OrderItemDTO orderItemDTO) {
        OrderItem orderItem = new OrderItem();
        orderItem.setId(orderItemDTO.getId());
        orderItem.setQuantity(orderItemDTO.getQuantity());
        orderItem.setPrice(orderItemDTO.getPrice());
        // customerOrder and product should be set by service layer or ORM relationships
        return orderItem;
    }
}
