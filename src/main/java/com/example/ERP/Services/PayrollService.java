package com.example.ERP.Services;

import java.util.List;

import com.example.ERP.Dto.PayrollDTO;

public interface PayrollService {
    PayrollDTO createPayroll(PayrollDTO payrollDTO);
    PayrollDTO updatePayroll(Long id, PayrollDTO payrollDTO);
    void deletePayroll(Long id);
    PayrollDTO getPayrollById(Long id);
    List<PayrollDTO> getAllPayrolls();
}
