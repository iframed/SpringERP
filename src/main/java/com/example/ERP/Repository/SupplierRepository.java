package com.example.ERP.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.ERP.Models.Supplier;

public interface SupplierRepository  extends JpaRepository<Supplier,Long> {
    
    @Query("SELECT s FROM Supplier s LEFT JOIN s.products p WHERE " +
           "(:name IS NULL OR s.name LIKE %:name%) AND " +
           "(:contact IS NULL OR s.contact LIKE %:contact%) AND " +
           "(:email IS NULL OR s.email LIKE %:email%) AND " +
           "(:phone IS NULL OR s.phone LIKE %:phone%) AND " +
           "(:productName IS NULL OR p.name LIKE %:productName%)")
    List<Supplier> searchSuppliers(@Param("name") String name,
                                   @Param("contact") String contact,
                                   @Param("email") String email,
                                   @Param("phone") String phone,
                                   @Param("productName") String productName);

}
