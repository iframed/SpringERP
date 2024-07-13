package com.example.ERP.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ERP.Dto.PayrollDTO;
import com.example.ERP.Services.PayrollService;

@RestController
@RequestMapping("/api/payrolls")
public class PayrollController {
    @Autowired
    private PayrollService payrollService;

    @PostMapping
    public ResponseEntity<PayrollDTO> createPayroll(@RequestBody PayrollDTO payrollDTO) {
        PayrollDTO createdPayroll = payrollService.createPayroll(payrollDTO);
        return ResponseEntity.ok(createdPayroll);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PayrollDTO> updatePayroll(@PathVariable Long id, @RequestBody PayrollDTO payrollDTO) {
        PayrollDTO updatedPayroll = payrollService.updatePayroll(id, payrollDTO);
        return ResponseEntity.ok(updatedPayroll);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePayroll(@PathVariable Long id) {
        payrollService.deletePayroll(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PayrollDTO> getPayrollById(@PathVariable Long id) {
        PayrollDTO payrollDTO = payrollService.getPayrollById(id);
        return ResponseEntity.ok(payrollDTO);
    }

    @GetMapping
    public ResponseEntity<List<PayrollDTO>> getAllPayrolls() {
        List<PayrollDTO> payrolls = payrollService.getAllPayrolls();
        return ResponseEntity.ok(payrolls);
    }
}
