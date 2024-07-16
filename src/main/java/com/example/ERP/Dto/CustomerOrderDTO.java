package com.example.ERP.Dto;

import java.time.LocalDate;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerOrderDTO {
    private Long id;
    private LocalDate orderDate;
    private String status;
    private String code;
    private String typeBC;
    private String typeNBT;
    private String projet;
    private boolean actif;
    private boolean valide;
    private Double montant;
    private String contactCadre;
    private String nature;
    private Long clientId;
    private ClientDTO client;
    private List<Long> orderItemIds;
}
