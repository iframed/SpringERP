package com.example.ERP.Mappers;

import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.example.ERP.Dto.CustomerOrderDTO;
import com.example.ERP.Models.CustomerOrder;
import com.example.ERP.Models.OrderItem;

@Component
public class CustomerOrderMapper {
    public static CustomerOrderDTO toDTO(CustomerOrder customerOrder) {
        return new CustomerOrderDTO(
                customerOrder.getId(),
                customerOrder.getOrderDate(),
                customerOrder.getStatus(),
                customerOrder.getClient() != null ? customerOrder.getClient().getId() : null,
                customerOrder.getOrderItems() != null ? customerOrder.getOrderItems().stream().map(OrderItem::getId).collect(Collectors.toList()) : null
        );
    }

    public static CustomerOrder toEntity(CustomerOrderDTO customerOrderDTO) {
        CustomerOrder customerOrder = new CustomerOrder();
        customerOrder.setId(customerOrderDTO.getId());
        customerOrder.setOrderDate(customerOrderDTO.getOrderDate());
        customerOrder.setStatus(customerOrderDTO.getStatus());
        // client and orderItems should be set by service layer or ORM relationships
        return customerOrder;
    }
}
