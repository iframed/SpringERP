package com.example.ERP.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ERP.Models.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Long>{
    
}
