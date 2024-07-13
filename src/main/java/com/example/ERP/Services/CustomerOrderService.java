package com.example.ERP.Services;

import java.util.List;

import com.example.ERP.Dto.CustomerOrderDTO;

public interface CustomerOrderService {
    CustomerOrderDTO createCustomerOrder(CustomerOrderDTO customerOrderDTO);
    CustomerOrderDTO updateCustomerOrder(Long id, CustomerOrderDTO customerOrderDTO);
    void deleteCustomerOrder(Long id);
    CustomerOrderDTO getCustomerOrderById(Long id);
    List<CustomerOrderDTO> getAllCustomerOrders();
}
