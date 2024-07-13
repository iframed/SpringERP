package com.example.ERP.Services;

import java.util.List;

import com.example.ERP.Dto.InventoryDTO;

public interface InventoryService {
    InventoryDTO createInventory(InventoryDTO inventoryDTO);
    InventoryDTO updateInventory(Long id, InventoryDTO inventoryDTO);
    void deleteInventory(Long id);
    InventoryDTO getInventoryById(Long id);
    List<InventoryDTO> getAllInventories();
}
