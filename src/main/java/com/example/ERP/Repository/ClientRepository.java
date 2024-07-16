package com.example.ERP.Repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.ERP.Models.Client;


@Repository
public interface ClientRepository extends JpaRepository<Client , Long>{
    @Query("SELECT c FROM Client c WHERE " +
           "(:societe IS NULL OR c.societe LIKE %:societe%) AND " +
           "(:contact IS NULL OR c.contact LIKE %:contact%) AND " +
           "(:email IS NULL OR c.email LIKE %:email%) AND " +
           "(:phone IS NULL OR c.phone LIKE %:phone%) AND " +
           "(:profilSociete IS NULL OR c.profilSociete LIKE %:profilSociete%) AND " +
           "(:categorie IS NULL OR c.categorie LIKE %:categorie%) AND " +
           "(:sousCategorie IS NULL OR c.sousCategorie LIKE %:sousCategorie%) AND " +
           "(:actif IS NULL OR c.actif = :actif) AND " +
           "(:bloque IS NULL OR c.bloque = :bloque) AND " +
           "(:typeClient IS NULL OR c.typeClient LIKE %:typeClient%)")
    List<Client> searchClients(@Param("societe") String societe,
                               @Param("contact") String contact,
                               @Param("email") String email,
                               @Param("phone") String phone,
                               @Param("profilSociete") String profilSociete,
                               @Param("categorie") String categorie,
                               @Param("sousCategorie") String sousCategorie,
                               @Param("actif") Boolean actif,
                               @Param("bloque") Boolean bloque,
                               @Param("typeClient") String typeClient);
}
