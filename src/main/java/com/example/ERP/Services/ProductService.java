package com.example.ERP.Services;

import java.util.List;

import com.example.ERP.Dto.ProductDTO;

public interface ProductService {
    ProductDTO createProduct(ProductDTO productDTO);
    ProductDTO updateProduct(Long id, ProductDTO productDTO);
    void deleteProduct(Long id);
    ProductDTO getProductById(Long id);
    List<ProductDTO> getAllProducts();
    List<ProductDTO> searchProducts(String reference, String designation, Long categoryId, Long supplierId, String city, Boolean disponible);

}
