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

import com.example.ERP.Dto.CustomerOrderDTO;
import com.example.ERP.Services.CustomerOrderService;


@RestController
@RequestMapping("/api/customer-orders")
public class CustomerOrderController {
    @Autowired
    private CustomerOrderService customerOrderService;

    @PostMapping
    public ResponseEntity<CustomerOrderDTO> createCustomerOrder(@RequestBody CustomerOrderDTO customerOrderDTO) {
        CustomerOrderDTO createdCustomerOrder = customerOrderService.createCustomerOrder(customerOrderDTO);
        return ResponseEntity.ok(createdCustomerOrder);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomerOrderDTO> updateCustomerOrder(@PathVariable Long id, @RequestBody CustomerOrderDTO customerOrderDTO) {
        CustomerOrderDTO updatedCustomerOrder = customerOrderService.updateCustomerOrder(id, customerOrderDTO);
        return ResponseEntity.ok(updatedCustomerOrder);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomerOrder(@PathVariable Long id) {
        customerOrderService.deleteCustomerOrder(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerOrderDTO> getCustomerOrderById(@PathVariable Long id) {
        CustomerOrderDTO customerOrderDTO = customerOrderService.getCustomerOrderById(id);
        return ResponseEntity.ok(customerOrderDTO);
    }

    @GetMapping
    public ResponseEntity<List<CustomerOrderDTO>> getAllCustomerOrders() {
        List<CustomerOrderDTO> customerOrders = customerOrderService.getAllCustomerOrders();
        return ResponseEntity.ok(customerOrders);
    }
}
