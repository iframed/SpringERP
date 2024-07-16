package com.example.ERP.Dto;

import java.util.List;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SupplierDTO {
    private Long id;
    private String name;
    private String contact;
    private String email;
    private String phone;
    private List<ProductDTO> products;

    private List<Long> purchaseOrderIds;
}