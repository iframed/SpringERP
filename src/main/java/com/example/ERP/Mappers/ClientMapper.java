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
            client.getSociete(),
            client.getContact(),
            client.getEmail(),
            client.getPhone(),
            client.getProfilSociete(),
            client.getCategorie(),
            client.getSousCategorie(),
            client.isActif(),
            client.isBloque(),
            client.getTypeClient(),
            client.getOrders() != null ? client.getOrders().stream().map(CustomerOrder::getId).collect(Collectors.toList()) : null,
            client.getQuotes() != null ? client.getQuotes().stream().map(Quote::getId).collect(Collectors.toList()) : null
        );
    }

    public static Client toEntity(ClientDTO clientDTO) {
        Client client = new Client();
        client.setId(clientDTO.getId());
        client.setSociete(clientDTO.getSociete());
        client.setContact(clientDTO.getContact());
        client.setEmail(clientDTO.getEmail());
        client.setPhone(clientDTO.getPhone());
        client.setProfilSociete(clientDTO.getProfilSociete());
        client.setCategorie(clientDTO.getCategorie());
        client.setSousCategorie(clientDTO.getSousCategorie());
        client.setActif(clientDTO.isActif());
        client.setBloque(clientDTO.isBloque());
        client.setTypeClient(clientDTO.getTypeClient());
        return client;
    }
}
