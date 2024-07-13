package com.example.ERP.ServicesImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ERP.Dto.WarehouseDTO;
import com.example.ERP.Mappers.WarehouseMapper;
import com.example.ERP.Models.Warehouse;
import com.example.ERP.Repository.WarehouseRepository;
import com.example.ERP.Services.WarehouseService;


@Service
public class WarehouseServiceImpl  implements WarehouseService {

    @Autowired
    private WarehouseRepository warehouseRepository;

    @Override
    public WarehouseDTO createWarehouse(WarehouseDTO warehouseDTO) {
        Warehouse warehouse = WarehouseMapper.toEntity(warehouseDTO);
        Warehouse savedWarehouse = warehouseRepository.save(warehouse);
        return WarehouseMapper.toDTO(savedWarehouse);
    }

    @Override
    public WarehouseDTO updateWarehouse(Long id, WarehouseDTO warehouseDTO) {
        Warehouse warehouse = warehouseRepository.findById(id).orElseThrow(() -> new RuntimeException("Warehouse not found"));
        warehouse.setName(warehouseDTO.getName());
        warehouse.setLocation(warehouseDTO.getLocation());
        Warehouse updatedWarehouse = warehouseRepository.save(warehouse);
        return WarehouseMapper.toDTO(updatedWarehouse);
    }

    @Override
    public void deleteWarehouse(Long id) {
        warehouseRepository.deleteById(id);
    }

    @Override
    public WarehouseDTO getWarehouseById(Long id) {
        Warehouse warehouse = warehouseRepository.findById(id).orElseThrow(() -> new RuntimeException("Warehouse not found"));
        return WarehouseMapper.toDTO(warehouse);
    }

    @Override
    public List<WarehouseDTO> getAllWarehouses() {
        return warehouseRepository.findAll().stream().map(WarehouseMapper::toDTO).collect(Collectors.toList());
    }
}
