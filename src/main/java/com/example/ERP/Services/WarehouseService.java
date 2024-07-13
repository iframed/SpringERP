package com.example.ERP.Services;

import java.util.List;

import com.example.ERP.Dto.WarehouseDTO;

public interface WarehouseService {
    WarehouseDTO createWarehouse(WarehouseDTO warehouseDTO);
    WarehouseDTO updateWarehouse(Long id, WarehouseDTO warehouseDTO);
    void deleteWarehouse(Long id);
    WarehouseDTO getWarehouseById(Long id);
    List<WarehouseDTO> getAllWarehouses();
}
