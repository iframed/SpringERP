package com.example.ERP.Models;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Client {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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


    @OneToMany(mappedBy = "client")
    private List<CustomerOrder> orders;

    @OneToMany(mappedBy = "client")
    private List<Quote> quotes;


}
