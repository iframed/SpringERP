package com.example.ERP.Mappers;

import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.example.ERP.Dto.ClientDTO;
import com.example.ERP.Models.Client;
import com.example.ERP.Models.CustomerOrder;
import com.example.ERP.Models.Quote;

@Component

public class ClientMapper {
    public static ClientDTO toDTO(Client client) {
        return new ClientDTO(
                client.getId(),
                client.getName(),
                client.getEmail(),
                client.getPhone(),
                client.getOrders() != null ? client.getOrders().stream().map(CustomerOrder::getId).collect(Collectors.toList()) : null,
                client.getQuotes() != null ? client.getQuotes().stream().map(Quote::getId).collect(Collectors.toList()) : null
        );
    }

    public static Client toEntity(ClientDTO clientDTO) {
        Client client = new Client();
        client.setId(clientDTO.getId());
        client.setName(clientDTO.getName());
        client.setEmail(clientDTO.getEmail());
        client.setPhone(clientDTO.getPhone());
        // orders and quotes should be set by service layer or ORM relationships
        return client;
    }
}
