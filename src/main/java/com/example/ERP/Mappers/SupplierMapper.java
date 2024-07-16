package com.example.ERP.Mappers;

import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.example.ERP.Dto.SupplierDTO;
import com.example.ERP.Models.PurchaseOrder;
import com.example.ERP.Models.Supplier;


@Component
public class SupplierMapper {
    public static SupplierDTO toDTO(Supplier supplier) {
        return new SupplierDTO(
            supplier.getId(),
            supplier.getName(),
            supplier.getContact(),
            supplier.getEmail(),
            supplier.getPhone(),
            supplier.getProducts() != null ? supplier.getProducts().stream().map(ProductMapper::toDTO).collect(Collectors.toList()) : null,

            supplier.getPurchaseOrders() != null ? supplier.getPurchaseOrders().stream().map(PurchaseOrder::getId).collect(Collectors.toList()) : null
    );
    }


    public static Supplier toEntity(SupplierDTO supplierDTO) {
        Supplier supplier = new Supplier();
        supplier.setId(supplierDTO.getId());
        supplier.setName(supplierDTO.getName());
        supplier.setContact(supplierDTO.getContact());
        supplier.setEmail(supplierDTO.getEmail());
        supplier.setPhone(supplierDTO.getPhone());
        // purchaseOrders should be set by service layer or ORM relationships
        return supplier;
    }
}
