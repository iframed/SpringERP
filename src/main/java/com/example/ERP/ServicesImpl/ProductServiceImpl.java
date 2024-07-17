package com.example.ERP.ServicesImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ERP.Dto.ProductDTO;
import com.example.ERP.Mappers.ProductMapper;
import com.example.ERP.Models.Category;
import com.example.ERP.Models.Product;
import com.example.ERP.Models.Supplier;
import com.example.ERP.Repository.ProductRepository;
import com.example.ERP.Services.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public ProductDTO createProduct(ProductDTO productDTO) {
        Product product = ProductMapper.toEntity(productDTO);
        
        if (productDTO.getCategoryId() != null) {
            Category category = new Category();
            category.setId(productDTO.getCategoryId());
            product.setCategory(category);
        }

        if (productDTO.getSupplierId() != null) {
            Supplier supplier = new Supplier();
            supplier.setId(productDTO.getSupplierId());
            product.setSupplier(supplier);
        }

        Product savedProduct = productRepository.save(product);
        return ProductMapper.toDTO(savedProduct);
    }

    @Override
    public ProductDTO updateProduct(Long id, ProductDTO productDTO) {
        Product product = productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
        product.setReference(productDTO.getReference());
        product.setDesignation(productDTO.getDesignation());
        product.setPrice(productDTO.getPrice());
        product.setName(productDTO.getName());

        // Update category if provided
        if (productDTO.getCategoryId() != null) {
            Category category = new Category();
            category.setId(productDTO.getCategoryId());
            product.setCategory(category);
        }

        // Update supplier if provided
        if (productDTO.getSupplierId() != null) {
            Supplier supplier = new Supplier();
            supplier.setId(productDTO.getSupplierId());
            product.setSupplier(supplier);
        }

        product.setCity(productDTO.getCity());
        product.setDisponible(productDTO.isDisponible());

        // Save updated product
        Product updatedProduct = productRepository.save(product);
        return ProductMapper.toDTO(updatedProduct);
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public ProductDTO getProductById(Long id) {
        Product product = productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
        return ProductMapper.toDTO(product);
    }

    @Override
    public List<ProductDTO> getAllProducts() {
        return productRepository.findAll().stream().map(ProductMapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public List<ProductDTO> searchProducts(String reference, String designation, Long categoryId, Long supplierId, String city, Boolean disponible) {
        List<Product> products = productRepository.searchProducts(
            reference, designation, categoryId, supplierId, city, disponible);
        return products.stream().map(ProductMapper::toDTO).collect(Collectors.toList());
    }
}
