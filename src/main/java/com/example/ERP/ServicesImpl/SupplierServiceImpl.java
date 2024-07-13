package com.example.ERP.ServicesImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ERP.Dto.SupplierDTO;
import com.example.ERP.Mappers.SupplierMapper;
import com.example.ERP.Models.Supplier;
import com.example.ERP.Repository.SupplierRepository;
import com.example.ERP.Services.SupplierService;


@Service
public class SupplierServiceImpl  implements SupplierService {

    @Autowired
    private SupplierRepository supplierRepository;

    @Override
    public SupplierDTO createSupplier(SupplierDTO supplierDTO) {
        Supplier supplier = SupplierMapper.toEntity(supplierDTO);
        Supplier savedSupplier = supplierRepository.save(supplier);
        return SupplierMapper.toDTO(savedSupplier);
    }

    @Override
    public SupplierDTO updateSupplier(Long id, SupplierDTO supplierDTO) {
        Supplier supplier = supplierRepository.findById(id).orElseThrow(() -> new RuntimeException("Supplier not found"));
        supplier.setName(supplierDTO.getName());
        supplier.setContact(supplierDTO.getContact());
        supplier.setEmail(supplierDTO.getEmail());
        supplier.setPhone(supplierDTO.getPhone());
        Supplier updatedSupplier = supplierRepository.save(supplier);
        return SupplierMapper.toDTO(updatedSupplier);
    }

    @Override
    public void deleteSupplier(Long id) {
        supplierRepository.deleteById(id);
    }

    @Override
    public SupplierDTO getSupplierById(Long id) {
        Supplier supplier = supplierRepository.findById(id).orElseThrow(() -> new RuntimeException("Supplier not found"));
        return SupplierMapper.toDTO(supplier);
    }

    @Override
    public List<SupplierDTO> getAllSuppliers() {
        return supplierRepository.findAll().stream().map(SupplierMapper::toDTO).collect(Collectors.toList());
    }
    
}
