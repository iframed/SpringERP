package com.example.ERP.Dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientDTO {
    private Long id;
    private String societe;
    private String contact;
    private String email;
    private String phone;
    private String profilSociete;
    private String categorie;
    private String sousCategorie;
    private boolean actif;
    private boolean bloque;
    private String typeClient;
    private List<Long> orderIds;
    private List<Long> quoteIds;
}
