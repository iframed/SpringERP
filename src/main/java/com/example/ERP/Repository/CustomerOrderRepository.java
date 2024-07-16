package com.example.ERP.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.ERP.Models.CustomerOrder;

@Repository
public interface CustomerOrderRepository extends JpaRepository<CustomerOrder,Long> {
    @Query("SELECT co FROM CustomerOrder co WHERE " +
           "(:code IS NULL OR co.code LIKE %:code%) AND " +
           "(:typeBC IS NULL OR co.typeBC = :typeBC) AND " +
           "(:typeNBT IS NULL OR co.typeNBT = :typeNBT) AND " +
           "(:projet IS NULL OR co.projet LIKE %:projet%) AND " +
           "(:actif IS NULL OR co.actif = :actif) AND " +
           "(:valide IS NULL OR co.valide = :valide) AND " +
           "(:montant IS NULL OR co.montant = :montant) AND " +
           "(:contactCadre IS NULL OR co.contactCadre LIKE %:contactCadre%) AND " +
           "(:nature IS NULL OR co.nature = :nature) AND " +
           "(:clientId IS NULL OR co.client.id = :clientId)")
    List<CustomerOrder> searchOrders(@Param("code") String code,
                                     @Param("typeBC") String typeBC,
                                     @Param("typeNBT") String typeNBT,
                                     @Param("projet") String projet,
                                     @Param("actif") Boolean actif,
                                     @Param("valide") Boolean valide,
                                     @Param("montant") Double montant,
                                     @Param("contactCadre") String contactCadre,
                                     @Param("nature") String nature,
                                     @Param("clientId") Long clientId);
}

