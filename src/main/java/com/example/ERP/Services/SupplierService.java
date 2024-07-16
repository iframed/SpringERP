package com.example.ERP.Services;

import java.util.List;

import com.example.ERP.Dto.SupplierDTO;

public interface SupplierService {
    SupplierDTO createSupplier(SupplierDTO supplierDTO);
    SupplierDTO updateSupplier(Long id, SupplierDTO supplierDTO);
    void deleteSupplier(Long id);
    SupplierDTO getSupplierById(Long id);
    List<SupplierDTO> getAllSuppliers();
    List<SupplierDTO> searchSuppliers(String name, String contact, String email, String phone, String productName);
}
