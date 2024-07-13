package com.example.ERP.Services;

import java.util.List;

import com.example.ERP.Dto.ShipmentDTO;

public interface ShipmentService {
    ShipmentDTO createShipment(ShipmentDTO shipmentDTO);
    ShipmentDTO updateShipment(Long id, ShipmentDTO shipmentDTO);
    void deleteShipment(Long id);
    ShipmentDTO getShipmentById(Long id);
    List<ShipmentDTO> getAllShipments();
}
