package com.example.ERP.Mappers;

import org.springframework.stereotype.Component;

import com.example.ERP.Dto.InventoryDTO;
import com.example.ERP.Models.Inventory;

@Component
public class InventoryMapper {
    public static InventoryDTO toDTO(Inventory inventory) {
        return new InventoryDTO(
                inventory.getId(),
                inventory.getQuantity(),
                inventory.getWarehouse() != null ? inventory.getWarehouse().getId() : null,
                inventory.getProduct() != null ? inventory.getProduct().getId() : null
        );
    }

    public static Inventory toEntity(InventoryDTO inventoryDTO) {
        Inventory inventory = new Inventory();
        inventory.setId(inventoryDTO.getId());
        inventory.setQuantity(inventoryDTO.getQuantity());
        // warehouse and product should be set by service layer or ORM relationships
        return inventory;
    }
}
