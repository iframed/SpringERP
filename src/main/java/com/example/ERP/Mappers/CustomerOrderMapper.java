package com.example.ERP.Mappers;

import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.example.ERP.Dto.CustomerOrderDTO;
import com.example.ERP.Models.Client;
import com.example.ERP.Models.CustomerOrder;
import com.example.ERP.Models.OrderItem;

@Component
public class CustomerOrderMapper {
    public static CustomerOrderDTO toDTO(CustomerOrder customerOrder) {
        return new CustomerOrderDTO(
            customerOrder.getId(),
            customerOrder.getOrderDate(),
            customerOrder.getStatus(),
            customerOrder.getCode(), // Assurez-vous que ce champ existe dans CustomerOrder
            customerOrder.getTypeBC(), // Assurez-vous que ce champ existe dans CustomerOrder
            customerOrder.getTypeNBT(), // Assurez-vous que ce champ existe dans CustomerOrder
            customerOrder.getProjet(), // Assurez-vous que ce champ existe dans CustomerOrder
            customerOrder.isActif(),
            customerOrder.isValide(),
            customerOrder.getMontant(), // Assurez-vous que ce champ existe dans CustomerOrder
            customerOrder.getContactCadre(), // Assurez-vous que ce champ existe dans CustomerOrder
            customerOrder.getNature(), // Assurez-vous que ce champ existe dans CustomerOrder
            customerOrder.getClient() != null ? customerOrder.getClient().getId() : null,
            customerOrder.getClient() != null ? ClientMapper.toDTO(customerOrder.getClient()) : null,
            customerOrder.getOrderItems() != null ? customerOrder.getOrderItems().stream().map(OrderItem::getId).collect(Collectors.toList()) : null
        );
    }

    public static CustomerOrder toEntity(CustomerOrderDTO customerOrderDTO) {
        CustomerOrder customerOrder = new CustomerOrder();
        customerOrder.setId(customerOrderDTO.getId());
        customerOrder.setOrderDate(customerOrderDTO.getOrderDate());
        customerOrder.setStatus(customerOrderDTO.getStatus());
        customerOrder.setCode(customerOrderDTO.getCode()); // Assurez-vous que ce champ existe dans CustomerOrder
        customerOrder.setTypeBC(customerOrderDTO.getTypeBC()); // Assurez-vous que ce champ existe dans CustomerOrder
        customerOrder.setTypeNBT(customerOrderDTO.getTypeNBT()); // Assurez-vous que ce champ existe dans CustomerOrder
        customerOrder.setProjet(customerOrderDTO.getProjet()); // Assurez-vous que ce champ existe dans CustomerOrder
        customerOrder.setActif(customerOrderDTO.isActif());
        customerOrder.setValide(customerOrderDTO.isValide());
        customerOrder.setMontant(customerOrderDTO.getMontant()); // Assurez-vous que ce champ existe dans CustomerOrder
        customerOrder.setContactCadre(customerOrderDTO.getContactCadre()); // Assurez-vous que ce champ existe dans CustomerOrder
        customerOrder.setNature(customerOrderDTO.getNature()); // Assurez-vous que ce champ existe dans CustomerOrder
        // Vous devrez peut-être gérer la liaison de client et orderItems ici également
        if (customerOrderDTO.getClientId() != null) {
            Client client = new Client();
            client.setId(customerOrderDTO.getClientId());
            customerOrder.setClient(client);
        }
        
        return customerOrder;
    }
    }

