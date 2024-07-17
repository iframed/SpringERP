package com.example.ERP.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ERP.Models.InvoiceItem;

@Repository
public interface InvoiceItemRepository extends JpaRepository<InvoiceItem,Long>{
    List<InvoiceItem> findByInvoiceId(Long invoiceId);
}
