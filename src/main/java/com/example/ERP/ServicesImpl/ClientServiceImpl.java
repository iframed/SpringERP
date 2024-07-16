package com.example.ERP.ServicesImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ERP.Dto.ClientDTO;
import com.example.ERP.Mappers.ClientMapper;
import com.example.ERP.Models.Client;
import com.example.ERP.Repository.ClientRepository;
import com.example.ERP.Services.ClientService;


@Service
public class ClientServiceImpl  implements ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public ClientDTO createClient(ClientDTO clientDTO) {
        Client client = ClientMapper.toEntity(clientDTO);
        Client savedClient = clientRepository.save(client);
        return ClientMapper.toDTO(savedClient);
    }

    @Override
    public ClientDTO updateClient(Long id, ClientDTO clientDTO) {
        Client client = clientRepository.findById(id).orElseThrow(() -> new RuntimeException("Client not found"));
        client.setCategorie(clientDTO.getCategorie());
        client.setEmail(clientDTO.getEmail());
        client.setPhone(clientDTO.getPhone());
        Client updatedClient = clientRepository.save(client);
        return ClientMapper.toDTO(updatedClient);
    }

    @Override
    public void deleteClient(Long id) {
        clientRepository.deleteById(id);
    }

    @Override
    public ClientDTO getClientById(Long id) {
        Client client = clientRepository.findById(id).orElseThrow(() -> new RuntimeException("Client not found"));
        return ClientMapper.toDTO(client);
    }

    @Override
    public List<ClientDTO> getAllClients() {
        return clientRepository.findAll().stream().map(ClientMapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public List<ClientDTO> searchClients(String societe, String contact, String email, String phone, String profilSociete, String categorie, String sousCategorie, Boolean actif, Boolean bloque, String typeClient) {
        List<Client> clients = clientRepository.searchClients(societe, contact, email, phone, profilSociete, categorie, sousCategorie, actif, bloque, typeClient);
        return clients.stream().map(ClientMapper::toDTO).collect(Collectors.toList());
    }
}
