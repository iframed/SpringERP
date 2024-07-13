package com.example.ERP.Mappers;

import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.example.ERP.Dto.CategoryDTO;
import com.example.ERP.Models.Category;
import com.example.ERP.Models.Product;

@Component
public class CategoryMapper {
    public static CategoryDTO toDTO(Category category) {
        return new CategoryDTO(
                category.getId(),
                category.getName(),
                category.getParentCategory() != null ? category.getParentCategory().getId() : null,
                category.getSubCategories() != null ? category.getSubCategories().stream().map(Category::getId).collect(Collectors.toList()) : null,
                category.getProducts() != null ? category.getProducts().stream().map(Product::getId).collect(Collectors.toList()) : null
        );
    }

    public static Category toEntity(CategoryDTO categoryDTO) {
        Category category = new Category();
        category.setId(categoryDTO.getId());
        category.setName(categoryDTO.getName());
        // parentCategory and subCategories should be set by service layer or ORM relationships
        return category;
    }
}
