package com.example.ERP.Repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ERP.Models.Client;


@Repository
public interface ClientRepository extends JpaRepository<Client , Long>{
    
}
