package com.example.ERP.Repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.example.ERP.Models.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    
    @Query("SELECT p FROM Product p WHERE " +
           "(:reference IS NULL OR :reference = '' OR p.reference LIKE %:reference%) AND " +
           "(:designation IS NULL OR :designation = '' OR p.designation LIKE %:designation%) AND " +
           "(:categoryId IS NULL OR p.category.id = :categoryId) AND " +
           "(:supplierId IS NULL OR p.supplier.id = :supplierId) AND " +
           "(:city IS NULL OR :city = '' OR p.city LIKE %:city%) AND " +
           "(:disponible IS NULL OR p.disponible = :disponible)")
    List<Product> searchProducts(@Param("reference") String reference,
                                 @Param("designation") String designation,
                                 @Param("categoryId") Long categoryId,
                                 @Param("supplierId") Long supplierId,
                                 @Param("city") String city,
                                 @Param("disponible") Boolean disponible);
}
