package com.example.ERP.Services;

import java.util.List;

import com.example.ERP.Dto.CustomerOrderDTO;

public interface CustomerOrderService {
    CustomerOrderDTO createCustomerOrder(CustomerOrderDTO customerOrderDTO);
    CustomerOrderDTO updateCustomerOrder(Long id, CustomerOrderDTO customerOrderDTO);
    void deleteCustomerOrder(Long id);
    CustomerOrderDTO getCustomerOrderById(Long id);
    List<CustomerOrderDTO> getAllCustomerOrders();
    List<CustomerOrderDTO> searchOrders(String code, String typeBC, String typeNBT, String projet, Boolean actif, Boolean valide, Double montant, String contactCadre, String nature, Long clientId);

}
