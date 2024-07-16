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
public class GoodsReceipt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate receiptDate;
    private String status;
    private String codeBL;
    private String codeBC;
    private String codeProjet;
    private String type;
    //private Long clientId;

    @ManyToOne
    private PurchaseOrder purchaseOrder;

    @ManyToOne
    private Client client;

    @OneToMany(mappedBy = "goodsReceipt", cascade = CascadeType.ALL)
    private List<GoodsReceiptItem> goodsReceiptItems;

}
