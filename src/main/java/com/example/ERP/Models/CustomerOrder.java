package com.example.ERP.Models;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
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
public class CustomerOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    @ManyToOne
    private Client client;
    
    @OneToMany(mappedBy = "customerOrder", cascade = CascadeType.ALL)
    private List<OrderItem> orderItems;

}
