package com.example.ERP.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.ERP.Dto.ProductDTO;
import com.example.ERP.Services.ProductService;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/api/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping
    public ResponseEntity<ProductDTO> createProduct(@RequestBody ProductDTO productDTO) {
        ProductDTO createdProduct = productService.createProduct(productDTO);
        return ResponseEntity.ok(createdProduct);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductDTO> updateProduct(@PathVariable Long id, @RequestBody ProductDTO productDTO) {
        ProductDTO updatedProduct = productService.updateProduct(id, productDTO);
        return ResponseEntity.ok(updatedProduct);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> getProductById(@PathVariable Long id) {
        ProductDTO productDTO = productService.getProductById(id);
        return ResponseEntity.ok(productDTO);
    }

    @GetMapping
    public ResponseEntity<List<ProductDTO>> getAllProducts() {
        List<ProductDTO> products = productService.getAllProducts();
        return ResponseEntity.ok(products);
    }


    @GetMapping("/search")
    public ResponseEntity<List<ProductDTO>> searchProducts(
            @RequestParam(required = false) String reference,
            @RequestParam(required = false) String designation,
            @RequestParam(required = false) Long categoryId,
            @RequestParam(required = false) Long supplierId,
            @RequestParam(required = false) String city,
            @RequestParam(required = false) Boolean disponible) {
        List<ProductDTO> products = productService.searchProducts(reference, designation, categoryId, supplierId, city, disponible);
        return ResponseEntity.ok(products);
    }
}
