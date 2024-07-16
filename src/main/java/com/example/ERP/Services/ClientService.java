package com.example.ERP.Services;

import java.util.List;

import com.example.ERP.Dto.ClientDTO;

public interface ClientService {
    ClientDTO createClient(ClientDTO clientDTO);
    ClientDTO updateClient(Long id, ClientDTO clientDTO);
    void deleteClient(Long id);
    ClientDTO getClientById(Long id);
    List<ClientDTO> getAllClients();
    List<ClientDTO> searchClients(String societe, String contact, String email, String phone, String profilSociete, String categorie, String sousCategorie, Boolean actif, Boolean bloque, String typeClient);
}
