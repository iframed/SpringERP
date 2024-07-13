package com.example.ERP.Mappers;

import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.example.ERP.Dto.ShipmentDTO;
import com.example.ERP.Models.Route;
import com.example.ERP.Models.Shipment;


@Component
public class ShipmentMapper {
    public static ShipmentDTO toDTO(Shipment shipment) {
        return new ShipmentDTO(
                shipment.getId(),
                shipment.getShipmentDate(),
                shipment.getStatus(),
                shipment.getRoutes() != null ? shipment.getRoutes().stream().map(Route::getId).collect(Collectors.toList()) : null
        );
    }

    public static Shipment toEntity(ShipmentDTO shipmentDTO) {
        Shipment shipment = new Shipment();
        shipment.setId(shipmentDTO.getId());
        shipment.setShipmentDate(shipmentDTO.getShipmentDate());
        shipment.setStatus(shipmentDTO.getStatus());
        // routes should be set by service layer or ORM relationships
        return shipment;
    }
}
