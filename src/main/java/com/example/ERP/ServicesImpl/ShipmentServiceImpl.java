package com.example.ERP.ServicesImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ERP.Dto.ShipmentDTO;
import com.example.ERP.Mappers.ShipmentMapper;
import com.example.ERP.Models.Shipment;
import com.example.ERP.Repository.ShipmentRepository;
import com.example.ERP.Services.ShipmentService;

@Service
public class ShipmentServiceImpl  implements ShipmentService {

    @Autowired
    private ShipmentRepository shipmentRepository;

    @Override
    public ShipmentDTO createShipment(ShipmentDTO shipmentDTO) {
        Shipment shipment = ShipmentMapper.toEntity(shipmentDTO);
        Shipment savedShipment = shipmentRepository.save(shipment);
        return ShipmentMapper.toDTO(savedShipment);
    }

    @Override
    public ShipmentDTO updateShipment(Long id, ShipmentDTO shipmentDTO) {
        Shipment shipment = shipmentRepository.findById(id).orElseThrow(() -> new RuntimeException("Shipment not found"));
        shipment.setShipmentDate(shipmentDTO.getShipmentDate());
        shipment.setStatus(shipmentDTO.getStatus());
        // Update other fields as necessary
        Shipment updatedShipment = shipmentRepository.save(shipment);
        return ShipmentMapper.toDTO(updatedShipment);
    }

    @Override
    public void deleteShipment(Long id) {
        shipmentRepository.deleteById(id);
    }

    @Override
    public ShipmentDTO getShipmentById(Long id) {
        Shipment shipment = shipmentRepository.findById(id).orElseThrow(() -> new RuntimeException("Shipment not found"));
        return ShipmentMapper.toDTO(shipment);
    }

    @Override
    public List<ShipmentDTO> getAllShipments() {
        return shipmentRepository.findAll().stream().map(ShipmentMapper::toDTO).collect(Collectors.toList());
    }
    
}
