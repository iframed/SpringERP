package com.example.ERP.Mappers;

import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.example.ERP.Dto.WarehouseDTO;
import com.example.ERP.Models.Inventory;
import com.example.ERP.Models.Warehouse;

@Component
public class WarehouseMapper {
    public static WarehouseDTO toDTO(Warehouse warehouse) {
        return new WarehouseDTO(
                warehouse.getId(),
                warehouse.getName(),
                warehouse.getLocation(),
                warehouse.getInventories() != null ? warehouse.getInventories().stream().map(Inventory::getId).collect(Collectors.toList()) : null
        );
    }

    public static Warehouse toEntity(WarehouseDTO warehouseDTO) {
        Warehouse warehouse = new Warehouse();
        warehouse.setId(warehouseDTO.getId());
        warehouse.setName(warehouseDTO.getName());
        warehouse.setLocation(warehouseDTO.getLocation());
        // inventories should be set by service layer or ORM relationships
        return warehouse;
    }
}
