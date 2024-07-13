package com.example.ERP.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ERP.Dto.ShipmentDTO;
import com.example.ERP.Services.ShipmentService;

@RestController
@RequestMapping("/api/shipments")
public class ShipmentController {
    @Autowired
    private ShipmentService shipmentService;

    @PostMapping
    public ResponseEntity<ShipmentDTO> createShipment(@RequestBody ShipmentDTO shipmentDTO) {
        ShipmentDTO createdShipment = shipmentService.createShipment(shipmentDTO);
        return ResponseEntity.ok(createdShipment);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ShipmentDTO> updateShipment(@PathVariable Long id, @RequestBody ShipmentDTO shipmentDTO) {
        ShipmentDTO updatedShipment = shipmentService.updateShipment(id, shipmentDTO);
        return ResponseEntity.ok(updatedShipment);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteShipment(@PathVariable Long id) {
        shipmentService.deleteShipment(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ShipmentDTO> getShipmentById(@PathVariable Long id) {
        ShipmentDTO shipmentDTO = shipmentService.getShipmentById(id);
        return ResponseEntity.ok(shipmentDTO);
    }

    @GetMapping
    public ResponseEntity<List<ShipmentDTO>> getAllShipments() {
        List<ShipmentDTO> shipments = shipmentService.getAllShipments();
        return ResponseEntity.ok(shipments);
    }
}
