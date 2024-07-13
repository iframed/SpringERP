package com.example.ERP.ServicesImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ERP.Dto.CustomerOrderDTO;
import com.example.ERP.Mappers.CustomerOrderMapper;
import com.example.ERP.Models.CustomerOrder;
import com.example.ERP.Repository.CustomerOrderRepository;
import com.example.ERP.Services.CustomerOrderService;


@Service
public class CustomerOrderServiceImpl  implements CustomerOrderService {

    @Autowired
    private CustomerOrderRepository customerOrderRepository;

    @Override
    public CustomerOrderDTO createCustomerOrder(CustomerOrderDTO customerOrderDTO) {
        CustomerOrder customerOrder = CustomerOrderMapper.toEntity(customerOrderDTO);
        CustomerOrder savedCustomerOrder = customerOrderRepository.save(customerOrder);
        return CustomerOrderMapper.toDTO(savedCustomerOrder);
    }

    @Override
    public CustomerOrderDTO updateCustomerOrder(Long id, CustomerOrderDTO customerOrderDTO) {
        CustomerOrder customerOrder = customerOrderRepository.findById(id).orElseThrow(() -> new RuntimeException("CustomerOrder not found"));
        customerOrder.setOrderDate(customerOrderDTO.getOrderDate());
        customerOrder.setStatus(customerOrderDTO.getStatus());
        CustomerOrder updatedCustomerOrder = customerOrderRepository.save(customerOrder);
        return CustomerOrderMapper.toDTO(updatedCustomerOrder);
    }

    @Override
    public void deleteCustomerOrder(Long id) {
        customerOrderRepository.deleteById(id);
    }

    @Override
    public CustomerOrderDTO getCustomerOrderById(Long id) {
        CustomerOrder customerOrder = customerOrderRepository.findById(id).orElseThrow(() -> new RuntimeException("CustomerOrder not found"));
        return CustomerOrderMapper.toDTO(customerOrder);
    }

    @Override
    public List<CustomerOrderDTO> getAllCustomerOrders() {
        return customerOrderRepository.findAll().stream().map(CustomerOrderMapper::toDTO).collect(Collectors.toList());
    }
    
}
