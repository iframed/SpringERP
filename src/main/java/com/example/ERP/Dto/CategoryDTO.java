package com.example.ERP.Dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDTO {
    private Long id;
    private String name;
    private Long parentCategoryId;
    private List<Long> subCategoryIds;
    private List<Long> productIds;
}